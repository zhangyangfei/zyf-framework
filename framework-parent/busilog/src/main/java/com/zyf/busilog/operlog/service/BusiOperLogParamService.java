package com.zyf.busilog.operlog.service;

import com.zyf.busilog.operlog.dao.entity.BusiOperLogParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusiOperLogParamService {

    /**
     * 查询子参数列表
     * <p>
     * 如果父参数代码为空，则查询所有父参数
     *
     * @param paraCode
     * @return
     */
    List<BusiOperLogParam> paramListQryByParaCode(@Length(max = 32, message = "父参数代码长度不能超过32") String paraCode);
}
