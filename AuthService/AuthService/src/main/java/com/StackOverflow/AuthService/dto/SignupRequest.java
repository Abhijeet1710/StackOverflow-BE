package com.StackOverflow.AuthService.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SignupRequest {
    private String userName, profilePic, email, password;

    private List<Long> followersUserIds;

    @Override
    public String toString() {
        return "SignupRequest{" +
                "userName='" + userName + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", followersUserIds=" + followersUserIds +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getFollowersUserIds() {
        return followersUserIds;
    }

    public void setFollowersUserIds(List<Long> followersUserIds) {
        this.followersUserIds = followersUserIds;
    }
}
