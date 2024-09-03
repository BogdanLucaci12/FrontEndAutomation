package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class AlertsMethods {
    public WebDriver driver;
    public void waitForAlert(){
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(){
        waitForAlert();
        Alert waitConfirm=driver.switchTo().alert();
        waitConfirm.accept();
    }

}
