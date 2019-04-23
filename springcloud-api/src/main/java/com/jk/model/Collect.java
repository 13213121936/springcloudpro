/**
 * Copyright (C),
 * FileName: Collect
 * Author:   zx
 * Date:     2019/4/23 16:00
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/23
 * @since 1.0.0
 */
public class Collect {
    private Integer id;
    private String carname;
    private Integer price;
    private String regTime;
    private Double travel;
    private Double displacement;
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public Double getTravel() {
        return travel;
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", carname='" + carname + '\'' +
                ", price=" + price +
                ", regTime='" + regTime + '\'' +
                ", travel=" + travel +
                ", displacement=" + displacement +
                ", img='" + img + '\'' +
                '}';
    }
}
