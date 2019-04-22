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

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carname='" + carname + '\'' +
                ", cartype='" + cartype + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }
}
