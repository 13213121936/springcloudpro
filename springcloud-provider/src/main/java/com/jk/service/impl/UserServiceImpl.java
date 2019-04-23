
package com.jk.service.impl;


import com.jk.mapper.CarMapper;
import com.jk.model.Car;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
public class UserServiceImpl  {

    @Autowired
    private CarMapper carMapper;

    //查询
    @GetMapping("/queryCarList")
    @ResponseBody
    public List<Car> queryUserList(){
        return carMapper.queryUserList();
    };


    @GetMapping("/user/login")
    @ResponseBody
    public UserBean phoneVerification(@RequestParam("userphone") String userphone){
        return carMapper.phoneVerification(userphone);
    }
}
