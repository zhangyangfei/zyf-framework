package com.zyf.busilog.operlog.dao.repository;

import com.zyf.busilog.operlog.dao.entity.BusiOperData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusiOperDataRepository extends CrudRepository<BusiOperData, String> {

    BusiOperData findByHisId(String dataId);

    List<BusiOperData> findAllByLog_LogId(String logId);
}
