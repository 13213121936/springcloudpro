package com.jk.model;

import java.io.Serializable;

public class Carsc implements Serializable {


    private static final long serialVersionUID = 372200906729824076L;
    private Integer carid;
    //汽车名称
    private String carname;
    //品牌
    private String  cartype;
    //原价
    private Integer price;
    //汽车图片
    private String img;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
