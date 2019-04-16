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

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        return userService.queryUserList();
    }

}
