package com.example.springjdbc_sql.dao;

import com.example.springjdbc_sql.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee, int id);
    void deleteEmployee(int id);
    Employee getEmployeeById(int id);
}
