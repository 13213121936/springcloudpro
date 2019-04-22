/**
 * Copyright (C),
 * FileName: CarBuy
 * Author:   zx
 * Date:     2019/4/21 19:09
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/21
 * @since 1.0.0
 */
public class CarBuy implements Serializable {
    private static final long serialVersionUID = 6171828476901249087L;
    private Integer id;
    private Integer status;
    private Integer carid;
    private Double psyPrice;
    private Double price;
    private String   userphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Double getPsyPrice() {
        return psyPrice;
    }

    public void setPsyPrice(Double psyPrice) {
        this.psyPrice = psyPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
}
