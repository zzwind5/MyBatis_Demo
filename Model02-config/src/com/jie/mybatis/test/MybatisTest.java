package com.jie.mybatis.test;

import com.jie.mybatis.bean.Department;
import com.jie.mybatis.bean.Employee;
import com.jie.mybatis.dao.DepartmentMapper;
import com.jie.mybatis.dao.EmployeeAnnotationMapper;
import com.jie.mybatis.dao.EmployeeDynamicMapper;
import com.jie.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public static final String MYBATIS_FILE = "mybatis.xml";
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void test01(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById(4);
            System.out.println(employee);
        }
    }

    @Test
    public void test02(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeAnnotationMapper mapper = sqlSession.getMapper(EmployeeAnnotationMapper.class);
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test03(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//            //insert
//            Employee employee = new Employee(null, "test", "1", "test@aerohive.com");
//            mapper.addEmpoloyee(employee);
//            System.out.println(employee);

//            //update
//            Employee employee = new Employee(6, "test", "1", "test22222@aerohive.com");
//            mapper.updateEmployee(employee);

//            //select
//            Employee emp = mapper.getEmployeeById(6);
//            System.out.println(emp);

//            //delete
//            int count = mapper.deleteEmployee(8);
//            System.out.println(count);

            sqlSession.commit();
        }
    }

    @Test
    public void test04(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.getEmployees();
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void test05(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> employeeMap = mapper.getEmployeeMap(1);
            System.out.println(employeeMap);
        }
    }

    @Test
    public void test06(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Employee> employeeMaps = mapper.getEmployeeMaps();
            for (Map.Entry<String, Employee> integerEmployeeEntry : employeeMaps.entrySet()) {
                System.out.println(integerEmployeeEntry);
            }

        }
    }

    @Test
    public void test07() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeAndDepartmentById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test08() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeByIdStep(1);
            System.out.println(employee.getLastName());
            System.out.println(employee.getDepartment().getDeptName());
        }
    }

    @Test
    public void test09() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = mapper.getDepartmentByIdPlus(1);
            System.out.println(department);
        }
    }

    @Test
    public void test10() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department departments = mapper.getDepartmentByIdLazy(1);
            System.out.println(departments.getDeptName());
            System.out.println(departments.getEmployees());
        }
    }

    @Test
    public void test11() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmployeeByIdDis(4);
            System.out.println(emp);
        }
    }

    @Test
    public void test12() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeDynamicMapper mapper = sqlSession.getMapper(EmployeeDynamicMapper.class);
            Employee jie = new Employee(2, null, null, "jie@163.com");
            Employee emp = mapper.getEmployeeByCondition(jie);
            System.out.println(emp);
        }
    }
}
