package com.huabang.ofo.domain;

public class HbShare {
    private String shareId;

    private String sharePot;

    private String share_status;
    private String share_userid;
    
    public String getShare_userid() {
		return share_userid;
	}

	public void setShare_userid(String share_userid) {
		this.share_userid = share_userid;
	}

	public String getShare_status() {
		return share_status;
	}

	public void setShare_status(String share_status) {
		this.share_status = share_status;
	}

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