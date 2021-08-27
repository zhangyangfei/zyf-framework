package com.zyf.busilog.operlog.dao.repository;

import com.zyf.busilog.operlog.dao.entity.BusiOperLogParam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusiOperLogParamRepository extends CrudRepository<BusiOperLogParam, String> {

    List<BusiOperLogParam> findByParaCodeOrderBySortAsc(String paraCode);
}
