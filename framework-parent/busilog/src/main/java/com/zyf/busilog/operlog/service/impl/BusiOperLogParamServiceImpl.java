package com.zyf.busilog.operlog.service.impl;

import com.zyf.busilog.operlog.dao.entity.BusiOperLogParam;
import com.zyf.busilog.operlog.dao.repository.BusiOperLogParamRepository;
import com.zyf.busilog.operlog.service.BusiOperLogParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class BusiOperLogParamServiceImpl implements BusiOperLogParamService {

    @Autowired
    private BusiOperLogParamRepository busiOperLogParamRepository;

    @Override
    public List<BusiOperLogParam> paramListQryByParaCode(String paraCode) {
        return busiOperLogParamRepository.findByParaCodeOrderBySortAsc(paraCode);
    }
}
