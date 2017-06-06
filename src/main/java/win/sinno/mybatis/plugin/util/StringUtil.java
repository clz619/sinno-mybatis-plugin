package win.sinno.mybatis.plugin.util;

/**
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-06-01 10:39.
 */
public final class StringUtil {

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.trim().length() > 0;
    }
}
