package com.lokesh.apiservice;

public class UserRegister {
    private int plaza_id;
    private String login_name;
    private String first_name;
    private String last_name;
    private String password;
    private int roletype;

    public UserRegister(int plaza_id, String login_name, String first_name, String last_name, String password, int roletype) {
        this.plaza_id = plaza_id;
        this.login_name = login_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.roletype = roletype;
    }

//    private int updateserver;
//
//    public int getUpdateserver() {
//        return updateserver;
//    }
//
//    public void setUpdateserver(int updateserver) {
//        this.updateserver = updateserver;
//    }
//    public UserRegister(int plaza_id = null , String login_name = null , String first_name  = null , String last_name  = null , String password  = null , int roletype  = null ) {
//        this.plaza_id = plaza_id;
//        this.login_name = login_name;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.password = password;
//        this.roletype = roletype;
//    }

// Getter Methods

    public int getPlaza_id() {
        return plaza_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public int getRoletype() {
        return roletype;
    }

    // Setter Methods

    public void setPlaza_id(int plaza_id) {
        this.plaza_id = plaza_id;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoletype(int roletype) {
        this.roletype = roletype;
    }
}
