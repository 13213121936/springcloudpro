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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * @author 17120
 * @create 2019/4/17
 * @since 1.0.0
 */
@Controller
public class PageController {

    @RequestMapping("toAddCar")
    public String toAddCar(){
        return "addCar";
    }

    @RequestMapping("toMain")
    public String toMain(){
        return "index";
    }
    @RequestMapping("tomaiche")
    public String tomaiche(){
        return "wymc";
    }

    @RequestMapping("toinfor")
    public String toinfor(Model model){
        int id=333333;
        model.addAttribute("a",id);
        return "infor";
    }








}
