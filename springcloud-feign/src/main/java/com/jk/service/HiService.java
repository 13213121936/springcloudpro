/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HiService
 * Author:   zyl
 * Date:     2019/4/12 15:53
 * History:
 */
package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author zyl
 * @create 2019/4/12
 * @since 1.0.0
 */
//@FeignClient(value = "SERVICE-PROVIDER")
public interface HiService {

    //restful编程风格
    //
    @GetMapping(value  ="/hi")  //@RequestMapping(value = "/hi",method = RequestMethod.GET)  查询
   // @PostMapping   //新增请求  @RequestMapping(value = "/hi",method = RequestMethod.POST)
    //@DeleteMapping  //删除请求 @RequestMapping(value = "/hi",method = RequestMethod.DELETE)
    //@PutMapping   //修改  @RequestMapping(value = "/hi",method = RequestMethod.PUT)
    //如果传入的参数是 String Integer  用@RequestParam  如果传递的是对象  @RequestBody
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
