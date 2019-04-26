/**
 * Copyright (C), 2019, 金科教育
 * FileName: UserController
 * Author:   zyl
 * Date:     2019/4/12 16:10
 * History:
 * zyl          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.Controller;

import com.jk.model.Car;
import com.jk.model.CarIndexImg;
import com.jk.model.Carsc;
import com.jk.service.UserService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈a〉
 *
 * @author zyl
 * @create 2019/4/12
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SolrClient client;

    @Autowired
    private RedisTemplate redisTemplate;

    //查询
    @GetMapping("/queryCarList")
    public List<Carsc> queryUserList(){
        String key="index";
        List<Carsc> list=new ArrayList<>();
        if(!redisTemplate.hasKey(key)){
            list=userService.queryUserList();
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key, 1, TimeUnit.MINUTES);
        }else{
            list= (List<Carsc>) redisTemplate.opsForValue().get(key);
        }
        return  list;
    }


    @GetMapping("/search")
    public List<Car> userlist(Car car) throws IOException, SolrServerException {
        //因为使用easyui返回数据
        //把所有查询的高亮显示内容发到list中
        List<Car> carList=new ArrayList<>();
        //查询条件的对象
        SolrQuery params = new SolrQuery();
        //判断前台传递的关键字是否为空
        if (!"".equals(car.getCartype()) && car.getCartype()!=null ){
            params.set("q", car.getCartype());
        }else{//如果为空查询所有
            params.set("q", "*:*");
        }
        //默认查询字段  一般默认指定
        params.set("df", "carname");
        //指定查询结果返回哪些字段
        params.set("fl", "id,carname,cartype,price,img");
        // 设置高亮字段
        params.addHighlightField("carname"); // 高亮字段
        //分页

            params.setStart(0);


            params.setRows(20);

        //高亮
        //打开开关
        params.setHighlight(true);
        //设置前缀
        params.setHighlightSimplePre("<span style='color:red'>");
        //设置后缀
        params.setHighlightSimplePost("</span>");
        //QueryResponse是查询返回的对象数据   client.query("core1",params)  查询的是哪个索引库和条件
        QueryResponse queryResponse = client.query("core1",params);
        ///查询返回的结果list对象   不包括高亮
        SolrDocumentList results = queryResponse.getResults();
        //查询出来总条数
        long numFound = results.getNumFound();
        //查询返回的高亮结果
        Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
        //循环查询的所有结果
        for (SolrDocument result : results) {
            //创建对象接收循环的对象数据
            Car car1=new Car();
            //设置高亮的字段
            String highname="";
            //根据id获得高亮的内容
            Map<String, List<String>> map = highlight.get(result.get("id"));
            //根据高亮字段拿到数据
            List<String> list = map.get("carname");
            //判断数据是否为空
            if(list==null){
                //如果为空把普通字段放到对象中
                highname=(String)result.get("carname");
            }else{
                //获得高亮字段查询的值放到变量
                highname=list.get(0);
            }
            ;
            car1.setCarid(Integer.parseInt((String) result.get("id")));
            car1.setCarname(highname);
            car1.setPrice((int)result.get("price"));
            car1.setImg((String) result.get("img"));
            carList.add(car1);
        }
        return carList;
    }


    @GetMapping("queryindeximg")
    public List<CarIndexImg> queryindeximg(){
        return userService.queryindeximg();
    }
}
