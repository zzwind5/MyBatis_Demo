package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;

public interface EmployeeMapper {

    Employee getEmployee(Integer id);

    long addEmp(Employee emp);

    long updateEmp(Employee employee);

    long deleteEmp(Integer id);
}
