/**
 * Copyright (C), 2019-2019, 金科1809
 * FileName: CarMapper
 * Author:   史超
 * Date:     2019/4/18 20:03
 * History:
 * <author>          <time>          <version>          <desc>
 * 史超           修改时间           版本号              描述
 */
package com.jk.mapper;

import com.jk.model.Car;
import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author Administrator
 * @create 2019/4/18
 * @since 1.0.0
 */

public interface CarMapper {



    List<Car> queryUserList();
    @Select("select * from t_user where userphone=#{value}")
    UserBean phoneVerification(@RequestParam("userphone")String userphone);


    void adduser(UserBean userBean);
}
