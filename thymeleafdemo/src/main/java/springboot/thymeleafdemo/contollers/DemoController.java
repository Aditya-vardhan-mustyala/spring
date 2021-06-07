package springboot.thymeleafdemo.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController
{
    @RequestMapping("/hello")
    public String hell(Model model)
    {
        model.addAttribute("date",new java.util.Date());
        return "home";
    }
}
