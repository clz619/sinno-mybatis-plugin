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

        Assert.assertEquals(true, StringUtil.isBlack(a1));
        Assert.assertEquals(true, StringUtil.isBlack(a2));
        Assert.assertEquals(true, StringUtil.isBlack(a3));
        Assert.assertEquals(false, StringUtil.isBlack(a4));
        Assert.assertEquals(false, StringUtil.isBlack(a5));
        Assert.assertEquals(false, StringUtil.isBlack(a6));
        Assert.assertEquals(false, StringUtil.isBlack(a7));

        Assert.assertEquals(false, StringUtil.isNotBlack(a1));
        Assert.assertEquals(false, StringUtil.isNotBlack(a2));
        Assert.assertEquals(false, StringUtil.isNotBlack(a3));
        Assert.assertEquals(true, StringUtil.isNotBlack(a4));
        Assert.assertEquals(true, StringUtil.isNotBlack(a5));
        Assert.assertEquals(true, StringUtil.isNotBlack(a6));
        Assert.assertEquals(true, StringUtil.isNotBlack(a7));
    }

}
