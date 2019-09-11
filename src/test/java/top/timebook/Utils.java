package top.timebook;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * @author xiongzl
 **/
public class Utils {

    /**
     * 将截图拷贝到本地目录
     *
     * @param driver a webDriver
     * @param fileName 文件的名称
     * @return java.lang.String
     * @author xiongzl
     * @date 2019/9/5 19:13
     **/
    public static String takeScreenShot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "D:\\Reports\\Screenshots\\";
        String destFilePath = directory + fileName;
        final TakesScreenshot screenshot  = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(destFilePath));
        return destFilePath;
    }



}
