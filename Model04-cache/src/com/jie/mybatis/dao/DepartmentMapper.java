package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Department;

public interface DepartmentMapper {

    Department getDepartmentById(Integer id);

    Department getDepartmentByIdPlus(Integer id);

    Department getDepartmentByIdStep(Integer id);
}
