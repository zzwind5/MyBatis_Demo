package come.jie;

import com.jie.mybatis.bean.Employee;
import com.jie.mybatis.bean.EmployeeExample;
import com.jie.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
    public void testMBG() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void test01() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.selectByExample(null);
            for (Employee employee : employees) {
                System.out.println(employee.getId());
            }
        }
    }

    @Test
    public void test02() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            EmployeeExample example = new EmployeeExample();

            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andLastNameLike("%e%");
            criteria.andGenderEqualTo("1");

            EmployeeExample.Criteria criteria2 = example.createCriteria();
            criteria2.andEmailLike("%e%");

            example.or(criteria2);

            List<Employee> employees = mapper.selectByExample(example);
            for (Employee employee : employees) {
                System.out.println(employee.getId());
            }

        }
    }

}
