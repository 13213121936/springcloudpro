/**
 * Copyright (C),
 * FileName: Car
 * Author:   zx
 * Date:     2019/4/18 10:53
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/18
 * @since 1.0.0
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 8506191501202450805L;

    private Integer carid;

    private String carname;
    //品牌
    private Integer cartype;
    //原价
    private Double price;
    //现价
    private Double currentprice;

    private String img;
    //详细图片
    private Integer infoid;
    //审核状态
    private Integer audState ;
    //交易状态
    private Integer state ;
    //地区
    private String city ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Integer getCartype() {
        return cartype;
    }

    public void setCartype(Integer cartype) {
        this.cartype = cartype;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(Double currentprice) {
        this.currentprice = currentprice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carname='" + carname + '\'' +
                ", cartype=" + cartype +
                ", price=" + price +
                ", currentprice=" + currentprice +
                ", img='" + img + '\'' +
                ", infoid=" + infoid +
                ", audState=" + audState +
                ", state=" + state +
                ", city='" + city + '\'' +
                '}';
    }
}
