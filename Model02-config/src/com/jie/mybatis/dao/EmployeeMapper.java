package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);
}
