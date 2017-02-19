package com.jerry.frame.demo.model.common.gds;

import java.util.Date;

public class GdsEval {
    private Long id;

    private Long staffId;

    private String staffName;

    private Date evaluationTime;

    private Date buyTime;

    private Long gdsId;

    private String gdsName;

    private Long skuId;

    private Long shopId;

    private String orderId;

    private String orderSubId;

    private Short score;

    private Short correspondencyScore;

    private Short serviceattitudeScore;

    private Short deliveryspeedScore;

    private String content;

    private String isAnonymous;

    private Short isReply;

    private String labelNames;

    private String status;

    private Date createTime;

    private Long createStaff;

    private Date updateTime;

    private Long updateStaff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Long getGdsId() {
        return gdsId;
    }

    public void setGdsId(Long gdsId) {
        this.gdsId = gdsId;
    }

    public String getGdsName() {
        return gdsName;
    }

    public void setGdsName(String gdsName) {
        this.gdsName = gdsName;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderSubId() {
        return orderSubId;
    }

    public void setOrderSubId(String orderSubId) {
        this.orderSubId = orderSubId;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Short getCorrespondencyScore() {
        return correspondencyScore;
    }

    public void setCorrespondencyScore(Short correspondencyScore) {
        this.correspondencyScore = correspondencyScore;
    }

    public Short getServiceattitudeScore() {
        return serviceattitudeScore;
    }

    public void setServiceattitudeScore(Short serviceattitudeScore) {
        this.serviceattitudeScore = serviceattitudeScore;
    }

    public Short getDeliveryspeedScore() {
        return deliveryspeedScore;
    }

    public void setDeliveryspeedScore(Short deliveryspeedScore) {
        this.deliveryspeedScore = deliveryspeedScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(String isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Short getIsReply() {
        return isReply;
    }

    public void setIsReply(Short isReply) {
        this.isReply = isReply;
    }

    public String getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", staffId=").append(staffId);
        sb.append(", staffName=").append(staffName);
        sb.append(", evaluationTime=").append(evaluationTime);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", gdsId=").append(gdsId);
        sb.append(", gdsName=").append(gdsName);
        sb.append(", skuId=").append(skuId);
        sb.append(", shopId=").append(shopId);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSubId=").append(orderSubId);
        sb.append(", score=").append(score);
        sb.append(", correspondencyScore=").append(correspondencyScore);
        sb.append(", serviceattitudeScore=").append(serviceattitudeScore);
        sb.append(", deliveryspeedScore=").append(deliveryspeedScore);
        sb.append(", content=").append(content);
        sb.append(", isAnonymous=").append(isAnonymous);
        sb.append(", isReply=").append(isReply);
        sb.append(", labelNames=").append(labelNames);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createStaff=").append(createStaff);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateStaff=").append(updateStaff);
        sb.append("]");
        return sb.toString();
    }
}