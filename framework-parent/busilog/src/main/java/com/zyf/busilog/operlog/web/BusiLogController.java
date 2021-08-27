package com.zyf.busilog.operlog.web;

import com.zyf.busilog.common.web.DataResponse;
import com.zyf.busilog.common.web.PagingResponse;
import com.zyf.busilog.common.web.WebResponse;
import com.zyf.busilog.operlog.dao.entity.BusiOperLogParam;
import com.zyf.busilog.operlog.model.BusiOperLogQryRequest;
import com.zyf.busilog.operlog.model.BusiOperLogQryResponse;
import com.zyf.busilog.operlog.service.BusiOperLogParamService;
import com.zyf.busilog.operlog.service.BusiOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Api(tags = "业务操作日志")
@RequestMapping("busilog")
@RestController
public class BusiLogController {

    @Autowired
    private BusiOperLogService busiOperLogService;

    @Autowired
    private BusiOperLogParamService busiOperLogParamService;

    @ApiOperation(value = "日志分页列表查询")
    @PostMapping("logPageQry")
    public PagingResponse<BusiOperLogQryResponse> logPageQry(@RequestBody BusiOperLogQryRequest log) {
        log.setEtpId("1111111");
        Page<BusiOperLogQryResponse> pageLog = busiOperLogService.logPageQry(log);
        return WebResponse.success(pageLog.getContent(), pageLog.getTotalElements(), pageLog.getNumber() + 1, pageLog.getSize());
    }

    @ApiOperation(value = "子参数列表查询")
    @GetMapping("paramListQryByParaCode")
    public DataResponse<List<BusiOperLogParam>> paramListQryByParaCode(
            @ApiParam(value = "父参数代码")
            @Length(max = 32, message = "父参数代码长度不能超过32")
            @RequestParam(required = false) String paraCode) {
        return WebResponse.success(busiOperLogParamService.paramListQryByParaCode(paraCode));
    }

    @PostMapping("exportLogPage")
    @ApiOperation(value = "导出日志分页")
    public WebResponse exportLogPage(@RequestBody BusiOperLogQryRequest log, HttpSession session) {
        log.setEtpId("11111");
        String fileName = busiOperLogService.exportLogPage(log);
        session.setAttribute("LAST-LOG-PAGE", fileName);
        return WebResponse.success();
    }

    @GetMapping("exportLogPage")
    @ApiOperation("导出日志分页")
    public void exportStaffProfile(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object reportFileName = session.getAttribute("LAST-LOG-PAGE");
        if (reportFileName == null) {
            PrintWriter writer = response.getWriter();
            writer.write("报表未生成");
            writer.flush();
            writer.close();
            return;
        }
        String fileName = "操作日志.xlsx";
        String userAgent = request.getHeader("user-agent");
        if (userAgent != null && userAgent.contains("Firefox") || userAgent.contains("Chrome") || userAgent.contains("Safari")) {
            fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        } else {
            fileName = URLEncoder.encode(fileName, "utf-8");
        }
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        File file = new File("E:/log/", reportFileName + ".xlsx");
        if (!file.exists()) {
            PrintWriter writer = response.getWriter();
            writer.write("报表未生成");
            writer.flush();
            writer.close();
            return;
        }
        FileInputStream inputStream = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        int b = 0;
        byte[] buffer = new byte[512];
        while (b != -1) {
            b = inputStream.read(buffer);
            out.write(buffer, 0, b);
        }
        inputStream.close();
        out.close();
        out.flush();
        session.removeAttribute("LAST-LOG-PAGE");
        file.deleteOnExit();
    }
}
