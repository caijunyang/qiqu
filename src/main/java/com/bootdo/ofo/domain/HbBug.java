package com.bootdo.ofo.domain;

public class HbBug {
    private Integer bugId;

    private Integer bugParentid;

    private String bugName;

    private String bugAnswer;

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getBugParentid() {
        return bugParentid;
    }

    public void setBugParentid(Integer bugParentid) {
        this.bugParentid = bugParentid;
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName == null ? null : bugName.trim();
    }

    public String getBugAnswer() {
        return bugAnswer;
    }

    public void setBugAnswer(String bugAnswer) {
        this.bugAnswer = bugAnswer == null ? null : bugAnswer.trim();
    }
}