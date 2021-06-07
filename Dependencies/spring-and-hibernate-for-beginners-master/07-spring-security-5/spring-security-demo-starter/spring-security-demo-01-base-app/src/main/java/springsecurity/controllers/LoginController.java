package springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{
	@GetMapping("/showlogin")
	public String login()
	{
		return "fancy-login";
	}

	@GetMapping("/accessdenied")
	public String accessdenied()
	{
		return "access-denied";
	}
}
