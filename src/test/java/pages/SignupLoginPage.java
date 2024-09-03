package pages;

import loggerUtility.LoggerUtility;
import lombok.extern.java.Log;
import objectData.RegisterFormObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignupLoginPage extends BasePage {


    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//a[@href='/login']")
    private WebElement signupElement;
    @FindBy (xpath = "//input[@data-qa='signup-name']")
    private WebElement inputNameElement;
    @FindBy (xpath = "//input[@data-qa='signup-email']")
    private WebElement signUpEmailElement;
    @FindBy (xpath = "//button[@data-qa='signup-button']")
    private WebElement buttonSubmitSignUpElement;
    @FindBy (xpath = "//input[@data-qa='login-email']")
    private WebElement logInEmailElement;
    @FindBy (xpath = "//input[@data-qa='login-password']")
    private WebElement passwordLoginInputElement;
    @FindBy (xpath = "//button[@data-qa='login-button']")
    private WebElement submitLoginButtonElement;
    @FindBy (xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountElement;
    @FindBy (xpath = "//a[@href='/logout']")
    private WebElement logOutUserElement;
    @FindBy (xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButtonAfterDeleteAccountElement;
    public void interactWithSignUpPage(){
        elementMethods.clickElement(signupElement);
        LoggerUtility.info("User click on sign up element from navbar");
    }
    public void fillCredentialsForSignUp(RegisterFormObject input){
        elementMethods.sendValue(inputNameElement, input.getNameValue());
        LoggerUtility.info("User insert name in input name");
        elementMethods.sendValue(signUpEmailElement, input.getEmailAdressValue());
        LoggerUtility.info("User insert email in input email");
        elementMethods.clickElement(buttonSubmitSignUpElement);
        LoggerUtility.info("User submit the form for sign up");
    }

    public void deleteUserAccount(){
        elementMethods.clickElement(deleteAccountElement);
        LoggerUtility.info("User interact with delete account button");
        elementMethods.clickElement(continueButtonAfterDeleteAccountElement);
        LoggerUtility.info("User interact with continue button after deletion of account");
    }
    public void logOutUser(){
        elementMethods.clickElement(logOutUserElement);
        LoggerUtility.info("User interact with log out button");
    }
    public void logInUserWithCorrectEmailAndPassword(RegisterFormObject input){
        elementMethods.sendValue(logInEmailElement, input.getEmailAdressValue());
        LoggerUtility.info("User fill email element with correct email");
        elementMethods.sendValue(passwordLoginInputElement, input.getPasswordValue());
        LoggerUtility.info("User fill password element with corect password");
        elementMethods.clickElement(submitLoginButtonElement);
        LoggerUtility.info("User interact with submit button for log in");
    }
    public void logInUserWithIncorectEmailAndPassword(RegisterFormObject input){
        elementMethods.sendValue(logInEmailElement, input.getIncorrectEmailValue());
        LoggerUtility.info("User fill email element with incorrect email");
        elementMethods.sendValue(passwordLoginInputElement, input.getIncorrectPasswordValue());
        LoggerUtility.info("User fill password element with incorrect password");
        elementMethods.clickElement(submitLoginButtonElement);
        LoggerUtility.info("User interact with submit button for log in");
    }
    public void registerWithExistingEmail(RegisterFormObject input){
        elementMethods.sendValue(inputNameElement, input.getNameValue());
        LoggerUtility.info("The user fill name input for register");
        elementMethods.sendValue(signUpEmailElement, input.getEmailAdressValue());
        LoggerUtility.info("User fill email input for register");
        elementMethods.clickElement(buttonSubmitSignUpElement);
        LoggerUtility.info("User submit the form for sign up");
    }
    public void clearInput(){
        elementMethods.clearInput(logInEmailElement);
        elementMethods.clearInput(passwordLoginInputElement);
    }
}
