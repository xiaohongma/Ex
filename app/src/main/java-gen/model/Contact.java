package model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import java.io.Serializable;
import java.util.Date;

/**
 * Entity mapped to table CONTACT.
 */
public class Contact implements Serializable {

    private Long id;
    private int memberId;
    private int contactId;
    /** Not-null value. */
    private String email;
    /** Not-null value. */
    private String name;
    private String headBig;
    private String headSmall;
    private Date registerTime;
    private Date createTime;
    /** Not-null value. */
    private String pinyin;

    public Contact() {
    }

    public Contact(Long id) {
        this.id = id;
    }

    public Contact(Long id, int memberId, int contactId, String email, String name, String headBig, String headSmall, Date registerTime, Date createTime, String pinyin) {
        this.id = id;
        this.memberId = memberId;
        this.contactId = contactId;
        this.email = email;
        this.name = name;
        this.headBig = headBig;
        this.headSmall = headSmall;
        this.registerTime = registerTime;
        this.createTime = createTime;
        this.pinyin = pinyin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /** Not-null value. */
    public String getEmail() {
        return email;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public String getHeadBig() {
        return headBig;
    }

    public void setHeadBig(String headBig) {
        this.headBig = headBig;
    }

    public String getHeadSmall() {
        return headSmall;
    }

    public void setHeadSmall(String headSmall) {
        this.headSmall = headSmall;
    }

    public java.util.Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** Not-null value. */
    public String getPinyin() {
        return pinyin;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

}
