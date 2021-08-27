package com.zyf.busilog.operlog.service;

import com.zyf.busilog.operlog.dao.entity.BusiOperCond;
import com.zyf.busilog.operlog.dao.entity.BusiOperData;
import com.zyf.busilog.operlog.dao.entity.BusiOperLog;
import com.zyf.busilog.operlog.model.BusiOperCondSaveRequest;
import com.zyf.busilog.operlog.model.BusiOperDataSaveRequest;
import com.zyf.busilog.operlog.model.BusiOperLogQryRequest;
import com.zyf.busilog.operlog.model.BusiOperLogQryResponse;
import com.zyf.busilog.operlog.model.BusiOperLogSaveRequest;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 业务操作日志服务
 *
 * @author zhangyf
 */
@Service
public interface BusiOperLogService {

    /**
     * 保存日志
     *
     * @param log 日志查询请求参数
     * @return 参数校验消息，如果参数无误则返回空
     * @throws Exception
     */
    List<String> saveLog(BusiOperLogSaveRequest log);

    /**
     * 保存日志
     *
     * @param log      日志
     * @param condList 操作条件
     * @param dataList 业务数据
     * @return 参数校验消息，如果参数无误则返回空
     * @throws Exception
     */
    List<String> saveLog(BusiOperLogSaveRequest log, List<BusiOperCondSaveRequest> condList, List<BusiOperDataSaveRequest> dataList);

    /**
     * 日志分页列表查询
     *
     * @param log
     * @return
     */
    Page<BusiOperLogQryResponse> logPageQry(BusiOperLogQryRequest log);

    /**
     * 日志详情查询
     *
     * @param logId
     * @return
     */
    BusiOperLogQryResponse logDetailQry(@Length(max = 36, message = "日志ID长度不能超过36")
                                        @NotEmpty(message = "日志ID不能为空") String logId);

    /**
     * 日志详情及子表数据查询
     * <p>
     * 但未进行日志参数文本转换
     * <p>
     * 子表：操作条件，业务数据
     *
     * @param logId
     * @return
     */
    BusiOperLog logDetailWithSubQry(@Length(max = 36, message = "日志ID长度不能超过36")
                                    @NotEmpty(message = "日志ID不能为空") String logId);

    /**
     * 业务操作条件列表查询
     */
    List<BusiOperCond> condListQry(@Length(max = 36, message = "日志ID长度不能超过36")
                                   @NotEmpty(message = "日志ID不能为空") String logId);

    /**
     * 业务操作条件详情查询
     */
    BusiOperCond condDetailQry(@Length(max = 36, message = "条件ID长度不能超过36")
                               @NotEmpty(message = "条件ID不能为空") String condId);

    /**
     * 历史数据列表查询
     */
    List<BusiOperData> dataListQry(@Length(max = 36, message = "日志ID长度不能超过36")
                                   @NotEmpty(message = "日志ID不能为空") String logId);

    /**
     * 历史数据详情查询
     */
    BusiOperData dataDetailQry(@Length(max = 36, message = "历史数据ID长度不能超过36")
                               @NotEmpty(message = "历史数据ID不能为空") String hisId);

    /**
     * 全部企业日志批量删除
     */
    int logDeleteBat();

    /**
     * 企业日志批量删除
     *
     * @param etpId 企业ID
     */
    int logDeleteBatByEtpId(@Length(max = 36, message = "企业ID长度不能超过36")
                            @NotEmpty(message = "企业ID不能为空") String etpId);

    /**
     * 导出日志分页
     *
     * @param log 日志查询请求参数
     * @return 文件名
     */
    String exportLogPage(@Valid BusiOperLogQryRequest log);
}
