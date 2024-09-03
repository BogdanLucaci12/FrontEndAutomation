package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
@AllArgsConstructor
public class ElementMethod {

    private WebDriver driver;
    public void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElement(WebElement element){
        waitForElementVisible(element);
        element.click();
    }
    public void selectByTextElement(WebElement element, String s){
        Select select=new Select(element);
        select.selectByVisibleText(s);
    }
    public void sendValue(WebElement element, String values){
        element.sendKeys(values);
    }

    public void sendKeysEnter(String s, WebElement element){
        element.sendKeys(s);
        element.sendKeys(Keys.ENTER);
    }


    public void selectByValue(WebElement element, String year){
        Select monthSelect=new Select(element);
        monthSelect.selectByVisibleText(year);
    }
    public void clearInput(WebElement element){
        element.clear();
    }
    public void sendFile(WebElement element, String filePath){
        File file=new File(filePath);
        element.sendKeys(file.getAbsolutePath());
    }
    public void hoverAction(WebElement element){
        waitForElementVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
