/**
 * Copyright (C),
 * FileName: CarMapperZX
 * Author:   zx
 * Date:     2019/4/18 13:58
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author 17120
 * @create 2019/4/18
 * @since 1.0.0
 */
public interface CarMapperZX {

    //查询汽车实体
    @Select("select * from t_car where carid=#{value}")
    Car queryCarList(@RequestParam("id")Integer id);
    //查询汽车详细信息
    @Select("select * from t_Information where carid=#{value}")
    information queryInformation(@RequestParam("id")Integer id);
    //查询 图片详细
    @Select("select * from t_carinfo where carid=#{value} and start=1")
    List<CarInFor> queryCarInforImg(@RequestParam("id")Integer id);
    //查询外观内饰图片
    @Select("select * from t_carinfo where carid=#{value} and start=0")
    List<CarInFor> queryCarTrimImg(@RequestParam("id")Integer id);
    //新增预约看车
    @Insert("INSERT INTO t_reserve (phone,reserve,carid) VALUES(#{phone},0,#{carid})")
    void addPhone(@Param("phone") String phone,@Param("carid") Integer carid);

    @Insert("INSERT INTO t_carbuy (status,carid,psyPrice,price) VALUES(1,#{carid},#{psyPrice},#{price})")
    void addPrice(@RequestBody CarBuy carBuy);
    @Insert("INSERT INTO t_seller (phone,status) VALUES(#{value},0)")
    void addSeller(@RequestParam("id")String userphone);
}
