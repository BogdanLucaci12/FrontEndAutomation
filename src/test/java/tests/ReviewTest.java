package tests;

import objectData.ReviewObject;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.ProductsPage;
import sharedData.SharedData;

public class ReviewTest extends SharedData {

    @Test
    public void metodaTest(){
        ReviewObject reviewObject=new ReviewObject("src/test/resources/testData/ReviewData.json");
        IndexPage indexPage=new IndexPage(getDriver());
        indexPage.closeConsentEngine();
        ProductsPage productsPage=new ProductsPage(getDriver());
        productsPage.interactWithProductsPage();
        productsPage.viewDetailsAboutAProduct();
        productsPage.reviewAProduct(reviewObject);
    }
}
