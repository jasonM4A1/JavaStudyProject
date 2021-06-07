package xyz.rtx3090.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/FirstController")//这个也可以不写
public class FirstController {
    //真实访问地址 : 项目名/FirstController/first
    @RequestMapping("first")
    public String sayHello(Model model) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "first";
    }
}
