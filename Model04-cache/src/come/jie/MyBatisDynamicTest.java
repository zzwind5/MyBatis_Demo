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

}
