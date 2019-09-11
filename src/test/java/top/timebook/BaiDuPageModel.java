package top.timebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author xiongzl
 **/
public class BaiDuPageModel {
    private WebDriver driver;

    @FindBy(id = "kw")
    private WebElement BDInput;

    @FindBy(id = "su")
    private WebElement BDButton;

    public void setKeyWord(String keyWord) {
        this.BDInput.sendKeys(keyWord);
    }

    public BaiDuPageModel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchButton(){
        this.BDButton.click();
    }
}
