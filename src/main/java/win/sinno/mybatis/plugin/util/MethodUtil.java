package win.sinno.mybatis.plugin.util;

/**
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-06-01 10:47.
 */
public final class MethodUtil {

    public static final String getSetterName(String fieldName) {
        if (StringUtil.isBlank(fieldName)) {
            return null;
        }

        String upperFc = fieldName.substring(0, 1).toUpperCase();
        String setterName = "set" + upperFc;

        if (fieldName.length() > 1) {
            setterName += fieldName.substring(1, fieldName.length());
        }

        return setterName;
    }
}
