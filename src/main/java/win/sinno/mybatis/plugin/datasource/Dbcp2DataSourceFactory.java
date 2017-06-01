package win.sinno.mybatis.plugin.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import win.sinno.mybatis.plugin.util.SetterUtil;
import win.sinno.mybatis.plugin.util.StringUtil;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
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
        setField(dataSource.getClass(), ps);
    }

    private void setField(Class<?> clazz, Properties properties) {

        Enumeration<Object> keys = properties.keys();

        Object obj = null;
        String key = null;
        Object valObj = null;
        String val = null;

        while (keys.hasMoreElements()) {
            obj = keys.nextElement();

            if (obj != null) {
                key = String.valueOf(obj);
                valObj = properties.get(key);

                if (valObj != null) {
                    val = String.valueOf(valObj);

                    if (StringUtil.isNotBlack(val)) {
                        setFiled(clazz, key, val);
                    }
                }
            }
        }

    }

    private void setFiled(Class<?> clazz, String name, String val) {
        Method[] methods = clazz.getDeclaredMethods();
        String targetMethodName = SetterUtil.getSetterName(name);

        for (Method method : methods) {
            String methodName = method.getName();
            Class<?>[] classes = method.getParameterTypes();

            if (targetMethodName.equals(methodName) && classes.length == 1) {

                Class<?> paramClazz = classes[0];
                Object param = null;

                if (String.class == paramClazz) {
                    param = val;
                }

                if (Long.class == paramClazz || long.class == paramClazz) {
                    try {
                        Long l = Long.valueOf(val);
                        param = l;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (Integer.class == paramClazz || int.class == paramClazz) {
                    try {
                        Integer i = Integer.valueOf(val);
                        param = i;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (Boolean.class == paramClazz || boolean.class == paramClazz) {
                    try {
                        Boolean b = Boolean.valueOf(val);
                        param = b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                if (param != null) {
                    invoke(method, param);
                }

                break;
            }

        }
    }

    private void invoke(Method method, Object val) {
        try {
            method.invoke(dataSource, val);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
