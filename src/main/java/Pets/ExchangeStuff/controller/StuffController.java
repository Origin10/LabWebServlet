package Pets.ExchangeStuff.controller;

import Pets.ExchangeStuff.model.Stuff;
import Pets.ExchangeStuff.model.StuffDetail;
import Pets.ExchangeStuff.service.StuffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Student on 2017/6/1.
 */

@Controller
@RequestMapping(value = "/stuff")
public class StuffController {

    private static Logger log = LoggerFactory.getLogger(StuffController.class);//提供一個logger提供日誌 添加API(slf4j)

    @Autowired
    private StuffService stuffService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String userName, String password) {
        if (Objects.equals(userName,"admin") && Objects.equals(password,"admin")){
            return "redirect:main";
        }
        return "redirect:login";
    }

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("stuffs",this.stuffService.getAll());
        return "main";
    }

//    Prompt是前置操作的意思，如果用jQuery的Ajax

    @RequestMapping("/addPrompt")
    public String addPrompt(){
        return "addStuff";//到新增頁面
    }

    @RequestMapping("/updatePrompt")
    public String updatePrompt(Model model, Integer id){
        model.addAttribute("stuff",this.stuffService.findByPrimaryKey(id));
        return "updateStuff";//到上傳頁面
    }

    @RequestMapping(value = "/insertStuff")
    public String insert(Stuff stuff) {
        stuffService.insert(stuff);
        return "redirect:main";
    }

    @RequestMapping(value = "/updateStuff")
    public String update(Stuff stuff) {
        stuffService.update(stuff);
        return "redirect:main";
    }

    @RequestMapping(value = "/deleteStuff")
    public String deleteByID(Integer id){
        stuffService.deleteByID(id);
        return "redirect:main";
    }

    @RequestMapping(value = "/getStuffById")
    @ResponseBody
    public Stuff findByPrimaryKey(Integer id) {
        return stuffService.findByPrimaryKey(id);
    }

    @RequestMapping(value = "/getStuffs")
    @ResponseBody //Json格式的回傳
    public List<Stuff> getAll() {
        return stuffService.getAll();
    }

    @RequestMapping(value = "/getDetailsById")
    public Set<StuffDetail> getDetailsByStuffID(Integer id) {
        return stuffService.getDetailsByStuffID(id);
    }
}