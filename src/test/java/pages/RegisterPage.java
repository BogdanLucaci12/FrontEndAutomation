package pages;

import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import objectData.RegisterFormObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;


public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='radio-inline']/label/div/span/input")
    private List<WebElement> gendersElement;
    @FindBy (xpath = "//input[@id='password']")
    private WebElement passwordElement;
    @FindBy (id = "days")
    private WebElement dayElement;
    @FindBy (id = "years")
    private WebElement yearElement;
    @FindBy (id = "months")
    private WebElement monthElement;
    @FindBy (id= "newsletter")
    private WebElement checkNewslleterElement;
    @FindBy (id= "optin")
    private WebElement checkOfferElement;
    @FindBy(id = "first_name")
    private WebElement firstNameInputElement;
    @FindBy (id = "last_name")
    private WebElement lastNameInputElement;
    @FindBy (id = "company")
    private WebElement companyInputElement;
    @FindBy (id = "address1")
    private WebElement adress1InputElement;
    @FindBy (id = "address2")
    private WebElement adres2InputElement;
    @FindBy (id = "country")
    private WebElement countrySelectElement;
    @FindBy (id = "state")
    private WebElement stateInputElement;
    @FindBy (id = "city")
    private WebElement cityInputElement;
    @FindBy (id = "zipcode")
    private WebElement zipcodeInputElement;
    @FindBy (id = "mobile_number")
    private WebElement phoneInputElement;
    @FindBy (xpath = "//button[@data-qa='create-account']")
    private WebElement submitRegisterButtonElement;
    @FindBy (xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButtonElement;
    public void fillRegisterForm(RegisterFormObject input){
        switch (input.getGenderValue()){
            case "Mr.": elementMethods.clickElement(gendersElement.get(0));
            case "Mrs.":elementMethods.clickElement(gendersElement.get(1));
        }
        LoggerUtility.info("User chose gender");
        elementMethods.sendValue(passwordElement, input.getPasswordValue());
        LoggerUtility.info("User insert password");
        pageMethods.scrollPageDown(0, 350);
        elementMethods.selectByTextElement(dayElement, input.getDayValue());
        LoggerUtility.info("User select day");
        elementMethods.selectByTextElement(monthElement, input.getMonthValue());
        LoggerUtility.info("User select month");
        elementMethods.selectByValue(yearElement, input.getYearValue());
        LoggerUtility.info("User select year");
        elementMethods.clickElement(checkNewslleterElement);
        LoggerUtility.info("User check newsletter");
        elementMethods.clickElement(checkOfferElement);
        LoggerUtility.info("User check offer");
        pageMethods.scrollPageDown(0, 350);
        elementMethods.sendValue(firstNameInputElement, input.getFirstNameValue());
        LoggerUtility.info("User fill first name value");
        elementMethods.sendValue(lastNameInputElement, input.getLastNameValue());
        LoggerUtility.info("User fill last name input");
        elementMethods.sendValue(companyInputElement, input.getCompanyValue());
        LoggerUtility.info("User insert company name value");
        elementMethods.sendValue(adress1InputElement, input.getAdress1Value());
        LoggerUtility.info("User insert adress 1 input");
        elementMethods.sendValue(adres2InputElement, input.getAdress2Value());
        LoggerUtility.info("User insert adress 2 input");
        elementMethods.selectByTextElement(countrySelectElement, input.getCountryValue());
        LoggerUtility.info("User choose a country");
        elementMethods.sendValue(stateInputElement, input.getStateValue());
        LoggerUtility.info("User fill state input");
        elementMethods.sendValue(cityInputElement, input.getCityValue());
        LoggerUtility.info("User fill city input");
        pageMethods.scrollPageDown(0, 150);
        elementMethods.sendValue(zipcodeInputElement, input.getZipCodeValue());
        LoggerUtility.info("User fill zipcode");
        elementMethods.sendValue(phoneInputElement, input.getPhoneNumber());
        LoggerUtility.info("User insert phone number");
        elementMethods.clickElement(submitRegisterButtonElement);
        LoggerUtility.info("User submit the form");
        elementMethods.clickElement(continueButtonElement);
        LoggerUtility.info("User click on continue element");
  }
}

