package top.timebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import top.timebook.listener.HandleEvents;

import java.util.concurrent.TimeUnit;

/**
 * @author xiongzl
 **/
public class TestNG_WebListeners {

    private WebDriver webDriver;

    private HandleEvents handleEvents;

    private EventFiringWebDriver eventFiringWebDriver;

    private static final String URL = "https://www.baidu.com/";

    private static final String DRIVER_PATH = "E:\\project\\testNG-demo\\chromedriver.exe";

    @BeforeClass
    private void beforeClass() {
        setWebDriver();
        handleEvents = new HandleEvents();
        webDriver = getWebDriver(new ChromeDriver());
        eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(handleEvents);
    }

    @Test
    private void webListenerTest() {
        eventFiringWebDriver.findElement(By.id("su")).click();
    }

    /**
     * 设置WebDriver
     *
     * @return void
     * @author xiongzl
     * @date 2019/8/29 11:25
     **/
    private void setWebDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, DRIVER_PATH);
    }

    /**
     * 初始化WebDriver
     *
     * @param webDriver a webDriver
     * @return org.openqa.selenium.WebDriver
     * @author xiongzl
     * @date 2019/8/29 11:25
     **/
    private WebDriver getWebDriver(WebDriver webDriver) {
        // 定位到目标url
        webDriver.get(URL);
        // 使测试窗口最大化
        webDriver.manage().window().maximize();
        // 使用隐式等待(隐式等待对页面上所有元素都适用, 对加载慢的元素其都会等待3秒钟)
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return webDriver;
    }

    @AfterClass
    private void afterClass() {
        webDriver.quit();
    }




}
