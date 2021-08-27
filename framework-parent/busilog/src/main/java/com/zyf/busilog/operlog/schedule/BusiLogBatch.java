package com.zyf.busilog.operlog.schedule;

import com.zyf.busilog.common.utils.DateHelper;
import com.zyf.busilog.operlog.service.BusiOperLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 业务操作日志批处理
 */
@Component
@EnableScheduling
public class BusiLogBatch {

    private final Logger logger = LoggerFactory.getLogger(BusiLogBatch.class);

    @Autowired
    private BusiOperLogService busiOperLogService;

    @Scheduled(cron = "${busilog.batch.delete-cron}")
    public void logDeleteBat() {
        long start = System.currentTimeMillis();
        logger.info("批量删除业务操作日志-开始 {}", DateHelper.getDateString(start, DateHelper.SDF_YMDHMS1));
        try {
            busiOperLogService.logDeleteBat();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("批量删除业务操作日志-异常结束");
        } finally {
            long end = System.currentTimeMillis();
            logger.info("批量删除业务操作日志-结束 {} 耗时 {} 秒", DateHelper.getDateString(end, DateHelper.SDF_YMDHMS1), (end - start) / 1000);
        }
    }
}
