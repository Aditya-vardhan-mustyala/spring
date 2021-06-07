package component.spring_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import component.service.CustomerService;
import hibernateEntities.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	private CustomerService service;
	
	
	
	@RequestMapping("/list")
	public String showcustomer(Model model)
	{
		model.addAttribute("customers",service.getCustomers());
		return "show-customer";
		
	}
	
	@RequestMapping("/showformtoadd")
	public String addForm(Model model)
	{
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("newcustomer") Customer customer)
	{
		
		service.savecustomer(customer);
		return "redirect:/customer/list";
		
	}
	
	@RequestMapping("showformtoupdate")
	public String updateform(@RequestParam("customerId") int id,Model model)
	{
		model.addAttribute("customer",service.getCustomer(id));
		return "customer-form";
	}
	
	@RequestMapping("/deletecustomer")
	public String deletecustomer(@RequestParam("customerId") int id)
	{
		service.deletecustomer(id);
		return "redirect:/customer/list";
	}
	

}
