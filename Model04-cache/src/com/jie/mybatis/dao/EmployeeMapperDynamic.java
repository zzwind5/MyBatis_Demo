package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamic {

    List<Employee> getEmployeesByConditionIf(Employee emp);

    List<Employee> getEmployeesByConditionTrim(Employee emp);

    List<Employee> getEmployeeByConditionChoose(Employee employee);

    void updateEmployee(Employee employee);

    List<Employee> getEmployeeByConditionForeach(List<Integer> ids);

    void addEmployees(@Param("emps") List<Employee> employees);
}
