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
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Employee employee = sqlSession.selectOne("com.jie.mybatis.bean.Employee.selectEmployee", 1);
            System.out.println(employee);
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        System.out.println("OK");

    }

    @Test
    public void test22(){
        SqlSession sqlSession = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployee(2);
            System.out.println(employee);
        }finally {
            sqlSession.close();
        }
    }
}
