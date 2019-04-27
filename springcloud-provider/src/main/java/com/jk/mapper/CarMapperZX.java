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
import org.apache.ibatis.annotations.Delete;
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


    @Select("  select * from t_car ")
    List<Carsc> queryUserList();

    //查询汽车实体
    @Select(" select * from t_car where carid=#{value} ")
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

    @Insert("INSERT INTO t_carbuy (status,carid,psyPrice,price,userphone) VALUES(1,#{carid},#{psyPrice},#{price},#{userphone})")
    void addPrice(@RequestBody CarBuy carBuy);
    @Insert("INSERT INTO t_seller (phone,status) VALUES(#{value},0)")
    void addSeller(@RequestParam("id")String userphone);

    @Insert("INSERT INTO t_collect (carid,userid) VALUES(#{carid},#{userid})")
    void addShouCang(@Param("carid")Integer carid,@Param("userid") Integer userid);

    @Select("select count(1) from t_collect WHERE carid=#{carid} and userid=#{userid}")
    int qeuryShouCang(@Param("carid")Integer carid,@Param("userid") Integer userid);

    @Select("select * from t_user where id=#{value}")
    User queryUserBean(@RequestParam("userid")Integer userid);

    @Select("SELECT coll.id as id,c.carname,c.img,c.price,i.displacement,i.regTime,i.travel from t_user u LEFT JOIN t_collect coll on u.id=coll.userid\n" +
            "LEFT JOIN t_car c ON coll.carid=c.carid \n" +
            "LEFT JOIN t_information i on c.carid=i.carid\n" +
            "where u.id=#{value}")
    List<Collect> queryCarBean(@RequestParam("userid") Integer userid);

    @Delete("DELETE from t_collect where id=#{value}")
    void deleteColl(@RequestParam(value = "id")Integer id);

    @Select(" select * from t_user  t where userphone =#{userphone} ")
    User userquery(@RequestParam("userphone") String userphone);

    @Insert(" INSERT into t_user(userphone) VALUES(#{userphone}) ")
    void adduserzhu(@RequestParam("userphone") String userphone);

    @Select(" select * from t_indeximg   ")
    List<CarIndexImg> queryindeximg();
}
