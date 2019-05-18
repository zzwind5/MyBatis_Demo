package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;

public interface EmployeeMapperPlus {

    Employee getEmployeeById(Integer id);

    Employee getEmployeeAndDeptById(Integer id);
}
