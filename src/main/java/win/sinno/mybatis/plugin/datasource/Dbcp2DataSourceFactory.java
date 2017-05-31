package win.sinno.mybatis.plugin.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * dbcp 2 data source
 *
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-05-31 09:50.
 */
public class Dbcp2DataSourceFactory implements DataSourceFactory {

    private BasicDataSource dataSource;

    public Dbcp2DataSourceFactory() {
        dataSource = new BasicDataSource();
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void setProperties(Properties ps) {
        dataSource.setDriverClassName(ps.getProperty("driverClassName"));
        dataSource.setUrl(ps.getProperty("url"));
        dataSource.setUsername(ps.getProperty("username"));
        dataSource.setPassword(ps.getProperty("password"));
        dataSource.setInitialSize(Integer.parseInt(ps.getProperty("initialSize", "2")));
        dataSource.setMaxTotal(Integer.parseInt(ps.getProperty("maxTotal", "20")));
        dataSource.setMaxIdle(Integer.parseInt(ps.getProperty("maxIdle", "8")));
        dataSource.setMinIdle(Integer.parseInt(ps.getProperty("minIdle", "0")));
        dataSource.setMaxWaitMillis(Long.parseLong(ps.getProperty("maxWaitMillis", "60000")));
        dataSource.setTestWhileIdle("true".equals(ps.getProperty("testWhileIdle", "false")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(ps.getProperty("timeBetweenEvictionRunsMillis", "-1")));
        dataSource.setNumTestsPerEvictionRun(Integer.parseInt(ps.getProperty("numTestsPerEvictionRun", "3")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(ps.getProperty("minEvictableIdleTimeMillis", "-1")));
        dataSource.setSoftMinEvictableIdleTimeMillis(Long.parseLong(ps.getProperty("softMinEvictableIdleTimeMillis", "-1")));

        dataSource.setRemoveAbandonedOnBorrow("true".equals(ps.getProperty("removeAbandonedOnBorrow", "false")));
        dataSource.setRemoveAbandonedTimeout(Integer.parseInt(ps.getProperty("removeAbandonedTimeout", "300")));
        dataSource.setLogAbandoned("true".equals(ps.getProperty("logAbandoned", "false")));
    }

}
