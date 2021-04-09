package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute("employees")
	public List<Employee> listOfEmployees(){
		return employeeService.getEmployees();
	}
	
	/*@GetMapping(value = "/index")
	public String viewHome() {
		return "registration";
	}*/
	
	@GetMapping(value= {"index","modify"})
	public String viewHome(Model model, @RequestParam(value="id", required=false) Integer id) {
		Employee employee=new Employee();
		if(id!=null)
			employee=employeeService.getEmployeeById(id);
		
		model.addAttribute("employeeForm",employee);    //java.lang.IllegalStateException: binding result nor plain target object
		return "registration";
	}
	
	@PostMapping(value="save")
	public String saveOrUpdate(Model model, @ModelAttribute Employee employee,
			RedirectAttributes redirectAttributes) {
		Boolean result=employeeService.saveOrUpdate(employee);
		if(result) 
			redirectAttributes.addFlashAttribute("success","employee saved");
		else 
			redirectAttributes.addFlashAttribute("error","employee not saved...try again");
		
		return "redirect:/index";
	}
	
	@GetMapping(value="delete")
	public String deleteEmployee(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		Boolean result=employeeService.deleteEmployee(id);
		if(result) {
			redirectAttributes.addFlashAttribute("success","employee deleted");
		}else {
			redirectAttributes.addFlashAttribute("error","employee not deleted");
		}
		return "redirect:/index";
	}

}
