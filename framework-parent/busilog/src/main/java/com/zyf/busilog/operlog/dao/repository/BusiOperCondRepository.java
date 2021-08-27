package com.zyf.busilog.operlog.dao.repository;

import com.zyf.busilog.operlog.dao.entity.BusiOperCond;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusiOperCondRepository extends CrudRepository<BusiOperCond, String> {

    BusiOperCond findByCondId(String condId);

    List<BusiOperCond> findAllByLog_LogId(String logId);
}
