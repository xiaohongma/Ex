package com.example.administrator.ex.model;

/**
 * Created by Administrator on 2016/5/8.
 */
public class Member {
    private int memberId;
    private String email;
    private String token;
    private String name;
    private String headId;
    private String headSmall;
    private String headBig;

    public String getHeadSmall() {
        return headSmall;
    }

    public void setHeadSmall(String headSmall) {
        this.headSmall = headSmall;
    }

    public String getHeadBig() {
        return headBig;
    }

    public void setHeadBig(String headBig) {
        this.headBig = headBig;
    }

    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


}
