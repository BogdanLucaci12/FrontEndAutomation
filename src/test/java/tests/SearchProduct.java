package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.ProductsPage;
import sharedData.SharedData;

public class SearchProduct extends SharedData {
    @Test
    public void metodaTest(){
        IndexPage indexPage=new IndexPage(getDriver());
        indexPage.closeConsentEngine();
        ProductsPage productsPage=new ProductsPage(getDriver());
        productsPage.interactWithProductsPage();
        productsPage.searchAProduct();
    }
}
