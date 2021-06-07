package xyz.rtx3090.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("FirstController") //这个也可以不写
public class HelloController {

    //映射访问路径, 真实访问地址 : 项目名/FirstController/hello
    @RequestMapping("one")
    public String index(Model model) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","Hello, Controller");
        //返回视图位置 //web-inf/jsp/hello.jsp
        return "hello";//用于进行拼接，组成文件名
    }

    //映射访问路径, 真实访问地址 : 项目名/FirstController/hello
    @RequestMapping("two")
    public String tomcat(Model model) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","严老板都是个垃圾，是个垃圾～");
        //返回视图位置 //web-inf/jsp/hello.jsp
        return "hello";//与上一个映射的方法返回的值一致，指向同一个视图
    }

    @RequestMapping("three/{x}/{y}")
    public String restFul(@PathVariable int x, @PathVariable int y, Model model) {
        int result = x + y;
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg","结果：" + result);
        //返回视图位置
        return "hello";
    }

    @RequestMapping("four/{x}/{y}")
    public String restFul02(@PathVariable int x, @PathVariable String y, Model model) {
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg","结果："+ x + y);
        //返回视图位置
        return "hello";
    }

    @RequestMapping(value = "five", method = {RequestMethod.GET})
    public String restFul03(Model model) {
        model.addAttribute("msg","我是诺手狗！");
        return "hello";
    }
}
