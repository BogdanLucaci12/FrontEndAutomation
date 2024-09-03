package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
@Getter
public class SharedData {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver=new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The browser is open with succes");
    }
//    @AfterMethod
//    public void clearEnvironment(ITestResult result){
//        if(!result.isSuccess()){
//            LoggerUtility.error(result.getThrowable().getMessage());
//        }
//        LoggerUtility.info("The browser is close with succes");
//        driver.quit();
//    }
}
