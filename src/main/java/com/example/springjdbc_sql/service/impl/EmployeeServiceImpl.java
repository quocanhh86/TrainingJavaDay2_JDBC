package com.example.springjdbc_sql.service.impl;

import com.example.springjdbc_sql.dao.IEmployeeDao;
import com.example.springjdbc_sql.entity.Employee;
import com.example.springjdbc_sql.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeDao employeeDao;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        employeeDao.updateEmployee(employee, id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }
}
