package net.narender.springboott.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.narender.springboott.model.Employee;
import net.narender.springboott.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/shownewEmployeeFrom")
	public String shownewEmployeeFrom(Model model) {
		//create model attribute to bind from data
		Employee employee =new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save employee database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpadte/{id}")
	public String showFormForUpadte(@PathVariable (value = "id") long id, Model model) {
		//get Employee from the service
		Employee employee= employeeService.getEmployeeById(id);
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value ="id") long id) {
		//call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
  
		
	}

}
