package component.spring_controllers;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController 
{
	@RequestMapping("/")
	public String redirect()
	{
		
		return "redirect:/customer/list";
		
	}
	

}
