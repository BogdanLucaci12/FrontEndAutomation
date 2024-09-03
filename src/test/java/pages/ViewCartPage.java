package pages;

import loggerUtility.LoggerUtility;
import lombok.extern.java.Log;
import objectData.LoginObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewCartPage extends BasePage {

    public ViewCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "cart_quantity_delete")
    private List<WebElement> deleteProductsElement;
    @FindBy (xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    private WebElement checkoutButtonElement;
    @FindBy (xpath = "//button[contains(text(), 'Continue On Cart')]")
    private WebElement continueOnCartButtonElement;
    @FindBy (xpath = "//a[@href='/login']")
    private List<WebElement> loginElement;
    @FindBy (xpath = "//input[@data-qa='login-email']")
    private WebElement logInEmailElement;
    @FindBy (xpath = "//input[@data-qa='login-password']")
    private WebElement passwordLoginInputElement;
    @FindBy (xpath = "//button[@data-qa='login-button']")
    private WebElement submitLoginButtonElement;
    LoginObject loginObject=new LoginObject("src/test/resources/testData/LoginData.json");
    ProductsPage productsPage=new ProductsPage(driver);
    public void deleteAProductFromCart(){
        elementMethods.clickElement(deleteProductsElement.get(0));
        LoggerUtility.info("User delete first product from cart");
    }
    public void goToCheckout(){
        elementMethods.clickElement(checkoutButtonElement);
        LoggerUtility.info("User click on check out button");
        if (elementMethods.isElementPresent(continueOnCartButtonElement)) {
                LoggerUtility.info("No user is displayed so we log in");
                loginToPurchase(loginObject);
        } else {
            LoggerUtility.info("User is logged in, move forward accesing checkout page");
        }
    }
    public void loginToPurchase(LoginObject input){
        elementMethods.clickElement(loginElement.get(1));
        LoggerUtility.info("User interact with login button");
        elementMethods.sendValue(logInEmailElement, input.getEmailValue());
        LoggerUtility.info("User fill email element with correct email");
        elementMethods.sendValue(passwordLoginInputElement, input.getPasswordValue());
        LoggerUtility.info("User fill password element with corect password");
        elementMethods.clickElement(submitLoginButtonElement);
        LoggerUtility.info("User interact with submit button for log in");
        productsPage.interactWithProductsPage();
        productsPage.goToCart();
        goToCheckout();
    }
}
