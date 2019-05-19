package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeAnnotationMapper {

    @Select("select * from tbl_employee where id=#{id}")
    Employee getEmployeeById(Integer id);
}
