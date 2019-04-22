/**
 * Copyright (C),
 * FileName: CarControllerZX
 * Author:   zx
 * Date:     2019/4/18 11:57
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.Controller;

import com.jk.model.*;
import com.jk.service.CarServiceZX;
import com.jk.util.HttpClientUtil;
import com.jk.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 17120
 * @create 2019/4/18
 * @since 1.0.0
 */
@Controller
public class CarControllerZX {
    @Autowired
    private CarServiceZX carServiceZX;

    @Autowired
    private RedisTemplate redisTemplate;


    //查询汽车实体
    @GetMapping("/carzx/queryCarList")
    @ResponseBody
    public Car queryCarList() {
        Integer id = 1;
        Car car = carServiceZX.queryCarList(id);
        return car;
    }

    //查询汽车详细信息
    @GetMapping("/carzx/queryInformation")
    @ResponseBody
    public information queryInformation() {
        Integer id = 1;
        information infor = carServiceZX.queryInformation(id);
        return infor;
    }

    //查询 图片详细
    @GetMapping("/carzx/queryCarInforImg")
    @ResponseBody
    public List<CarInFor> queryCarInforImg() {
        Integer id = 1;
        System.out.println("你是个");
        List<CarInFor> list = carServiceZX.queryCarInforImg(id);
        return list;

    }

    //查询 图片详细
    @GetMapping("/carzx/queryCarTrimImg")
    @ResponseBody
    public List<CarInFor> queryCarTrimImg() {
        Integer id = 1;
        System.out.println("你是个");
        List<CarInFor> list = carServiceZX.queryCarTrimImg(id);
        return list;
    }

    @RequestMapping("/carzx/addPhone")
    @ResponseBody
    public void addPhone(@RequestParam("phone") String phone, @RequestParam("carid") Integer carid) {
        System.out.println(phone);
        carServiceZX.addPhone(phone, carid);
    }

    @RequestMapping("/carzx/addPrice")
    @ResponseBody
    public String addPrice( CarBuy carBuy,String yanzhengma) {
        System.out.println("1234567890-");
        System.out.println(carBuy);
       String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification").toString();
        System.out.println(attribute);
        if (!attribute.equals(yanzhengma)) {
            return "验证码不正确";//验证码不正确
        }
        carServiceZX.addPrice(carBuy);
        return "提交成功";
    }
    @RequestMapping("/carzx/addSeller")
    @ResponseBody
    public String addSeller(@RequestParam("userphone")String userphone,@RequestParam("yanzhengma")String yanzhengma) {
        System.out.println(userphone);
      /* String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification").toString();
        System.out.println(attribute);
        if (!attribute.equals(yanzhengma)) {
            return "验证码不正确";//验证码不正确
        }*/
        carServiceZX.addSeller(userphone);
        return "提交成功";
    }


    @RequestMapping("duanxinyanzheng")
    @ResponseBody
    public String duanxinyanzheng(String userphone, HttpServletRequest request) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("accountSid", ConstantConf.STRINGW);
        hashMap.put("to", userphone);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        hashMap.put("timestamp", format);
        String md532 = Md5Util.getMd532(ConstantConf.STRINGW + ConstantConf.STRINGE + format);
        hashMap.put("sig", md532);
        hashMap.put("templateid", ConstantConf.STRINGT);
        Object object = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ + "Verification");
        if (object != null) {
            return "sss";
        }
        double random = Math.random();
        int Verification = (int) ((random * 9 + 1) * 100000);
        HttpSession session = request.getSession();
        session.setAttribute("Verification", Verification);
        redisTemplate.opsForValue().set(ConstantConf.STRINGDXYZ + "Verification", Verification, ConstantConf.INTEGERDXYZTIME, TimeUnit.SECONDS);
        hashMap.put("param", Verification);
        String post = HttpClientUtil.post(ConstantConf.STRINGR, hashMap);
        String va = "";
        va += Verification;
        System.out.println(va);
        String hahaha = "短信发送成功";
        return hahaha;
    }
}
