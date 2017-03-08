package com.jasper.controller;

import com.jasper.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by Jasper on 2017/2/23.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    //创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户类列表", notes="")
    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<User> getUserList(){
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        List<User> list = new ArrayList<User>(users.values());
        return list;
    }

    @ApiOperation(value="创建用户", notes="根据user对象创建用户")
    @ApiImplicitParam(name = "com.jasper.domain.user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户", notes="根据id获取用户")
    @ApiImplicitParam(name="id", value="用户id", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @ApiOperation(value="更新用户信息", notes="根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name="com.jasper.domain.user", value="用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(user.getId());
        user.setName(u.getName());
        user.setAge(u.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url中的用户id删除用户")
    @ApiImplicitParam(name="id", value="用户id", required = true, dataType="Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User信息
        users.remove(id);
        return "success";
    }

}
