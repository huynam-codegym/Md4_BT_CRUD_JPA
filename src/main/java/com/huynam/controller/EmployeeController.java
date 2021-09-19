package com.huynam.controller;

import com.huynam.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.huynam.service.IEmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("/")
    public ModelAndView listEmployee(){
        List<Employee> employeeList = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listEmployee",employeeList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("createForm",new Employee());
        return modelAndView;
    }
    @PostMapping("/create/employee")
    public String createEmployee(@ModelAttribute("createForm")Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("editForm",employee);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("editForm") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detailEmployee(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detailEmployee",employee);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
      Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("deleteForm",employee);
        return modelAndView;
    }
    @PostMapping("/delete/Employee")
    public String deleteEmployee(@ModelAttribute("deleteForm") Employee employee){
        System.out.println("employee ID"+employee.getId());
      employeeService.delete(employee.getId());
        return "redirect:/";
    }
}