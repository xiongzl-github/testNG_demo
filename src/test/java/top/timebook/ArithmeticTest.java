package top.timebook;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class ArithmeticTest {
    @Test
    public void testAdd() {
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.add(1, 2);
        Assert.assertEquals(result, 4);
        System.out.println("result = " + result);
    }

    @Test
    public void testMinus() {
        System.out.println("测试Minus方法");
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.minus(1, 2);
        // Assert.assertEquals(result, -1);
        // 使用软断言, 软断言如果第一次执行失败, 还会继续执行
        // 软断言就算assert都是错误的, 执行也会成功如果不加assertAll这个方法
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(result, 0);
        System.out.println("第一次断言执行结果");
        sa.assertEquals(result, -2);
        System.out.println("第二次断言执行结果");
        sa.assertAll();
    }

    @Test
    public void testAddString() {
        Arithmetic arithmetic = new Arithmetic();
        final String result = arithmetic.addString("a", "b");
        Assert.assertEquals(result, "ab");
        System.out.println("result = " + result);
    }

    @Test
    public void testGetArray() {
        Arithmetic arithmetic = new Arithmetic();
        int[] result = arithmetic.getArray();
        int[] temp = {1, 2, 3};
        Assert.assertEquals(result, temp);
        System.out.println("result = " + Arrays.toString(result));
    }


}