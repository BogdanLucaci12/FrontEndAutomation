package pages;

import loggerUtility.LoggerUtility;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//a[@href='/payment']")
    private WebElement placeOrderElement;

    public void placeOrder(){
        pageMethods.scrollDown(placeOrderElement);
        LoggerUtility.info("User scroll in to view place order element");
        elementMethods.clickElement(placeOrderElement);
        LoggerUtility.info("User place the order");
    }
}
