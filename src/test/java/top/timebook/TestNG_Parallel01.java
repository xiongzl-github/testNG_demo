package top.timebook;

import org.testng.annotations.Test;

/**
 * @author xiongzl
 **/
public class TestNG_Parallel01 {

    @Test
    public void test01() throws InterruptedException {
        System.out.println("TestNG_Parallel01=============>>test01");
        Thread.sleep(5000);
    }

    @Test
    public void test02() throws InterruptedException {
        System.out.println("TestNG_Parallel01=============>>test02");
        Thread.sleep(5000);
    }


}
