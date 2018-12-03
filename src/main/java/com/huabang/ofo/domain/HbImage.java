package com.huabang.ofo.domain;

public class HbImage {
    private Integer imageId;

    private String imagePic;

    private String imageType;

    private String imageUserId;

    private Integer imageStatus;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImagePic() {
        return imagePic;
    }

    public void setImagePic(String imagePic) {
        this.imagePic = imagePic == null ? null : imagePic.trim();
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType == null ? null : imageType.trim();
    }

    public String getImageUserId() {
        return imageUserId;
    }

    public void setImageUserId(String imageUserId) {
        this.imageUserId = imageUserId == null ? null : imageUserId.trim();
    }

    public Integer getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(Integer imageStatus) {
        this.imageStatus = imageStatus;
    }
}