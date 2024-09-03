package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[@class='fc-button-label' and text()='Consent']")
    private WebElement consent;

    public void closeConsentEngine(){
    elementMethods.clickElement(consent);
       LoggerUtility.info("Consent engine ");
    }
}
