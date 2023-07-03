package com.employeemployee.controller;

import com.employeemployee.dto.ContactDTO;
import com.employeemployee.service.ContactService;
import com.employeemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public  String viewHomePage(Model model){
        model.addAttribute("contactList",contactService.getAllContact());
        model.addAttribute("employeeList",employeeService.getAllEmployee());
        return "contact";
    }

    @GetMapping("/add")
    public String addContact(Model model){
        ContactDTO contactDTO =new ContactDTO();
        model.addAttribute("contact",contactDTO);
        model.addAttribute("employees",employeeService.getAllEmployee());
        return "addContact";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("contact") ContactDTO contactDTO){
        contactService.saveCon(contactDTO);
        return "redirect:/";
    }
    @GetMapping("updateForm/{id}")
    public String updateForm(@PathVariable(value = "id")long id , Model model){
        ContactDTO contactDTO=contactService.getById(id);
        model.addAttribute("contact",contactDTO);
        model.addAttribute("employees",employeeService.getAllEmployee());
        return "contact";
    }
    @PostMapping("updateContact/{id}")
    public String updateCon(@PathVariable long id , ContactDTO dto){
        contactService.updateCon(id,dto);
        return "redirect:/";
    }
    @GetMapping("deleteContact/{id}") //returnig homepage so getmapping in deletemapping
    public String deleteById(@PathVariable(value = "id") long id ){
        contactService.deleteById(id);
        return "redirect:/";
    }
}