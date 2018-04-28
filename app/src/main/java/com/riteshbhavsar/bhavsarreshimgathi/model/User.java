package com.riteshbhavsar.bhavsarreshimgathi.model;

/**
 * Created by Dishu on 3/10/2018.
 */

public class User {
    String uid;
    String email_id;
    String mobile;
    String uname;
    String provider;
    String photo_url;
    String storage_url;
    boolean isAdmin;
    boolean isAuthor;

    public User(String uid, String email_id, String mobile
            , String uname, String provider, String photo_url
            , String storage_url, boolean isAdmin, boolean isAuthor) {
        this.uid = uid;
        this.email_id = email_id;
        this.mobile = mobile;
        this.uname = uname;
        this.provider = provider;
        this.photo_url = photo_url;
        this.storage_url = storage_url;
        this.isAdmin = isAdmin;
        this.isAuthor = isAuthor;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getStorage_url() {
        return storage_url;
    }

    public void setStorage_url(String storage_url) {
        this.storage_url = storage_url;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }
}
