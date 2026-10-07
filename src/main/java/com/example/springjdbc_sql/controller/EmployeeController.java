package com.example.springjdbc_sql.controller;

import com.example.springjdbc_sql.entity.Employee;
import com.example.springjdbc_sql.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping("/employee")
    public String getAllEmployees(Model model, @ModelAttribute Employee employee) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable int id, Model model)
    {
        Employee employeeDetail = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employeeDetail);
        return "employee";
    }

    @PostMapping("/employee")
    public String addEmployee(@ModelAttribute Employee employee)
    {
        List<Employee> employees = employeeService.getAllEmployees();
        employee.setId(employees.size() + 1);
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

}
