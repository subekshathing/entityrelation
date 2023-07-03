package com.employeemployee.controller;

import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.service.ContactService;
import com.employeemployee.service.DepartmentService;
import com.employeemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public  String viewHomePage(Model model){
        model.addAttribute("employeeList",employeeService.getAllEmployee());
        model.addAttribute("contactList",contactService.getAllContact());
        model.addAttribute("departmentList",departmentService.getAll());
        return "index";
    }

    @GetMapping("/add_emp")
    public String addNewEmployee(Model model){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        model.addAttribute("employee",employeeDTO);
        model.addAttribute("department",departmentService.getAll());
        return "addEmployee";
}
   @PostMapping("/save")
   public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO){
        employeeService.save(employeeDTO);
        return "redirect:/";
   }
   @GetMapping("update/{id}")
    public String updateForm(@PathVariable(value = "id")long id ,Model model){
        EmployeeDTO employeeDTO=employeeService.getById(id);
      model.addAttribute("department",departmentService.getAll());
      model.addAttribute("employee",employeeDTO);
        return "update";
   }

   @PostMapping("updateEmployee/{id}")
   public String UpdateEmp(@PathVariable long id,EmployeeDTO employeeDTO){
        employeeService.updateEmp(id,employeeDTO);
        return "redirect:/";
   }
   @GetMapping("delete/{id}") //returnig homepage so getmapping in deletemapping
    public String deleteById(@PathVariable(value = "id") long id ){
        employeeService.deleteById(id);
        return "redirect:/";
   }
}
