/**
 * Copyright (C),
 * FileName: CarServiceImpl
 * Author:   zx
 * Date:     2019/4/18 13:55
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.CarMapperZX;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/18
 * @since 1.0.0
 */
@Controller
public class CarServiceImpl {
    @Autowired
    private CarMapperZX carMapperZX;



    //查询
    @GetMapping("/queryCarList")
    @ResponseBody
    public List<Carsc> queryUserList(){
        return carMapperZX.queryUserList();
    };


    //查询汽车实体
    @GetMapping("/carzx/queryInformation")
    @ResponseBody
    public information queryInformation(@RequestParam("id")Integer id){
        System.out.println(11);
        information infor= carMapperZX.queryInformation(id);
        System.out.println(infor);
        return infor;
    }
    //查询汽车详细信息
    @GetMapping("/carzx/queryCarList")
    @ResponseBody
    public Car queryCarList(@RequestParam("id")Integer id){
        System.out.println(11);
        Car car= carMapperZX.queryCarList(id);
        System.out.println(car);
        return car;
    }
    //查询 图片详细
    @GetMapping("/carzx/queryCarInforImg")
    @ResponseBody
    public List<CarInFor> queryCarInforImg(@RequestParam("id")Integer id){
        System.out.println(11);
        List<CarInFor> list= carMapperZX.queryCarInforImg(id);
        System.out.println(list);
        return list;
    }
    //查询 图片详细
    @GetMapping("/carzx/queryCarTrimImg")
    @ResponseBody
    public List<CarInFor> queryCarTrimImg(@RequestParam("id")Integer id){
        System.out.println(11);
        List<CarInFor> list= carMapperZX.queryCarTrimImg(id);
        System.out.println(list);
        return list;
    }
    @PostMapping("/carzx/addPhone")
    public void addPhone(@RequestParam("phone") String phone,@RequestParam("carid") Integer carid){
       System.out.println(phone);
        carMapperZX.addPhone(phone,carid);
    }
    @PostMapping("/carzx/addPrice")
    public void addPrice(@RequestBody CarBuy carBuy){
        System.out.println(carBuy);
        carMapperZX.addPrice(carBuy);
    }
    @PostMapping("/carzx/addSeller")
    public void addSeller(@RequestParam("userphone") String userphone){
        System.out.println(userphone);
        carMapperZX.addSeller(userphone);
    }
}
