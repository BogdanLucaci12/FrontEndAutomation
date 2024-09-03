package pages;

import loggerUtility.LoggerUtility;
import objectData.ContactUsObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//a[@href='/contact_us']")
    private WebElement contactUsButtonElement;
    @FindBy (xpath = "//input[@data-qa='name']")
    private WebElement inputNameElement;
    @FindBy (xpath = "//input[@data-qa='email']")
    private WebElement inputEmailElement;
    @FindBy (xpath = "//input[@data-qa='subject']")
    private WebElement inputSubjectElement;
    @FindBy (id = "message")
    private WebElement inputMessageElement;
    @FindBy (xpath = "//input[@name='upload_file']")
    private WebElement uploadFileElement;
    @FindBy (xpath = "//input[@data-qa='submit-button']")
    private WebElement submitElement;

    public void fillFormForContactUs(ContactUsObject input){
        elementMethods.clickElement(contactUsButtonElement);
        LoggerUtility.info("User interact with contact us button and redirect to that page");
        elementMethods.sendValue(inputNameElement, input.getNameValue());
        LoggerUtility.info("User fill name input");
        elementMethods.sendValue(inputEmailElement, input.getEmailValue());
        LoggerUtility.info("User fill email input");
        elementMethods.sendValue(inputSubjectElement, input.getSubjectValue());
        LoggerUtility.info("User fill the subject input");
        elementMethods.sendValue(inputMessageElement, input.getMessageValue());
        LoggerUtility.info("User fill message input");
        pageMethods.scrollPageDown(0, 200);
        LoggerUtility.info("User scroll down the page");
        elementMethods.sendFile(uploadFileElement, "src/test/resources/2024-04-27 (5).png");
        LoggerUtility.info("User upload a file");
    }
    public void submitForm(){
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("User submit the form for contact us");
        alertsMethods.acceptAlert();
        LoggerUtility.info("User accept alert");
    }
}
