package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper {

    Employee getEmployee(Integer id);

    Employee getEmployeeByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);

    Employee getEmployeeByMap(Map params);

    long addEmp(Employee emp);

    long updateEmp(Employee employee);

    long deleteEmp(Integer id);
}
