/**
 * Copyright (C),
 * FileName: Reserve
 * Author:   zx
 * Date:     2019/4/19 22:16
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/19
 * @since 1.0.0
 */
public class Reserve implements Serializable {
    private static final long serialVersionUID = 5086727757062372430L;
    private  Integer id;
    private  String phone;
    private  Integer reserve;
    private  Integer carid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", reserve=" + reserve +
                ", carid=" + carid +
                '}';
    }
}
