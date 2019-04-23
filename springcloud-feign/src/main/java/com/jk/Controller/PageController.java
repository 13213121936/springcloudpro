/**
 * Copyright (C),
 * FileName: PageController
 * Author:   zx
 * Date:     2019/4/17 9:40
 * History:
 * zx         <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/17
 * @since 1.0.0
 */
@Controller
public class PageController {



    //跳转展示页面
    @RequestMapping("list")
    public String list(){
        return "list";
    }
    //跳转首页
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    //登录页面
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    //注册页面
    @RequestMapping("toAdd")
    public String toAdd(){
        return "zc";
    }
}
