/**
 * Copyright (C), 2019-2019, 金科1809
 * FileName: CarIndexImg
 * Author:   史超
 * Date:     2019/4/26 14:39
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
 * @create 2019/4/26
 * @since 1.0.0
 */
public class CarIndexImg implements Serializable {

    private static final long serialVersionUID = 4713907755171441083L;

    private Integer id;
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "CarIndexImg{" +
                "id=" + id +
                ", img='" + img + '\'' +
                '}';
    }
}
