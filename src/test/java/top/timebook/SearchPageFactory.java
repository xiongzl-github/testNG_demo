package top.timebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
    private WebDriver driver;

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement fight;

    @FindBy(id = "flight-type-one-way-label-hp-flight")
    private WebElement fightTab;

    @FindBy(id = "flight-type-roundtrip-label-hp-flight")
    private WebElement roundTrip;

    @FindBy(id = "flight-type-multi-dest-label-hp-flight")
    private WebElement multipleDestination;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement origin;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement destination;

    @FindBy(id = "flight-departing-single-hp-flight")
    private WebElement departure;

    @FindBy(xpath = "//button[@class='datepicker-close-btn close btn-text']")
    private WebElement closeCalIcon;

    public SearchPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFight(){
    	fight.click();
	}

    public void clickFightTab() {
        fightTab.click();
    }

    public void clickRoundTrip() {
        roundTrip.click();
    }

    public void clickMultipleDestination() {
        multipleDestination.click();
    }

    public void setOriginCity(String originCity) {
        origin.sendKeys(originCity);
    }

    public void setDestinationCity(String destinationCity) {
        destination.sendKeys(destinationCity);
    }

    public void setDeaprtureDate(String departureDate) {
        departure.sendKeys(departureDate);
    }

    public void clickCalendar() {
        closeCalIcon.click();
    }
}
