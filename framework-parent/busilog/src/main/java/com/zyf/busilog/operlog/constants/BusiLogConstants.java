package com.zyf.busilog.operlog.constants;

/**
 * 业务日志枚举
 */
public enum BusiLogConstants {
    // 业务操作_业务类型
    BUSI_TYPE("业务类型", "BUSI_TYPE"),
    BUSI_TYPE_COMMON("公共", "COMMON"),
    BUSI_TYPE_LOGIN("登录", "LOGIN"),
    BUSI_TYPE_AUTH("权限", "AUTH"),
    BUSI_TYPE_XZDA("薪资档案", "XZDA"),
    BUSI_TYPE_XZZ("薪资组", "XZZ"),
    BUSI_TYPE_XZJS("薪资计算", "XZJS"),
    BUSI_TYPE_DFJL("代发记录", "DFJL"),
    BUSI_TYPE_SB("社保", "SB"),
    BUSI_TYPE_GZT("工资条", "GZT"),
    BUSI_TYPE_BB("报表", "BB"),
    BUSI_TYPE_NZJ("年终奖", "NZJ"),

    // 业务操作_操作类型
    OPER_TYPE("操作类型", "OPER_TYPE"),
    OPER_TYPE_COMMON_IMPORT_DATA("导入数据", "COMMON_IMPORT_DATA"),
    OPER_TYPE_COMMON_EXPORT_DATA("下载数据", "COMMON_EXPORT_DATA"),
    OPER_TYPE_LOGIN_LOGIN("登录", "LOGIN_LOGIN"),
    OPER_TYPE_AUTH_SZZGLY("设置子管理员", "AUTH_SZZGLY"),
    OPER_TYPE_AUTH_ZGLYQZZY("主管理员权限转移", "AUTH_ZGLYQZZY"),
    OPER_TYPE_XZDA_BCZDYXZDAZD("保存自定义薪资档案字段", "XZDA_BCZDYXZDAZD"),
    OPER_TYPE_XZDA_CXTXJL("撤销调薪记录", "XZDA_CXTXJL"),
    OPER_TYPE_XZDA_PLCXTX("批量撤销调薪", "XZDA_PLCXTX"),
    OPER_TYPE_XZZ_XJXZZ("新建薪资组", "XZZ_XJXZZ"),
    OPER_TYPE_XZZ_TZSXRY("调整算薪人员", "XZZ_TZSXRY"),
    OPER_TYPE_XZZ_JRXZZ("加入薪资组", "XZZ_JRXZZ"),
    OPER_TYPE_XZZ_CXTBSXRY("重新同步算薪人员", "XZZ_CXTBSXRY"),
    OPER_TYPE_XZZ_XGGDSXRY("修改固定算薪人员", "XZZ_XGGDSXRY"),
    OPER_TYPE_XZZ_JBSZ("基本设置", "XZZ_JBSZ"),
    OPER_TYPE_XZZ_XGXZX("修改薪资项", "XZZ_XGXZX"),
    OPER_TYPE_XZZ_JSGZSZ("计税规则设置", "XZZ_JSGZSZ"),
    OPER_TYPE_XZZ_HFXZZ("恢复薪资组", "XZZ_HFXZZ"),
    OPER_TYPE_XZZ_TYXZZ("停用薪资组", "XZZ_TYXZZ"),
    OPER_TYPE_XZZ_CDSCXZZ("彻底删除薪资组", "XZZ_CDSCXZZ"),
    OPER_TYPE_XZJS_JSGZ("计算工资", "XZJS_JSGZ"),
    OPER_TYPE_XZJS_TBKQ("同步考勤", "XZJS_TBKQ"),
    OPER_TYPE_XZJS_TBSVGJJ("同步社保公积金", "XZJS_TBSVGJJ"),
    OPER_TYPE_XZJS_GSJS("个税计算", "XZJS_GSJS"),
    OPER_TYPE_XZJS_SCYHDF("生成银行代发", "XZJS_SCYHDF"),
    OPER_TYPE_DFJL_SBYJCF("失败一键重发", "DFJL_SBYJCF"),
    OPER_TYPE_DFJL_CXSCDF("重新生成代发", "DFJL_CXSCDF"),
    OPER_TYPE_SB_XZCBFA("新增参保方案", "SB_XZCBFA"),
    OPER_TYPE_SB_TZCBFA("调整参保方案", "SB_TZCBFA"),
    OPER_TYPE_SB_SCCBFA("删除参保方案", "SB_SCCBFA"),
    OPER_TYPE_SB_XZTZTB("新增、调整投保", "SB_XZTZTB"),
    OPER_TYPE_SB_YGTB("员工停保", "SB_YGTB"),
    OPER_TYPE_SB_SCYJZD("生成月结账单", "SB_SCYJZD"),
    OPER_TYPE_SB_CXSCYJZD("重新生成月结账单", "SB_CXSCYJZD"),
    OPER_TYPE_SB_BJYGZDXX("编辑员工账单信息", "SB_BJYGZDXX"),
    OPER_TYPE_SB_CXCBJL("撤销参保记录", "SB_CXCBJL"),
    OPER_TYPE_GZT_DREXCELGZT("导入excel工资条", "GZT_DREXCELGZT"),
    OPER_TYPE_GZT_YXZZSCGZT("由薪资组生成工资条", "GZT_YXZZSCGZT"),
    OPER_TYPE_GZT_SCGZT("删除工资条", "GZT_SCGZT"),
    OPER_TYPE_GZT_FSGZT("发送工资条", "GZT_FSGZT"),
    OPER_TYPE_GZT_CHGZT("撤回工资条", "GZT_CHGZT"),
    OPER_TYPE_GZT_XGGZTSZ("修改工资条设置", "GZT_XGGZTSZ"),
    OPER_TYPE_BB_XGRLCBSZ("修改人力成本设置", "BB_XGRLCBSZ"),
    OPER_TYPE_BB_XGRLCBTJX("修改人力成本统计项", "BB_XGRLCBTJX"),
    OPER_TYPE_BB_GXTJSJ("更新统计数据", "BB_GXTJSJ"),
    OPER_TYPE_NZJ_SCNZJ("删除年终奖", "NZJ_SCNZJ"),
    OPER_TYPE_NZJ_SCNZJDF("生成年终奖代发", "NZJ_SCNZJDF"),

    // 是否
    YESORNO_YES("是", "Y"),
    YESORNO_NO("否", "N");

    private String text;

    private String code;

    BusiLogConstants(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
