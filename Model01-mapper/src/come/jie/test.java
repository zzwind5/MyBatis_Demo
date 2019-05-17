package come.jie;

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
import java.util.List;
import java.util.Map;

public class test {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void test11() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Employee employee = sqlSession.selectOne("com.jie.mybatis.bean.Employee.selectEmployee", 1);
            System.out.println(employee);
        }

        System.out.println("OK");

    }

    @Test
    public void test22(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployee(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test33() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeAnnotationMapper mapper = sqlSession.getMapper(EmployeeAnnotationMapper.class);
            Employee employee = mapper.getEmployee(2);
            System.out.println(employee);
        }
    }

    @Test
    public void test04(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession();) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee jerry = new Employee(null, "Jerry", "1", "jerry@123.com");
            long num = mapper.addEmp(jerry);
            System.out.println(jerry);

//            Employee upJerry = new Employee(3, "Jerry", "0", "jerry@163.com");
//            mapper.updateEmp(upJerry);

//            long count = mapper.deleteEmp(3);
//            System.out.println(count);
            sqlSession.commit();
        }
    }

    @Test
    public void test05(){
        try( SqlSession sqlSession = sqlSessionFactory.openSession() ){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee tom = mapper.getEmployeeByIdAndLastName(1, "Tom");
            System.out.println(tom);
        }
    }

    @Test
    public void test06(){
        try( SqlSession sqlSession = sqlSessionFactory.openSession() ){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee tom = mapper.getEmployeeByMap(Map.of("id", 1, "lastName", "Tom", "tableName", "tbl_employee"));
            System.out.println(tom);
        }
    }

    @Test
    public void test07(){
        try( SqlSession sqlSession = sqlSessionFactory.openSession() ){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> allEmployees = mapper.getAllEmployees();
            for (Employee allEmployee : allEmployees) {
                System.out.println(allEmployee);
            }
        }
    }

    @Test
    public void test08(){
        try( SqlSession sqlSession = sqlSessionFactory.openSession() ){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map map = mapper.getEmployeeByIdReturnMap(1);
            System.out.println(map);
            System.out.println(map.keySet());
            System.out.println(map.values());
        }
    }

    @Test
    public void test09(){
        try( SqlSession sqlSession = sqlSessionFactory.openSession() ){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<Integer, Employee> allEmployeeMap = mapper.getAllEmployeeMap();
            System.out.println(allEmployeeMap);
        }
    }
}
