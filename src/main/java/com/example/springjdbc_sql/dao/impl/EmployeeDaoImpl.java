package com.example.springjdbc_sql.dao.impl;

import com.example.springjdbc_sql.dao.IEmployeeDao;
import com.example.springjdbc_sql.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class EmployeeDaoImpl implements IEmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM EMPLOYEE";
        return jdbcTemplate.query(sql, new  RowMapper<Employee>() {
            @Override
            public Employee mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                return employee;
            }
        });
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql =  "INSERT INTO EMPLOYEE (name, age) VALUES ('"+employee.getName()+"', "+employee.getAge()+")";
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        String sql = "UPDATE EMPLOYEE SET NAME = ? , AGE = ? WHERE ID = ?";
        jdbcTemplate.update(sql,employee.getName(),employee.getAge(),id);
    }

    @Override
    public void deleteEmployee(int id) {
        String sql =  "DELETE FROM EMPLOYEE WHERE id = '"+id+"'";
        jdbcTemplate.execute(sql);
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM EMPLOYEE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,  (rs, rowNum) ->
                Employee
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .build(), id);
    }
}
