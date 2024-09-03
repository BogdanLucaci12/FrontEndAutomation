package pages;

import loggerUtility.LoggerUtility;
import lombok.extern.java.Log;
import objectData.ReviewObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//a[@href='/products']")
    private WebElement productsButtonElement;
    @FindBy (xpath = "//a[@href='/product_details/1']")
    private WebElement viewProductButton;
    @FindBy (id = "name")
    private WebElement nameInputElement;
    @FindBy (id = "email")
    private WebElement emailInputElement;
    @FindBy (id = "review")
    private WebElement reviewInputElement;
    @FindBy(id = "button-review")
    private WebElement submitReviewElement;
    @FindBy(id = "search_product")
    private WebElement searchProductElement;
    @FindBy(id = "submit_search")
    private WebElement submitSearchElement;
    @FindBy (xpath = "//div[@class=\"single-products\"]/div/div/a[@data-product-id]")
    private List<WebElement> addToCardElements;
    @FindBy (xpath = "//div[@class='modal-footer']/button[@data-dismiss='modal']")
    private WebElement continueButtonElement;
    @FindBy(xpath = "//div[@class='single-products']")
    private List<WebElement> containerForProduct;
    @FindBy (xpath = "//a[@href='/view_cart']")
    private WebElement viewCartElement;

    public void interactWithProductsPage(){
        elementMethods.clickElement(productsButtonElement);
        LoggerUtility.info("User click on products page");
    }
    public void viewDetailsAboutAProduct(){
        pageMethods.scrollDown(viewProductButton);
    elementMethods.clickElement(viewProductButton);
    LoggerUtility.info("User interact with a product");
    }
    public void reviewAProduct(ReviewObject input){
        pageMethods.scrollPageDown(0, 250);
        elementMethods.sendValue(nameInputElement, input.getNameValue());
        LoggerUtility.info("User fill name input for review");
        elementMethods.sendValue(emailInputElement, input.getEmailValue());
        LoggerUtility.info("User fill email input for review");
        elementMethods.sendValue(reviewInputElement, input.getReviewValue());
        LoggerUtility.info("User fill review input");
        elementMethods.clickElement(submitReviewElement);
    }
    public void searchAProduct(){
        pageMethods.scrollPageDown(0, 250);
        elementMethods.sendValue(searchProductElement, "Tshirt");
        LoggerUtility.info("User search a product by Tshirt value");
        elementMethods.clickElement(submitSearchElement);
        LoggerUtility.info("User submit the search");
    }
    public void addProducts(){
        for (Integer i=0; i<addToCardElements.size();i++){
            if(i<=3){
                if(!addToCardElements.get(i).isDisplayed()){
                    pageMethods.scrollDown(addToCardElements.get(i));
                    LoggerUtility.info("User scroll cart in to view product");
                }
                    elementMethods.hoverAction(containerForProduct.get(i));
                    LoggerUtility.info("User hover on container " + i);
                    elementMethods.clickElement(addToCardElements.get(i));
                    LoggerUtility.info("User click on product " + i);
                    elementMethods.clickElement(continueButtonElement);
                    LoggerUtility.info("User click on continue button for more shopping");
            }
        }
    }
    public void goToCart(){
        elementMethods.clickElement(viewCartElement);
        LoggerUtility.info("User interact with view cart page");
    }

}
