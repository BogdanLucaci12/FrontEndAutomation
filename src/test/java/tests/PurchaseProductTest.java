package tests;

import objectData.CardObject;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

public class PurchaseProductTest extends SharedData {
    @Test
    public void metodaTest(){
        CardObject cardObject=new CardObject("src/test/resources/testData/CardData.json");
        IndexPage indexPage=new IndexPage(getDriver());
        indexPage.closeConsentEngine();
        ProductsPage productsPage=new ProductsPage(getDriver());
        productsPage.interactWithProductsPage();
        productsPage.addProducts();
        productsPage.goToCart();
        ViewCartPage viewCartPage=new ViewCartPage(getDriver());
        viewCartPage.deleteAProductFromCart();
        viewCartPage.goToCheckout();
        CheckoutPage checkoutPage=new CheckoutPage(getDriver());
        checkoutPage.placeOrder();
        PaymentPage paymentPage=new PaymentPage(getDriver());
        paymentPage.payOrder(cardObject);
    }
}

