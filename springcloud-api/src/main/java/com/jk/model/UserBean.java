/**
 * Copyright (C), 2019-2019, 金科1809
 * FileName: UserBean
 * Author:   史超
 * Date:     2019/4/22 22:44
 * History:
 * <author>          <time>          <version>          <desc>
 * 史超           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author Administrator
 * @create 2019/4/22
 * @since 1.0.0
 */
public class UserBean implements Serializable {
    private static final long serialVersionUID = -2565204274731323966L;
    private Integer id;
    private String  userphone;//手机号
    private String  password;//密码
    private String  role;//角色
    private Double  balance;//余额
    private String  username;//姓名
    private String  mailbox;//邮箱
    private String  sex;//性别

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userphone='" + userphone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                ", username='" + username + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
