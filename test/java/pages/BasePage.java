package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver", 
        "C:\\Users\\Beep Informatica\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }
    private WebElement find(String locator){
        

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
 
    public void clickElement(String locator){
        find(locator).click();
    }


    public void write(String locator, String textToWrite){

        find(locator).clear();
        find(locator).sendKeys(textToWrite);

    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){

        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);

    }

    public void selectFromDropdownByIndex(String locator, Integer valueToSelect){

        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);

    }

    public void hoverOverElement(String locator){
        action.moveToElement(find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(find(locator));
    }

    public void rightClick(String locator){

        action.contextClick(find(locator));

    }

    public String getValueFromTable(String locator, int row, int column){
        
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){

        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(String iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String textFromElement(String locator){

        return find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){

        return find(locator).isDisplayed();
    }

}