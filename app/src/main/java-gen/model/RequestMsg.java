package model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table REQUEST_MSG.
 */
public class RequestMsg {

    private Long id;
    private int memberId;
    private int contactId;
    private int requestId;
    /** Not-null value. */
    private String requestMsg;
    /** Not-null value. */
    private java.util.Date requestTime;
    /** Not-null value. */
    private String contactEmail;
    /** Not-null value. */
    private String contactName;
    /** Not-null value. */
    private String contactHeadBig;
    /** Not-null value. */
    private String contactHeadMid;
    /** Not-null value. */
    private String contactHeadSmall;
    /** Not-null value. */
    private java.util.Date contactRegisterTime;

    public RequestMsg() {
    }

    public RequestMsg(Long id) {
        this.id = id;
    }

    public RequestMsg(Long id, int memberId, int contactId, int requestId, String requestMsg, java.util.Date requestTime, String contactEmail, String contactName, String contactHeadBig, String contactHeadMid, String contactHeadSmall, java.util.Date contactRegisterTime) {
        this.id = id;
        this.memberId = memberId;
        this.contactId = contactId;
        this.requestId = requestId;
        this.requestMsg = requestMsg;
        this.requestTime = requestTime;
        this.contactEmail = contactEmail;
        this.contactName = contactName;
        this.contactHeadBig = contactHeadBig;
        this.contactHeadMid = contactHeadMid;
        this.contactHeadSmall = contactHeadSmall;
        this.contactRegisterTime = contactRegisterTime;
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

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    /** Not-null value. */
    public String getRequestMsg() {
        return requestMsg;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    /** Not-null value. */
    public java.util.Date getRequestTime() {
        return requestTime;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setRequestTime(java.util.Date requestTime) {
        this.requestTime = requestTime;
    }

    /** Not-null value. */
    public String getContactEmail() {
        return contactEmail;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /** Not-null value. */
    public String getContactName() {
        return contactName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /** Not-null value. */
    public String getContactHeadBig() {
        return contactHeadBig;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContactHeadBig(String contactHeadBig) {
        this.contactHeadBig = contactHeadBig;
    }

    /** Not-null value. */
    public String getContactHeadMid() {
        return contactHeadMid;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContactHeadMid(String contactHeadMid) {
        this.contactHeadMid = contactHeadMid;
    }

    /** Not-null value. */
    public String getContactHeadSmall() {
        return contactHeadSmall;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContactHeadSmall(String contactHeadSmall) {
        this.contactHeadSmall = contactHeadSmall;
    }

    /** Not-null value. */
    public java.util.Date getContactRegisterTime() {
        return contactRegisterTime;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setContactRegisterTime(java.util.Date contactRegisterTime) {
        this.contactRegisterTime = contactRegisterTime;
    }

}
