package com.zyf.busilog.operlog.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_BUSI_OPER_LOG_PARAM_TC")
public class BusiOperLogParam implements Serializable {

    private static final long serialVersionUID = 6718170710446952230L;

    /**
     * 参数ID
     */
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "PARAM_ID")
    private String paramId;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 编码
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 排序
     */
    @Column(name = "SORT")
    private String sort;

    /**
     * 父参数编码
     */
    @Column(name = "PARA_CODE")
    private String paraCode;

    /**
     * 删除标识
     */
    @Column(name = "DEL_FLG")
    private String delFlg;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private String updateTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_MAN")
    private String createMan;

    /**
     * 最后修改人
     */
    @Column(name = "LAST_MODI_MAN")
    private String lastModiMan;

    public String getParamId() {
        return this.paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getParaCode() {
        return this.paraCode;
    }

    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }

    public String getDelFlg() {
        return this.delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateMan() {
        return this.createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getLastModiMan() {
        return this.lastModiMan;
    }

    public void setLastModiMan(String lastModiMan) {
        this.lastModiMan = lastModiMan;
    }

    @Override
    public String toString() {
        return "{" +
                "paramId='" + paramId + '\'' +
                "name='" + name + '\'' +
                "code='" + code + '\'' +
                "sort='" + sort + '\'' +
                "paraCode='" + paraCode + '\'' +
                "delFlg='" + delFlg + '\'' +
                "createTime='" + createTime + '\'' +
                "updateTime='" + updateTime + '\'' +
                "createMan='" + createMan + '\'' +
                "lastModiMan='" + lastModiMan + '\'' +
                '}';
    }

}
