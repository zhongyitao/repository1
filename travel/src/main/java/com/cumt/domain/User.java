package com.cumt.domain;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String birthday;
    private String sex;
    private String telephone;
    private String status;
    private String code;

    /**
     * 无参构造方法
     */
    public User() {
    }

    /**
     * 有参构造方法
     * @param username
     * @param password
     * @param name
     * @param email
     * @param birthday
     * @param sex
     * @param telephone
     * @param status
     * @param code
     */
    public User(String username, String password, String name, String email, String birthday, String sex, String telephone, String status, String code) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.telephone = telephone;
        this.status = status;
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
