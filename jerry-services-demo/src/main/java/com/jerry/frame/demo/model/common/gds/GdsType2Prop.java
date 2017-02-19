package com.jerry.frame.demo.model.common.gds;

import java.util.Date;

public class GdsType2Prop {
    private Long typeId;

    private Long propId;

    private String ifBasic;

    private String ifHaveto;

    private String ifSearch;

    private String ifGdsInput;

    private String status;

    private Date createTime;

    private Long createStaff;

    private Date updateTime;

    private Long updateStaff;

    private String ifAbleEdit;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getPropId() {
        return propId;
    }

    public void setPropId(Long propId) {
        this.propId = propId;
    }

    public String getIfBasic() {
        return ifBasic;
    }

    public void setIfBasic(String ifBasic) {
        this.ifBasic = ifBasic;
    }

    public String getIfHaveto() {
        return ifHaveto;
    }

    public void setIfHaveto(String ifHaveto) {
        this.ifHaveto = ifHaveto;
    }

    public String getIfSearch() {
        return ifSearch;
    }

    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch;
    }

    public String getIfGdsInput() {
        return ifGdsInput;
    }

    public void setIfGdsInput(String ifGdsInput) {
        this.ifGdsInput = ifGdsInput;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public String getIfAbleEdit() {
        return ifAbleEdit;
    }

    public void setIfAbleEdit(String ifAbleEdit) {
        this.ifAbleEdit = ifAbleEdit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", propId=").append(propId);
        sb.append(", ifBasic=").append(ifBasic);
        sb.append(", ifHaveto=").append(ifHaveto);
        sb.append(", ifSearch=").append(ifSearch);
        sb.append(", ifGdsInput=").append(ifGdsInput);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createStaff=").append(createStaff);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateStaff=").append(updateStaff);
        sb.append(", ifAbleEdit=").append(ifAbleEdit);
        sb.append("]");
        return sb.toString();
    }
}