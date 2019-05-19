package com.jie.mybatis.test;

import com.jie.mybatis.bean.Employee;
import com.jie.mybatis.dao.EmployeeAnnotationMapper;
import com.jie.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("id", 1);
//            params.put("lastName", "Tom");
//            Employee tom = mapper.getEmployeeByIdAndLastName(1, "Tom");
//            mapper.getEmployeeByIdAndLastName()
//            System.out.println(tom);


//            Employee emp = mapper.getEmployeeByFistId(Arrays.asList(1, 2, 3));
//            System.out.println(emp);

//            Employee emp1 = mapper.getEmployeeByFistIdArray(new Integer[]{1, 2, 3});
//            System.out.println(emp1);

            List<Employee> emps = mapper.getEmployeesIdIn(Arrays.asList(1, 2, 4));
            System.out.println(emps);
        }
    }


}
