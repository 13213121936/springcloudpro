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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    private MongoTemplate mongoTemplate;

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
        information infor= carMapperZX.queryInformation(id);
        System.out.println(infor);
        return infor;

    }
    //查询汽车详细信息
    @GetMapping("/carzx/queryCarList")
    @ResponseBody
    public Car queryCarList(@RequestParam("id")Integer id){
        Car car= carMapperZX.queryCarList(id);
        return car;
    }
    //查询 图片详细
    @GetMapping("/carzx/queryCarInforImg")
    @ResponseBody
    public List<CarInFor> queryCarInforImg(@RequestParam("id")Integer id){
        List<CarInFor> list= carMapperZX.queryCarInforImg(id);
        System.out.println(list);
        return list;
    }
    //查询 图片详细
    @GetMapping("/carzx/queryCarTrimImg")
    @ResponseBody
    public List<CarInFor> queryCarTrimImg(@RequestParam("id")Integer id){
        List<CarInFor> list= carMapperZX.queryCarTrimImg(id);
        System.out.println(list);
        return list;
    }
    @PostMapping("/carzx/addPhone")
    public void addPhone(@RequestParam("phone") String phone,@RequestParam("carid") Integer carid){
        carMapperZX.addPhone(phone,carid);
    }
    @PostMapping("/carzx/addPrice")
    public void addPrice(@RequestBody CarBuy carBuy){
        carMapperZX.addPrice(carBuy);
    }
    @PostMapping("/carzx/addSeller")
    public void addSeller(@RequestParam("userphone") String userphone){
        carMapperZX.addSeller(userphone);
    }

    @PostMapping("/carzx/addShouCang")
    public void addShouCang(@RequestBody Collect collect){
        System.out.println(collect);
        mongoTemplate.save(collect);
    }
    //收藏
    @GetMapping("/qeuryShouCang")
    @ResponseBody
    public long qeuryShouCang(@RequestParam("carid") String carid,@RequestParam("userid") String userid){
        System.out.println(userid);
        List<Collect> list=mongoTemplate.find (new Query(Criteria.where("userid").is(userid).and("carid").is(carid)),Collect.class);
        long count=list.size();
        System.out.println(count);
        return count;
    }
    @GetMapping("/carzx/queryUserBean")
    @ResponseBody
    public User queryUserBean(@RequestParam("userid")Integer userid){
        User user= carMapperZX.queryUserBean(userid);
        return user;
    }
    @GetMapping("/carzx/queryCarBean")
    @ResponseBody
    public List<Collect> queryCarBean(@RequestParam("userid")String userid){
        Query query=new Query();
        if(StringUtils.isEmpty(userid)){
            query.addCriteria(Criteria.where("userid").is(userid));
        }
        List<Collect> list =mongoTemplate.find(query,Collect.class);
        System.out.println(list);
        return list;
    }

    @GetMapping("/carzx/deleteColl")
    public void deleteColl(@RequestParam(value = "ids") String[] ids){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").in(ids));
        mongoTemplate.remove(query, Collect.class);
    }


    @RequestMapping("phoneVerification")
    @ResponseBody
    public   User userquery(@RequestParam("userphone") String userphone){
        User user =carMapperZX.userquery(userphone);
        return user;
    }

    @PostMapping("adduserzhu")
    @ResponseBody
    public void adduserzhu(@RequestParam("userphone") String userphone){
        carMapperZX.adduserzhu(userphone);
    }



}
