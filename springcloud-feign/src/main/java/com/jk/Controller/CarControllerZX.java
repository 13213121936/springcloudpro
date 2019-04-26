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

import com.jk.service.UserService;
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
    private UserService carServiceZX;

    @Autowired
    private RedisTemplate redisTemplate;





    //查询汽车实体
    @GetMapping("/carzx/queryCarList")
    @ResponseBody
    public Car queryCarList(@RequestParam("id") Integer  id) {
        System.out.println("wwwwwwwwwwwwwww"+id);
        Car car = carServiceZX.queryCarList(id);
        System.out.println(car);
        return car;
    }

    //查询汽车详细信息
    @GetMapping("/carzx/queryInformation")
    @ResponseBody
    public information queryInformation(@RequestParam("id") Integer  id) {

        information infor = carServiceZX.queryInformation(id);

        return infor;
    }

    //查询 图片详细
    @GetMapping("/carzx/queryCarInforImg")
    @ResponseBody
    public List<CarInFor> queryCarInforImg(@RequestParam("id") Integer  id) {
        List<CarInFor> list = carServiceZX.queryCarInforImg(id);
        return list;

    }

    //查询 图片详细
    @GetMapping("/carzx/queryCarTrimImg")
    @ResponseBody
    public List<CarInFor> queryCarTrimImg(@RequestParam("id") Integer  id) {
        List<CarInFor> list = carServiceZX.queryCarTrimImg(id);
        return list;
    }
    //买车的预约
    @RequestMapping("/carzx/addPhone")
    @ResponseBody
    public void addPhone(@RequestParam("phone") String phone, @RequestParam("carid") Integer carid) {
        carServiceZX.addPhone(phone, carid);
    }
    //砍价的验证码
    @RequestMapping("/carzx/addPrice")
    @ResponseBody
    public String addPrice( CarBuy carBuy,String yanzhengma) {
        String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification").toString();
        if(attribute.equals("")){
            return "请输入验证码";
        }

        Double  jiager=carBuy.getPrice();
        Double  jiage2= jiager*0.8;
        if(carBuy.getPsyPrice()<jiage2){
            return "不要太贪哦,换个价格试试";
        }
        if (!attribute.equals(yanzhengma)) {
            return "验证码不正确";//验证码不正确
        }
        carServiceZX.addPrice(carBuy);
        return "提交成功";
    }


    //卖车的预约
    @RequestMapping("/carzx/addSeller")
    @ResponseBody
    public String addSeller(@RequestParam("userphone")String userphone,@RequestParam("yanzhengma")String yanzhengma) {
        System.out.println(userphone);
        String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification").toString();
        System.out.println(attribute);
        if (!attribute.equals(yanzhengma)) {
            return "验证码不正确";//验证码不正确
        }
        carServiceZX.addSeller(userphone);
        return "提交成功";
    }
    //收藏

    @PostMapping("/carzx/addShouCang")
    @ResponseBody
    public String addShouCang(Collect collect,HttpSession session){
        System.out.println(collect);
        User user= (User) session.getAttribute("user");
        String userid= String.valueOf(user.getId());
        collect.setUserid(userid);
        System.out.println(userid);
        String carid=collect.getCarid();
        System.out.println(carid);
        long count=carServiceZX.qeuryShouCang(carid,userid);
        System.out.println(count);
        if (count>0){
            return "这款车已经在收藏页面！";
        }
        carServiceZX.addShouCang(collect);
        return "收藏成功";
    }
    //收藏页面查询用户
    @GetMapping("/carzx/queryUserBean")
    @ResponseBody
    public User queryUserBean(HttpSession session){
        User user1= (User) session.getAttribute("user");
        Integer userid=  user1.getId();
        User user=carServiceZX.queryUserBean(userid);
        String str=user.getUsername();
        user.setUsername(str.substring(0,1));
        System.out.println(str.substring(0,1));
        System.out.println(user);
        return user;
    }
    //收藏页面查询汽车
    @GetMapping("/carzx/queryCarBean")
    @ResponseBody
    public  List<Collect> queryCarBean(HttpSession session){

        User user= (User) session.getAttribute("user");
        String userid= String.valueOf(user.getId());
        List<Collect> list=carServiceZX.queryCarBean(userid);
        return list;
    }

    @GetMapping("/carzx/deleteColl")
    @ResponseBody
    public Boolean deleteColl(@RequestParam(value = "ids") String[] ids) {
        System.out.println(ids);

        carServiceZX.deleteColl(ids);
        return true;

    }








    //发短信
    @RequestMapping("duanxinyanzheng")
    @ResponseBody
    public String duanxinyanzheng(String userphone, HttpServletRequest request) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("accountSid", ConstantConf.STRINGW);
        if(userphone.equals("")){
            return "手机号不能为空";
        }
        if(userphone.length()!=11){
            return "请输入正确的手机号";
        }
        hashMap.put("to", userphone);

        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        hashMap.put("timestamp", format);
        String md532 = Md5Util.getMd532(ConstantConf.STRINGW + ConstantConf.STRINGE + format);
        hashMap.put("sig", md532);
        hashMap.put("templateid", ConstantConf.STRINGT);
        Object object = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ + "Verification");
        if (object != null) {
            return "操作频繁,请5分钟后尝试";
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
        return "短信发送成功";
    }
    //登陆
    @GetMapping("phoneVerification")
    @ResponseBody
    public   String   phoneVerification(String userphone,String yanzhengma,HttpServletRequest request) {
        //String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ + "Verification").toString();
        String aa = "";
       String attribute="11";
        if(attribute==null){
            aa="验证码失效,请重新获取";
        }

        if(userphone==null){
            aa="请输入正确手机号";
        }
        User user = carServiceZX.userquery(userphone);
        if (!attribute.equals(yanzhengma)) {
            aa = "验证码错误";
        }

        if (user == null) {
            aa="账号不在";
        }
        if (attribute.equals(yanzhengma)&&user!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            aa = "登陆成功";
        }
        return aa;
    }

    //注册
    @RequestMapping("addzhuce")
    @ResponseBody
    public  String  addzhuce(String userphone,String yanzhengma){
        String aa = "";
        String attribute = "11";
        if (!attribute.equals(yanzhengma)) {
            aa = "验证码错误";
        }
        //User user = carServiceZX.userquery(userphone);

        carServiceZX.adduserzhu(userphone);
        aa="注册成功";

        return aa;
    }



}
