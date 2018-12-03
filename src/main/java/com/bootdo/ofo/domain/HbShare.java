package com.bootdo.ofo.domain;

public class HbShare {
    private String shareId;

    private String sharePot;

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    public String getSharePot() {
        return sharePot;
    }

    public void setSharePot(String sharePot) {
        this.sharePot = sharePot == null ? null : sharePot.trim();
    }
}