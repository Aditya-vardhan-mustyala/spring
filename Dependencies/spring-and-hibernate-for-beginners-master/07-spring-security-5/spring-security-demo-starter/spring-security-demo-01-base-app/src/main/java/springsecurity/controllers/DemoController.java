package springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController 
{
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/teachers")
	public String teach()
	{
		return "teachers-page";
	}

	@GetMapping("/admins")
	public String admin()
	{
		return "admins-page";
	}
}
