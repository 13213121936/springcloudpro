/**
 * Copyright (C),
 * FileName: CarInFor
 * Author:   zx
 * Date:     2019/4/19 13:40
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/19
 * @since 1.0.0
 */
public class CarInFor {
    private Integer id;
    private Integer carid;
    private String img;
    private Integer start;
    private String title;
    private String info;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CarInFor{" +
                "id=" + id +
                ", carid=" + carid +
                ", img='" + img + '\'' +
                ", start=" + start +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
