package top.timebook;

import org.testng.annotations.Test;

/**
 * @author xiongzl
 **/
public class TestNG_Enable_Timeout {

    /**
     * 如果不想一个测试用例执行, 那么就可以使用enabled = false属性
     * 如果想要一个方法再规定时间执行完成, 否则就失败, 就可以使用timeout属性
     **/

    @Test(enabled = false)
    public void test01(){
        System.out.println("test01");
    }

    @Test(timeOut = 200)
    public void test02() throws InterruptedException {
        System.out.println("test02");
        Thread.sleep(300);
    }



}
