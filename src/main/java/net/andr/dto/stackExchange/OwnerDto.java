package net.andr.dto.stackExchange;

import com.google.gson.annotations.SerializedName;

public class OwnerDto {
    @SerializedName("reputation")
    private Integer reputation;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("accept_rate")
    private Long acceptRate;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("link")
    private String link;

    public OwnerDto() {
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(Long acceptRate) {
        this.acceptRate = acceptRate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "reputation='" + reputation + '\'' +
                ", userId=" + userId +
                ", userType='" + userType + '\'' +
                ", acceptRate=" + acceptRate +
                ", profileImage='" + profileImage + '\'' +
                ", displayName='" + displayName + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
