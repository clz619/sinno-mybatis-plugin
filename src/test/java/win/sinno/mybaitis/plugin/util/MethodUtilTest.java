package win.sinno.mybaitis.plugin.util;

import org.junit.Assert;
import org.junit.Test;
import win.sinno.mybatis.plugin.util.MethodUtil;

/**
 * TODO
 *
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-06-01 10:49.
 */
public class MethodUtilTest {

    @Test
    public void testName() {
        String n = MethodUtil.getSetterName("helloWorld");
        Assert.assertEquals("setHelloWorld", n);


        n = MethodUtil.getSetterName("");
        Assert.assertEquals(null, n);

        n = MethodUtil.getSetterName("a");
        Assert.assertEquals("setA", n);
    }
}
