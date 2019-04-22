/**
 * Copyright (C),
 * FileName: CarServiceZX
 * Author:   zx
 * Date:     2019/4/18 13:31
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@FeignClient(value = "SERVICE-PROVIDER")
public interface CarServiceZX {

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
