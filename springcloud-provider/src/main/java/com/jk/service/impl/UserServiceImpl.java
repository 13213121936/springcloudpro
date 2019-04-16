
package com.jk.service.impl;


import com.jk.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserServiceImpl  {



    @GetMapping("/queryUserList")
    @ResponseBody
    public List<User> queryUserList() {
        User user =new User();
        user.setUserName("1");
        user.setUserAge(1);
        User user1 =new User();
        user1.setUserName("2");
        user1.setUserAge(2);
        List<User> list =new ArrayList<>();
        list.add(user);
        list.add(user1);

        return list;
    }
}
