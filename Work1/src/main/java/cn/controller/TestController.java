package cn.controller;

import cn.service.TestService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016-12-8 0008.
 */
@Api(value = "user", description = "the user API")
@Controller
public class TestController {
    @Resource
    private TestService testService;
    @ResponseBody
    @RequestMapping(value = "/login1",method =RequestMethod.GET,produces = "application/json; charset=utf-8")
    public String login(){

        return "login";
    }
    @ApiOperation(value = "登录操作根据用户名判断密码是否输入正确", httpMethod = "POST", notes = "登录操作根据用户名判断密码是否输入正确")
    @ResponseBody
    @RequestMapping(value="/login2",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String login2(@ApiParam(required = true, name = "name", value = "username")@RequestParam String name, @ApiParam(required = true, name = "pwd", value = "password")@RequestParam String pwd, ModelMap modelmap) {
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
               /* List list=testService.selectStu();
                System.out.print(list);
                modelmap.addAttribute("list", list);*/
                return "login2";
            }
        }
            return "fail";
    }

   /* @ResponseBody
    @RequestMapping(
            value = "queryUserById", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "根据用户ID查询用户信息")
    public String queryUserById(@ApiParam(required = true, name = "userId", value = "user id") @RequestParam(
            value = "userId") String userId, HttpServletRequest request)
    {
       // UserInfo info = userService.queryUserById(Integer.parseInt(userId));

       // return buildSuccessResultInfo(info);
        return null;
    }*/
}
