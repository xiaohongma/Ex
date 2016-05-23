package com.example.administrator.ex;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by Administrator on 2016/5/15.
 */
public class Main {
    public static void main(String[] args){
        Schema schema = new Schema(1,"model");
        addContact(schema);
        addChatMsg(schema);
        addRequestMsg(schema);
       schema.setDefaultJavaPackageDao("greendao");
        try {
            new DaoGenerator().generateAll(schema,"../Ex/app/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void addContact(Schema schema){
     Entity contact =   schema.addEntity("Contact");
        contact.addIdProperty().autoincrement().primaryKey();
        contact.addIntProperty("memberId").notNull();
        contact.addIntProperty("contactId").notNull();
        contact.addStringProperty("email").notNull();
        contact.addStringProperty("name").notNull();
        contact.addStringProperty("headBig");
        contact.addStringProperty("headSmall");
        contact.addDateProperty("registerTime");
        contact.addDateProperty("createTime");
        contact.addStringProperty("pinyin").notNull();
    }
    private static void addRequestMsg(Schema schema){
        Entity request =   schema.addEntity("RequestMsg");

        request.addIdProperty().autoincrement().primaryKey();
        request.addIntProperty("memberId").notNull();
        request.addIntProperty("contactId").notNull();

        request.addIntProperty("requestId").notNull();
        request.addStringProperty("requestMsg").notNull();
        request.addDateProperty("requestTime").notNull();

        request.addStringProperty("contactEmail").notNull();
        request.addStringProperty("contactName").notNull();
        request.addStringProperty("contactHeadBig").notNull();
        request.addStringProperty("contactHeadMid").notNull();
        request.addStringProperty("contactHeadSmall").notNull();
        request.addDateProperty("contactRegisterTime").notNull();
    }
    private static void addChatMsg(Schema schema){
        Entity chat =   schema.addEntity("ChatMsg");
        chat.addIdProperty().autoincrement().primaryKey();
        chat.addIntProperty("memberId").notNull();
        chat.addIntProperty("contactId").notNull();
        chat.addStringProperty("chatMsg").notNull();

        chat.addDateProperty("registerTime").notNull();
        chat.addIntProperty("chatType").notNull();
        chat.addIntProperty("isReceived").notNull();
        chat.addIntProperty("status").notNull();
    }
}
