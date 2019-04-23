/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   zyl
 * Date:     2019/4/12 16:11
 * History:
 */
package com.jk.service;

import com.jk.model.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author zyl
 * @create 2019/4/12
 * @since 1.0.0
 */
@FeignClient(value = "service-provider")
public interface UserService {



    @GetMapping("/queryCarList")
    List<Carsc> queryUserList();

    @GetMapping("/carzx/queryCarList")
    Car queryCarList(@RequestParam("id")Integer id);

    @GetMapping("/carzx/queryInformation")
    information queryInformation(@RequestParam("id")Integer id);

    @GetMapping("/carzx/queryCarInforImg")
    List<CarInFor> queryCarInforImg(@RequestParam("id")Integer id);

    @GetMapping("/carzx/queryCarTrimImg")
    List<CarInFor> queryCarTrimImg(@RequestParam("id")Integer id);

    @PostMapping("/carzx/addPhone")
    void addPhone(@RequestParam("phone") String phone,@RequestParam("carid") Integer carid);

    @PostMapping("/carzx/addPrice")
    void addPrice(@RequestBody CarBuy carBuy);

    @PostMapping("/carzx/addSeller")
    void addSeller(@RequestParam("userphone")String userphone);




}
