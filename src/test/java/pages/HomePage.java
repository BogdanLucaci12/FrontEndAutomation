package pages;

import objectData.RegisterFormObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "susbscribe_email")
    private WebElement inputEmailElement;
    @FindBy(id = "subscribe")
    private WebElement submitSubscriptionElement;

    public void submitSubscription(RegisterFormObject input){
        pageMethods.scrollDown(inputEmailElement);
        elementMethods.sendValue(inputEmailElement, input.getEmailAdressValue());
        elementMethods.clickElement(submitSubscriptionElement);
    }
}
