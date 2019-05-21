package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Department;

public interface DepartmentMapper {

    Department getDepartment(Integer id);

    Department getDepartmentByIdPlus(Integer id);

    Department getDepartmentByIdLazy(Integer id);
}
