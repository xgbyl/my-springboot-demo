package com.example.demo.data.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liuyonghua
 * @desc 流数据表(包括流基本数据和节目单数据)
 * @create 2016/11/18 下午12:03
 */
@Document
public class StreamData {
    /**
     * 流ID(流名称)
     */
    @Id
    private String streamId;
    /**
     * 频道ID
     */
    private Long channelId;
    /**
     * 流组信息
     */
    private String streamGroup;
    /**
     * 生产方式 m3u8/hls
     */
//    @Range(min = 1, max = 3)
    private Integer prdMode;
    /**
     * 流基本信息(注:不包含流组信息)
     */
    private String streamInfo;
    /**
     * 中继信息
     */
    private String relayInfo;

    /**
     * 新中继信息(比较标记ip)
     */
    private String relayInfoNew;
    /**
     * 节目单开始时间
     */
    private Date beginTime;
    /**
     * 节目单结束时间
     */
    private Date endTime;
    /**
     * 备片信息
     */
    private String bakInfo;
    /**
     * 节目单信息(json格式)
     */
    private String playbillInfo;
    /**
     * 节目单数据md5
     */
    private String playbillMd5;

    public String getRelayInfoNew() {
        return relayInfoNew;
    }

    public void setRelayInfoNew(String relayInfoNew) {
        this.relayInfoNew = relayInfoNew;
    }

    /**
     * 更新类型(0:初始化/1:流更新/2:中继更新/3:节目单更新)
     */
    private Integer updateType;
    /**
     * 节目单更新时间
     */
    private Date updateTime;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getStreamGroup() {
        return streamGroup;
    }

    public void setStreamGroup(String streamGroup) {
        this.streamGroup = streamGroup;
    }

    public Integer getPrdMode() {
        if(prdMode == null){
            prdMode= 1;
        }
        return prdMode;
    }

    public void setPrdMode(Integer prdMode) {
        this.prdMode = prdMode;
    }

    public String getStreamInfo() {
        return streamInfo;
    }

    public void setStreamInfo(String streamInfo) {
        this.streamInfo = streamInfo;
    }

    public String getRelayInfo() {
        return relayInfo;
    }

    public  List<String> getRelayInfoList() {
        if(StringUtils.isEmpty(getRelayInfo())){
            return null;
        }
        List<String> list = Arrays.asList(getRelayInfo().split(","));
        return list;
    }

    public void setRelayInfo(String relayInfo) {
        this.relayInfo = relayInfo;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBakInfo() {
        return bakInfo;
    }

    public void setBakInfo(String bakInfo) {
        this.bakInfo = bakInfo;
    }

    public String getPlaybillInfo() {
        return playbillInfo;
    }

    public void setPlaybillInfo(String playbillInfo) {
        this.playbillInfo = playbillInfo;
    }

    public String getPlaybillMd5() {
        return playbillMd5;
    }

    public void setPlaybillMd5(String playbillMd5) {
        this.playbillMd5 = playbillMd5;
    }

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StreamData{");
        sb.append("streamId='").append(streamId).append('\'');
        sb.append(", streamGroup='").append(streamGroup).append('\'');
        sb.append(", prdMode=").append(prdMode);
        sb.append(", relayInfo='").append(relayInfo).append('\'');
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", playbillMd5='").append(playbillMd5).append('\'');
        sb.append(", updateType=").append(updateType);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}

