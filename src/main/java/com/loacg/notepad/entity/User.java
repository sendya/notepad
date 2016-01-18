package com.loacg.notepad.entity;

/**
 * notepad
 * Date: 1/18/2016
 * Author: Sendya <yinliangliang@rd.keytop.com.cn>
 */
public class User {

    private Integer uid;
    private String userName;
    private String passWord;
    private String mail;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
