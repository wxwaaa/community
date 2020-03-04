package com.wxw.community.controller;

import com.wxw.community.dao.UserMapper;
import com.wxw.community.entity.DiscussPost;
import com.wxw.community.entity.Page;
import com.wxw.community.entity.User;
import com.wxw.community.service.DiscussPostService;
import com.wxw.community.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //方法调用之前springMVC自动实例化Model和Page并且将Page自动注入Model中
        //所以thymeleaf可以直接使用page中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> list1=new ArrayList<>();
        if(list!=null){
            Map<String,Object> map=new HashMap<>();
            for (DiscussPost d:list) {
                map.put("post",d);
                User user=userService.findUserById(d.getUserId());
                map.put("user",user);
                list1.add(map);
            }
        }
        model.addAttribute("discusspost",list1);
        return "/index";
    }
}
