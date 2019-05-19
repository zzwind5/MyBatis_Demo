package come.jie;

import com.jie.mybatis.bean.Department;
import com.jie.mybatis.bean.Employee;
import com.jie.mybatis.dao.EmployeeMapperDynamic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBatisDynamicTest {

    private SqlSessionFactory sqlSessionFactory;
    public static final String CONFIG_FILE = "mybatis.xml";

    @Before
    public void initiate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void test01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null, "%", "0", null);

            List<Employee> emps = mapper.getEmployeesByConditionIf(employee);
            emps.forEach(emp->{
                System.out.println(emp);
            });
        }
    }

    @Test
    public void test02() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null, "%", "0", null);

            List<Employee> emps = mapper.getEmployeesByConditionTrim(employee);
            emps.forEach(emp->{
                System.out.println(emp);
            });
        }
    }

    @Test
    public void test03() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null, null, "0", null);

            List<Employee> emps = mapper.getEmployeeByConditionChoose(employee);
            emps.forEach(emp->{
                System.out.println(emp);
            });
        }
    }

    @Test
    public void test04() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(5, "haha", "0", "haha@gmail.com");

            mapper.updateEmployee(employee);
            sqlSession.commit();
        }
    }

    @Test
    public void test05() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            List<Employee> emps = mapper.getEmployeeByConditionForeach(Arrays.asList(1, 2, 3, 4, 5));
            System.out.println(emps);
        }
    }

    @Test
    public void test06() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(null, "yang3", "0", "yang@163.com", new Department(1)));
            employees.add(new Employee(null, "left3", "1", "left@163.com", new Department(2)));
            mapper.addEmployees(employees);

            sqlSession.commit();
        }
    }
}
