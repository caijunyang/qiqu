package com.huabang.ofo.domain;

public class Discover {
    private String discoverId;

    private String discoverTitle;

    private String discoverImageUrl;

    private String discoverMessage;

    private String discoverEndTime;
    
    private String discoverType;
    
    public String getDiscoverId() {
        return discoverId;
    }

    public void setDiscoverId(String discoverId) {
        this.discoverId = discoverId == null ? null : discoverId.trim();
    }

    public String getDiscoverTitle() {
        return discoverTitle;
    }

    public void setDiscoverTitle(String discoverTitle) {
        this.discoverTitle = discoverTitle == null ? null : discoverTitle.trim();
    }

    public String getDiscoverImageUrl() {
        return discoverImageUrl;
    }

    public void setDiscoverImageUrl(String discoverImageUrl) {
        this.discoverImageUrl = discoverImageUrl == null ? null : discoverImageUrl.trim();
    }

    public String getDiscoverMessage() {
        return discoverMessage;
    }

    public void setDiscoverMessage(String discoverMessage) {
        this.discoverMessage = discoverMessage == null ? null : discoverMessage.trim();
    }
    
    public String getDiscoverEndTime() {
    	return discoverEndTime;
    }
    
    public void setDiscoverEndTime(String discoverEndTime) {
    	this.discoverEndTime = discoverEndTime == null ? null : discoverEndTime.trim();
    }
    
    public String getDiscoverType() {
    	return discoverType;
    }
    
    public void setDiscoverType(String discoverType) {
    	this.discoverType = discoverType == null ? null : discoverType.trim();
    }
}