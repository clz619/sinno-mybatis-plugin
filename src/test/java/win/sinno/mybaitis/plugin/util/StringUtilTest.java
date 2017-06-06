package win.sinno.mybaitis.plugin.util;

import org.junit.Assert;
import org.junit.Test;
import win.sinno.mybatis.plugin.util.StringUtil;

/**
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-06-01 10:56.
 */
public class StringUtilTest {

    @Test
    public void test() {
        String a1 = null;
        String a2 = "";
        String a3 = "  ";
        String a4 = " d ";
        String a5 = "c  d";
        String a6 = "c  ";
        String a7 = "  c";

        Assert.assertEquals(true, StringUtil.isBlank(a1));
        Assert.assertEquals(true, StringUtil.isBlank(a2));
        Assert.assertEquals(true, StringUtil.isBlank(a3));
        Assert.assertEquals(false, StringUtil.isBlank(a4));
        Assert.assertEquals(false, StringUtil.isBlank(a5));
        Assert.assertEquals(false, StringUtil.isBlank(a6));
        Assert.assertEquals(false, StringUtil.isBlank(a7));

        Assert.assertEquals(false, StringUtil.isNotBlank(a1));
        Assert.assertEquals(false, StringUtil.isNotBlank(a2));
        Assert.assertEquals(false, StringUtil.isNotBlank(a3));
        Assert.assertEquals(true, StringUtil.isNotBlank(a4));
        Assert.assertEquals(true, StringUtil.isNotBlank(a5));
        Assert.assertEquals(true, StringUtil.isNotBlank(a6));
        Assert.assertEquals(true, StringUtil.isNotBlank(a7));
    }

}
