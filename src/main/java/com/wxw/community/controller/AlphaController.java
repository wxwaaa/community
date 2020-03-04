package com.wxw.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Alpha")
public class AlphaController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "this is Springboot";
    }
    //GET请求
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String students(){
        return "some students";
    }
    @RequestMapping(path = "/student1",method = RequestMethod.GET)
    @ResponseBody
    public String student1(@RequestParam (name = "current",required = false,defaultValue = "1") int current,
                           @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    //  /student/111
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String student(@PathVariable("id") int id){
        System.out.println(id);

        return "student";
    }
    //  /student/111
    @RequestMapping(path = "/poststudent",method = RequestMethod.POST)
    @ResponseBody
    public String poststudent(String name,int age){
        System.out.println(name);
        System.out.println(age);

        return "student";
    }
    //响应HTML数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView teacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","wxw");
        modelAndView.addObject("age","24");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
    //响应HTML数据
    @RequestMapping(path = "/teacher1",method = RequestMethod.GET)
    public String teacher1(Model model){
        model.addAttribute("name","wwj");
        model.addAttribute("age","21");
        return "/demo/view";
    }
    //响应JSON数据
    @RequestMapping(path = "/getJson",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getJson(){
        Map<String ,Object> map=new HashMap<>();
        map.put("name","徐凤年");
        map.put("age","20");
        map.put("level","大宗师");
        return map;
    }
    //响应JSON数据
    @RequestMapping(path = "/getJsonByList",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getJson1(){
        List<Map<String,Object>> list=new ArrayList<>();

        Map<String ,Object> map=new HashMap<>();
        map.put("name","徐凤年");
        map.put("age","20");
        map.put("level","大宗师");
        list.add(map);

        map=new HashMap<>();
        map.put("name","老黄");
        map.put("age","50");
        map.put("level","大宗师");
        list.add(map);

        map=new HashMap<>();
        map.put("name","李淳罡");
        map.put("age","70");
        map.put("level","大宗师");
        list.add(map);
        return list;
    }
}
