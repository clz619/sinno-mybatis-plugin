package win.sinno.mybaitis.plugin.util;

import org.junit.Test;
import win.sinno.mybatis.plugin.datasource.Dbcp2DataSourceFactory;

import java.util.Properties;

/**
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-06-01 11:27.
 */
public class Dbcp2DataSourceFactoryTest {

    @Test
    public void test() {

        Properties prop = new Properties();
        prop.put("url", "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&allowMultiQueries=true");
        prop.put("username", "aaaa");
        prop.put("password", "dfgdsk");
        prop.put("driverClassName", "com.mysql.jdbc.Driver");
        prop.put("maxTotal", "10");
        prop.put("maxIdle", "10");
        prop.put("minIdle", "1");
        prop.put("maxWaitMillis", 60000);
        prop.put("testWhileIdle", true);
        prop.put("timeBetweenEvictionRunsMillis",
                30000);
        prop.put("numTestsPerEvictionRun", 5);
        prop.put("minEvictableIdleTimeMillis", 100000);
        prop.put("softMinEvictableIdleTimeMillis",
                -1);
        prop.put("lifo", false);

        Dbcp2DataSourceFactory factory = new Dbcp2DataSourceFactory();
        factory.setProperties(prop);

        System.out.println(factory);
    }
}
