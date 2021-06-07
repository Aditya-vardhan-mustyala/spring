package form_validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class FormController 
{
	@RequestMapping("/form")
	public String home(Model model)
	{
		model.addAttribute("customer",new Customer());
		return "form";		
	}
	
	@RequestMapping("/formvalid")
	public String valid(@Valid @ModelAttribute("customer") Customer cust,BindingResult res)
	{
		if(res.hasErrors())
			return "form";
		else
		return "successpage";
		
	}

}
