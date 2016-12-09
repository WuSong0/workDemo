package cn.controller;

import cn.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016-12-8 0008.
 */
@Controller
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/login2")
    public String login2(@RequestParam String name, String pwd,ModelMap modelmap) {
        Map querymap=new HashMap();
        querymap.put("name",name);
        querymap.put("pwd",pwd);
        Map querymap2=testService.selectUser(querymap);
        if (querymap2 != null) {
           /* Set set = querymap2.keySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
               Map pwd1 = (Map) iterator.next();
            }*/
            if (pwd.equals(querymap2.get("pwd"))) {
                modelmap.addAttribute("name",name);
                return "login2";
            }
        }
            return "fail";
    }
}
