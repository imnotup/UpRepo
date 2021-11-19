package com.covalense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.covalense.beans.Employee;
import com.covalense.exception.invalidEmployeeIdException;
import com.covalense.service.EmployeeService;

@Controller

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "regemp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelAndView = new ModelAndView("employee", "employee", new Employee());
		return modelAndView;

	}

	@RequestMapping(value = "regemp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		ModelAndView modelAndView = new ModelAndView("savedEmployee");
		modelAndView.addObject("emp", employeeService.save(emp));
		return modelAndView;

	}

	@RequestMapping("getEmp")
	public ModelAndView findEmployee(Employee employee) {
		ModelAndView modelAndView = new ModelAndView("employee", "emps", employeeService.findAll());

		return modelAndView;

	}

	@RequestMapping(value = "editEmp", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws invalidEmployeeIdException {

		Employee empToEdit = employeeService.findByID(id);;
		ModelAndView modelAndView = new ModelAndView("editEmployee", "empToEdit", empToEdit);

		return modelAndView;
	}

	@RequestMapping(value = "updateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(@ModelAttribute("empToEdit") Employee employee) throws invalidEmployeeIdException {
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getEmp");

		return modelAndView;
	}

	@RequestMapping(value = "deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id) throws invalidEmployeeIdException {
		employeeService.delete(id);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getEmp");
		return modelAndView;
	}

}