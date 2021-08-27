package com.zyf.busilog.operlog.dao.repository;

import com.zyf.busilog.operlog.dao.entity.BusiOperLog;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BusiOperLogRepository extends CrudRepository<BusiOperLog, String>, JpaSpecificationExecutor<BusiOperLog> {

    int deleteByCanDeleteAndKeepTimeBefore(String canDelete, String deleteTime);

    int deleteByEtpIdAndCanDeleteAndKeepTimeBefore(String etpId, String canDelete, String deleteTime);

}
