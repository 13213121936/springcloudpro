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
    private String cartype;
    //原价
    private Integer price;
    //汽车图片
    private String img;
    //详细图片
    private Integer infoid;
    //审核状态
    private Integer audState ;
    //交易状态
    private Integer state ;


    //现价
    private Integer currentprice;

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

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public Integer getAudState() {
        return audState;
    }

    public void setAudState(Integer audState) {
        this.audState = audState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(Integer currentprice) {
        this.currentprice = currentprice;
    }
}
