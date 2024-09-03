package tests;

import objectData.RegisterFormObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IndexPage;
import sharedData.SharedData;

public class SubscriptionTest extends SharedData {

    @Test
    public void metodaTest(){
        RegisterFormObject registerFormObject=new RegisterFormObject("src/test/resources/testData/RegisterFormData.json");
        IndexPage indexPage=new IndexPage(getDriver());
        indexPage.closeConsentEngine();
        HomePage homePage=new HomePage(getDriver());
        homePage.submitSubscription(registerFormObject);
    }
}
