package com.jie.mybatis.dao;

import com.jie.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);

    void addEmpoloyee(Employee employee);

    void updateEmployee(Employee employee);

    int deleteEmployee(Integer id);

    Employee getEmployeeByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    Employee getEmployeeByFistId(List<Integer> ids);

    Employee getEmployeeByFistIdArray(Integer[] ids);

    List<Employee> getEmployeesIdIn(List<Integer> ids);

    List<Employee> getEmployees();

    Map<String, Object> getEmployeeMap(Integer id);

    @MapKey("lastName")
    Map<String, Employee> getEmployeeMaps();

    Employee getEmployeeAndDepartmentById(Integer id);

    Employee getEmployeeByIdStep(Integer id);

    List<Employee> getEmployeeByDeptId(Integer deptId);

    Employee getEmployeeByIdDis(Integer id);
}
