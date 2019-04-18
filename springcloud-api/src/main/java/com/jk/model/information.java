/**
 * Copyright (C),
 * FileName: information
 * Author:   zx
 * Date:     2019/4/18 11:34
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/18
 * @since 1.0.0
 */
//基本信息表
public class information implements Serializable {

    private static final long serialVersionUID = -73669582285710801L;

    private Integer id;
    //汽车id
    private Integer carid;
    //归属地
    private String area;
    //变速箱
    private String speed;
    //燃油类型
    private String fT ;
    //车型
    private String cartype;
    //行驶里程
    private Double travel;
    //排放标准
    private String  es;
    // 颜色
    private String color;
    //国产进口
    private String imports;
    //排量
    private Double displacement;
    //年检到期
    private Date annualtime;
    //上牌日期
    private Date regTime;
    //保险到期
    private Date insuranceTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getfT() {
        return fT;
    }

    public void setfT(String fT) {
        this.fT = fT;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public Double getTravel() {
        return travel;
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImports() {
        return imports;
    }

    public void setImports(String imports) {
        this.imports = imports;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public Date getAnnualtime() {
        return annualtime;
    }

    public void setAnnualtime(Date annualtime) {
        this.annualtime = annualtime;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getInsuranceTime() {
        return insuranceTime;
    }

    public void setInsuranceTime(Date insuranceTime) {
        this.insuranceTime = insuranceTime;
    }

    @Override
    public String toString() {
        return "information{" +
                "id=" + id +
                ", carid=" + carid +
                ", area='" + area + '\'' +
                ", speed='" + speed + '\'' +
                ", fT='" + fT + '\'' +
                ", cartype='" + cartype + '\'' +
                ", travel=" + travel +
                ", es='" + es + '\'' +
                ", color='" + color + '\'' +
                ", imports='" + imports + '\'' +
                ", displacement=" + displacement +
                ", annualtime=" + annualtime +
                ", regTime=" + regTime +
                ", insuranceTime=" + insuranceTime +
                '}';
    }
}
