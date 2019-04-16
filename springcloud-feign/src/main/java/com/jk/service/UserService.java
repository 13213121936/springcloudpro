/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   zyl
 * Date:     2019/4/12 16:11
 * History:
 */
package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author zyl
 * @create 2019/4/12
 * @since 1.0.0
 */
@FeignClient(value = "SERVICE-PROVIDER")
public interface UserService {

    @GetMapping("/queryUserList")
    public List<User> queryUserList();
}
