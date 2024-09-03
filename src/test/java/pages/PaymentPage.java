package pages;

import objectData.CardObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//input[@data-qa='name-on-card']")
    private WebElement nameInputElement;
    @FindBy (xpath = "//input[@data-qa='card-number']")
    private WebElement numberInputElement;
    @FindBy (xpath = "//input[@data-qa='cvc']")
    private WebElement cvcInputElement;
    @FindBy (xpath = "//input[@data-qa='expiry-month']")
    private WebElement monthInputElement;
    @FindBy (xpath = "//input[@data-qa='expiry-year']")
    private WebElement yearInputElement;
    @FindBy (xpath = "//button[@data-qa='pay-button']")
    private WebElement payButtonElement;

    public void payOrder(CardObject input){
        elementMethods.sendValue(nameInputElement, input.getNameCardValue());
        elementMethods.sendValue(numberInputElement, input.getCardNumberValue());
        elementMethods.sendValue(cvcInputElement, input.getCvcCardNumber());
        elementMethods.sendValue(monthInputElement, input.getExpirationMonthCardNumberValue());
        elementMethods.sendValue(yearInputElement, input.getExpirationYearCardNumberValue());
        pageMethods.scrollDown(payButtonElement);
        elementMethods.clickElement(payButtonElement);
    }
}
