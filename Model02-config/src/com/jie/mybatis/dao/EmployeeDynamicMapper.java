package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;

public interface EmployeeDynamicMapper {

    Employee getEmployeeByCondition(Employee employee);
}
