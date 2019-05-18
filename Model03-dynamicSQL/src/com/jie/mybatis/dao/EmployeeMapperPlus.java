package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;

public interface EmployeeMapperPlus {

    Employee getEmployeeById(Integer id);

    Employee getEmployeeAndDeptById(Integer id);

    Employee getEmployeeByIdStep(Integer id);

    Employee getEmployeeByDeptId(Integer deptId);

    Employee getEmployeeByIdDiscrim(Integer id);
}
