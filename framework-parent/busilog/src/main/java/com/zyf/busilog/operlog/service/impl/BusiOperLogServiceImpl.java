package com.zyf.busilog.operlog.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zyf.busilog.common.utils.CustomCellWriteHandler;
import com.zyf.busilog.common.utils.DateHelper;
import com.zyf.busilog.operlog.constants.BusiLogConstants;
import com.zyf.busilog.operlog.dao.entity.BusiOperCond;
import com.zyf.busilog.operlog.dao.entity.BusiOperData;
import com.zyf.busilog.operlog.dao.entity.BusiOperLog;
import com.zyf.busilog.operlog.dao.repository.BusiOperCondRepository;
import com.zyf.busilog.operlog.dao.repository.BusiOperDataRepository;
import com.zyf.busilog.operlog.dao.repository.BusiOperLogRepository;
import com.zyf.busilog.operlog.model.BusiOperCondSaveRequest;
import com.zyf.busilog.operlog.model.BusiOperDataSaveRequest;
import com.zyf.busilog.operlog.model.BusiOperLogQryRequest;
import com.zyf.busilog.operlog.model.BusiOperLogQryResponse;
import com.zyf.busilog.operlog.model.BusiOperLogSaveRequest;
import com.zyf.busilog.operlog.service.BusiOperLogService;
import com.zyf.busilog.operlog.utils.BusiLogUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Validated
public class BusiOperLogServiceImpl implements BusiOperLogService {

    private final Logger logger = LoggerFactory.getLogger(BusiOperLogServiceImpl.class);

    @Autowired
    private BusiOperLogRepository busiOperLogRepository;

    @Autowired
    private BusiOperCondRepository busiOperCondRepository;

    @Autowired
    private BusiOperDataRepository busiOperDataRepository;

    @Autowired
    private HttpServletRequest servletRequest;

    @PersistenceContext
    private EntityManager entityManager;


    @Value("${busilog.keeplong:12}")
    private int logKeepLong;

    /**
     * 日志的公共查询SQL
     */
    private static final String BUSI_LOG_QUERY_SQL =
            "SELECT\n" +
                    "t1.LOG_ID \"logId\",\n" +
                    "t1.BUSI_CODE \"busiCode\",\n" +
                    "t1.ETP_ID \"etpId\",\n" +
                    "t1.BUSI_TYPE \"busiType\",\n" +
                    "t1.OPER_TYPE \"operType\",\n" +
                    "t1.TRAN_CODE \"tranCode\",\n" +
                    "t1.OPER_ABST \"operAbst\",\n" +
                    "t1.OPER_RESU \"operResu\",\n" +
                    "t1.OPER_TIME \"operTime\",\n" +
                    "t1.OPERATOR_ID \"operatorId\",\n" +
                    "t1.CAN_DELETE \"canDelete\",\n" +
                    "t1.KEEP_TIME \"keepTime\",\n" +
                    "t1.NOTE \"note\",\n" +
                    "t2.name \"operatorName\",\n" +
                    "PARAM1.NAME \"busiTypeTxt\",\n" +
                    "PARAM2.NAME \"operTypeTxt\"\n" +
                    "FROM\n" +
                    "T_BUSI_OPER_LOG_TD t1\n" +
                    "LEFT JOIN T_CUSTOM_INFO_TD T2 ON t1.OPERATOR_ID = T2.EMP_NO\n" +
                    "LEFT JOIN T_BUSI_OPER_LOG_PARAM_TC PARAM1 ON T1.BUSI_TYPE = PARAM1.CODE AND PARAM1.PARA_CODE = 'BUSI_TYPE' AND PARAM1.DEL_FLG='N'\n" +
                    "LEFT JOIN T_BUSI_OPER_LOG_PARAM_TC PARAM2 ON T1.OPER_TYPE = PARAM2.CODE AND PARAM2.PARA_CODE = 'OPER_TYPE' AND PARAM2.DEL_FLG='N'\n" +
                    "WHERE 1=1\n";

    @Override
    public List<String> saveLog(BusiOperLogSaveRequest log) {
        return saveLog(log, null, null);
    }

    @Override
    public List<String> saveLog(BusiOperLogSaveRequest log, List<BusiOperCondSaveRequest> condList, List<BusiOperDataSaveRequest> dataList) {
        List<String> errorList = new ArrayList<>();
        errorList.addAll(this.validParam(log));
        errorList.addAll(this.validParam(condList));
        errorList.addAll(this.validParam(dataList));
        if (!CollectionUtils.isEmpty(errorList)) {
            logger.error("保存业务操作日志，参数错误：{}", errorList);
            return errorList;
        }
        BusiOperLog busiOperLog = new BusiOperLog();
        BeanUtils.copyProperties(log, busiOperLog);
        busiOperLog.setOperResu(StringUtils.isEmpty(log.getOperResu()) ? "成功" : log.getOperResu());
        busiOperLog.setCanDelete(StringUtils.isEmpty(log.getCanDelete()) ? BusiLogConstants.YESORNO_YES.getCode() : log.getCanDelete());
        if (StringUtils.equals(BusiLogConstants.YESORNO_YES.getCode(), busiOperLog.getCanDelete())) {
            int keepLong = log.getKeepLong() == 0 ? logKeepLong : log.getKeepLong();
            busiOperLog.setKeepTime(DateHelper.getNextMonthString(new Date(), keepLong, DateHelper.SDF_YMDHMS1));
        }
        if (StringUtils.isBlank(busiOperLog.getEtpId())) {
            busiOperLog.setEtpId("111111111");
        }
        if (StringUtils.isBlank(busiOperLog.getOperatorId())) {
            busiOperLog.setOperatorId("2222222");
        }
        busiOperLog.setOperTime(DateHelper.getDateString(new Date(), DateHelper.SDF_YMDHMS1));
        if (!CollectionUtils.isEmpty(condList)) {
            List<BusiOperCond> busiOperConds = new ArrayList<>();
            for (BusiOperCondSaveRequest cond : condList) {
                BusiOperCond busiOperCond = new BusiOperCond();
                busiOperCond.setAbst(cond.getCondAbst());
                busiOperCond.setJsonClass(cond.getCondData().getClass().getName());
                busiOperCond.setCondJson(BusiLogUtils.objToJsonStr(cond.getCondData()));
                busiOperCond.setLog(busiOperLog);
                busiOperConds.add(busiOperCond);
            }
            busiOperLog.setConds(busiOperConds);
        }
        if (!CollectionUtils.isEmpty(dataList)) {
            List<BusiOperData> busiOperDatas = new ArrayList<>();
            for (BusiOperDataSaveRequest data : dataList) {
                BusiOperData busiOperData = new BusiOperData();
                busiOperData.setDataAbst(data.getDataAbst());
                busiOperData.setTabName(data.getTabName());
                busiOperData.setJsonClass(data.getHisData().getClass().getName());
                busiOperData.setDataJson(BusiLogUtils.objToJsonStr(data.getHisData()));
                busiOperData.setLog(busiOperLog);
                busiOperDatas.add(busiOperData);
            }
            busiOperLog.setDatas(busiOperDatas);
        }
        busiOperLogRepository.save(busiOperLog);
        return null;
    }

    @Override
    public Page<BusiOperLogQryResponse> logPageQry(BusiOperLogQryRequest log) {
        int pageNum = log.getPage();
        int pageSize = log.getSize();
        String sql = BUSI_LOG_QUERY_SQL;
        if (!StringUtils.isEmpty(log.getBusiCode())) {
            sql += "AND UPPER(t1.BUSI_CODE) LIKE '%' || UPPER('" + log.getBusiCode() + "') ||'%'\n";
        }
        if (!StringUtils.isEmpty(log.getEtpId())) {
            sql += "AND t1.ETP_ID = '" + log.getEtpId() + "'\n";
        }
        if (!CollectionUtils.isEmpty(log.getBusiTypes())) {
            String typeStr = "";
            for (String type : log.getBusiTypes()) {
                if (StringUtils.isNotEmpty(typeStr))
                    typeStr += ",";
                typeStr += "'" + type + "'";
            }
            sql += "AND t1.BUSI_TYPE IN (" + typeStr + ")\n";
        }
        if (!CollectionUtils.isEmpty(log.getOperTypes())) {
            String typeStr = "";
            for (String type : log.getOperTypes()) {
                if (StringUtils.isNotEmpty(typeStr))
                    typeStr += ",";
                typeStr += "'" + type + "'";
            }
            sql += "AND t1.OPER_TYPE IN (" + typeStr + ")\n";
        }
        if (!StringUtils.isEmpty(log.getTranCode())) {
            sql += "AND UPPER(t1.TRAN_CODE) LIKE '%' || UPPER('" + log.getTranCode() + "') ||'%'\n";
        }
        if (!StringUtils.isEmpty(log.getOperAbst())) {
            sql += "AND UPPER(t1.OPER_ABST) LIKE '%' || UPPER('" + log.getOperAbst() + "') ||'%'\n";
        }
        if (!StringUtils.isEmpty(log.getOperResu())) {
            sql += "AND UPPER(t1.OPER_RESU) LIKE '%' || UPPER('" + log.getOperResu() + "') ||'%'\n";
        }
        if (!StringUtils.isEmpty(log.getOperTimeStart())) {
            sql += "AND UPPER(t1.OPER_TIME) >= '" + log.getOperTimeStart() + "'\n";
        }
        if (!StringUtils.isEmpty(log.getOperTimeEnd())) {
            String timeEnd = log.getOperTimeEnd();
            if (timeEnd.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                timeEnd += " 23:59:59";
            }
            sql += "AND UPPER(t1.OPER_TIME) <= '" + timeEnd + "'\n";
        }
        if (!StringUtils.isEmpty(log.getOperatorId())) {
            sql += "AND t1.OPERATOR_ID ='" + log.getOperatorId() + "'\n";
        }
        if (!StringUtils.isEmpty(log.getOperatorName())) {
            sql += "AND UPPER(t2.NAME) LIKE '%' || UPPER('" + log.getOperatorName() + "') ||'%'\n";
        }
        String sqlTotal = "SELECT COUNT(1)\n" +
                "FROM (\n" +
                sql
                + ")";
        BigDecimal total = (BigDecimal) entityManager.createNativeQuery(sqlTotal).getSingleResult();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        if (0 == total.compareTo(BigDecimal.ZERO)) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }
        Query nativeQuery = entityManager.createNativeQuery(sql + " ORDER BY t1.OPER_TIME DESC");
        nativeQuery.setFirstResult(pageSize * (pageNum - 1));
        nativeQuery.setMaxResults(pageSize);
        List<Object[]> objectList = nativeQuery.getResultList();
        List<BusiOperLogQryResponse> resultList = objectList.stream().map(
                row -> {
                    BusiOperLogQryResponse bpsr = new BusiOperLogQryResponse();
                    bpsr.setLogId(ObjectUtils.toString(row[0]));
                    bpsr.setBusiCode(ObjectUtils.toString(row[1]));
                    bpsr.setEtpId(ObjectUtils.toString(row[2]));
                    bpsr.setBusiType(ObjectUtils.toString(row[3]));
                    bpsr.setOperType(ObjectUtils.toString(row[4]));
                    bpsr.setTranCode(ObjectUtils.toString(row[5]));
                    bpsr.setOperAbst(ObjectUtils.toString(row[6]));
                    bpsr.setOperResu(ObjectUtils.toString(row[7]));
                    bpsr.setOperTime(ObjectUtils.toString(row[8]));
                    bpsr.setOperatorId(ObjectUtils.toString(row[9]));
                    bpsr.setCanDelete(ObjectUtils.toString(row[10]));
                    bpsr.setKeepTime(ObjectUtils.toString(row[11]));
                    bpsr.setNote(ObjectUtils.toString(row[12]));
                    bpsr.setOperatorName(ObjectUtils.toString(row[13]));
                    bpsr.setBusiTypeTxt(ObjectUtils.toString(row[14]));
                    bpsr.setOperTypeTxt(ObjectUtils.toString(row[15]));
                    if (StringUtils.isEmpty(bpsr.getOperAbst())) {
                        bpsr.setOperAbst("【" + bpsr.getBusiTypeTxt() + "】" + "【" + bpsr.getOperTypeTxt() + "】" + bpsr.getBusiCode() + bpsr.getOperResu());
                    }
                    return bpsr;
                }
        ).collect(Collectors.toList());
        PageImpl page = new PageImpl<>(resultList, pageable, total.longValue());
        return page;
    }

    @Override
    public BusiOperLogQryResponse logDetailQry(String logId) {
        String sql = BUSI_LOG_QUERY_SQL + "AND t1.LOG_ID =:logId\n";
        Query nativeQuery = entityManager.createNativeQuery(sql)
                .unwrap(NativeQuery.class)
                .setResultTransformer(Transformers.aliasToBean(BusiOperLogQryResponse.class))
                .setParameter("logId", logId);
        List<BusiOperLogQryResponse> logList = nativeQuery.getResultList();
        return CollectionUtils.isEmpty(logList) ? null : logList.get(0);
    }

    @Override
    public BusiOperLog logDetailWithSubQry(String logId) {
        return busiOperLogRepository.findById(logId).orElse(null);
    }

    @Override
    @Transactional
    public int logDeleteBat() {
        return logDeleteBatByEtpId(null);
    }

    @Override
    @Transactional
    public int logDeleteBatByEtpId(String etpId) {
        String dateStr = DateHelper.getDateString(DateHelper.SDF_YMDHMS1);
        int count;
        if (StringUtils.isEmpty(etpId)) {
            count = busiOperLogRepository.deleteByCanDeleteAndKeepTimeBefore(BusiLogConstants.YESORNO_YES.getCode(), dateStr);
        } else {
            count = busiOperLogRepository.deleteByEtpIdAndCanDeleteAndKeepTimeBefore(etpId, BusiLogConstants.YESORNO_YES.getCode(), dateStr);
        }
        logger.info("删除日志：删除保留期限在[{}]前的共[{}]条日志", dateStr, count);
        return count;
    }

    @Override
    public List<BusiOperCond> condListQry(String logId) {
        return busiOperCondRepository.findAllByLog_LogId(logId);
    }

    @Override
    public BusiOperCond condDetailQry(String condId) {
        return busiOperCondRepository.findByCondId(condId);
    }

    @Override
    public List<BusiOperData> dataListQry(String logId) {
        return busiOperDataRepository.findAllByLog_LogId(logId);
    }

    @Override
    public BusiOperData dataDetailQry(String hisId) {
        return busiOperDataRepository.findByHisId(hisId);
    }


    @Override
    public String exportLogPage(BusiOperLogQryRequest log) {
        Page<BusiOperLogQryResponse> page = this.logPageQry(log);
        List<BusiOperLogQryResponse> logData = page.getContent();
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        File file = new File("E:/log/", fileName + ".xlsx");
        List<List<String>> head = generateExcelHead();
        List<List<Object>> dataRows = new ArrayList<>();
        logData.forEach(data -> {
            List<Object> dataRow = new ArrayList<>();
            dataRow.add(data.getOperatorName());
            dataRow.add(data.getOperTime());
            dataRow.add(data.getOperTypeTxt());
            dataRow.add(data.getOperAbst());
            dataRows.add(dataRow);
        });
        EasyExcel.write(file)
                .head(head)
                .registerWriteHandler(new CustomCellWriteHandler())
                .sheet("操作日志")
                .doWrite(dataRows);
        return fileName;
    }

    private List<List<String>> generateExcelHead() {
        List<List<String>> headRow = new ArrayList<>();
        headRow.add(createHead("姓名"));
        headRow.add(createHead("操作时间"));
        headRow.add(createHead("操作类型"));
        headRow.add(createHead("操作日志"));
        return headRow;
    }

    private List<String> createHead(String headName) {
        List<String> head = new ArrayList<>();
        head.add(headName);
        return head;
    }

    private List<String> validParam(Object param) {
        List<String> errorList = new ArrayList<>();
        if (null == param) {
            return errorList;
        }
        if (param instanceof List) {
            ((List) param).forEach(obj -> {
                errorList.addAll(this.validObj(obj));
            });
        } else {
            errorList.addAll(this.validObj(param));
        }
        return errorList;
    }

    private List<String> validObj(Object param) {
        List<String> errorList = new ArrayList<>();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(param);
        if (CollectionUtils.isEmpty(set)) {
            return errorList;
        }
        set.forEach(item -> {
            errorList.add(item.getPropertyPath() + ":" + item.getMessage());
        });
        return errorList;
    }
}
