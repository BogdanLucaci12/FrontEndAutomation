package pages;

import helperMethods.AlertsMethods;
import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected ElementMethod elementMethods;
    protected PageMethods pageMethods;
    protected AlertsMethods alertsMethods;

    public BasePage(WebDriver driver){
        this.driver=driver;
        elementMethods=new ElementMethod(driver);
        pageMethods=new PageMethods(driver);
        alertsMethods=new AlertsMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
