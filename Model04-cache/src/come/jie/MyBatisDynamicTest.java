package come.jie;

import com.jie.mybatis.bean.Employee;
import com.jie.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisDynamicTest {

    private SqlSessionFactory sqlSessionFactory;
    public static final String CONFIG_FILE = "mybatis.xml";

    @Before
    public void initiate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void testFirstLevelCache(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp1 = mapper.getEmployee(1);
            System.out.println(emp1);
            // some service logic
            Employee emp2 = mapper.getEmployee(1);
            System.out.println(emp2);
            System.out.println(emp1==emp2);     //true
        }
    }

    @Test
    public void testSecondLevelCache(){
        SqlSession session_1 = sqlSessionFactory.openSession();
        SqlSession session_2 = sqlSessionFactory.openSession();

        EmployeeMapper mapper_1 = session_1.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper_2 = session_2.getMapper(EmployeeMapper.class);

        Employee emp_1 = mapper_1.getEmployee(1);
        System.out.println(emp_1);
        session_1.close();

        //第二次查询是从二级缓存中获取，并没有发送新的sql
        Employee emp_2 = mapper_2.getEmployee(1);
        System.out.println(emp_2);
        session_2.close();
    }

}
