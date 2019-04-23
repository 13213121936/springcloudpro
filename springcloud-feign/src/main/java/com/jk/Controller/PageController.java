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
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

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

    @RequestMapping("list")
    public String list(){
        return "list";
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("tomaiche")
    public String tomaiche(){
        return "wymc";
    }

    @RequestMapping("toinfor")
    public String toinfor(@RequestParam("id") Integer  id, Model model){
        model.addAttribute("a",id);
        return "infor";
    }


}
