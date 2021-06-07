package spring_package;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

@Controller
@RequestMapping("ffoo")
public class HomeController {
	@RequestMapping("/index")
	public String shw() 
	{
		return "home";
		
	}
	
	@RequestMapping("/home")
	public String gg(HttpServletRequest req,Model model)
	{
		
		return "third";
	}
}


