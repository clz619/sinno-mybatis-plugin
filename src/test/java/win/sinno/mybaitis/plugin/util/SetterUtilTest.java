package win.sinno.mybaitis.plugin.util;

import org.junit.Assert;
import org.junit.Test;
import win.sinno.mybatis.plugin.util.SetterUtil;

/**
 * TODO
 *
 * @author : admin@chenlizhong.cn
 * @version : 1.0
 * @since : 2017-06-01 10:49.
 */
public class SetterUtilTest {

    @Test
    public void testName() {
        String n = SetterUtil.getSetterName("helloWorld");
        Assert.assertEquals("setHelloWorld", n);


        n = SetterUtil.getSetterName("");
        Assert.assertEquals(null, n);

        n = SetterUtil.getSetterName("a");
        Assert.assertEquals("setA", n);
    }
}
