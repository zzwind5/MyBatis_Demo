package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee getEmployee(Integer id);

    Employee getEmployeeByIdAndLastName(Integer id, String lastName);

    Employee getEmployeeByMap(Map params);

    List<Employee> getAllEmployees();

    Map<String, Object> getEmployeeByIdReturnMap(Integer id);

    @MapKey("lastName")
    Map<Integer, Employee> getAllEmployeeMap();

    long addEmp(Employee emp);

    long updateEmp(Employee employee);

    long deleteEmp(Integer id);
}
