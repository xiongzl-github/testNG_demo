package top.timebook;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author xiongzl
 **/
public class SeleniumGridParalleTest {
    private RemoteWebDriver webDriver;
    private static final String URL = "https://www.baidu.com/";
    private static final String NODE_URL = "http://192.168.199.103:5656/wd/hub";


    @BeforeClass
    private void beforeClass() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(Boolean.TRUE);
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("disable-dev-shm-usage");
        chromeOptions.addArguments("blink-settings=imagesEnabled=false");
        chromeOptions.addArguments("disable-gpu");
        webDriver = new RemoteWebDriver(new URL(NODE_URL), chromeOptions);
        // 定位到目标url
        webDriver.get(URL);
        // 使测试窗口最大化
        webDriver.manage().window().maximize();
        // 使用隐式等待(隐式等待对页面上所有元素都适用, 对加载慢的元素其都会等待3秒钟)
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    private void webListenerTest() {
        System.out.println("hello world");
        webDriver.findElement(By.id("su")).click();
        System.out.println("hello world");
    }

    @AfterClass
    private void afterClass() {
        webDriver.quit();
    }




}
