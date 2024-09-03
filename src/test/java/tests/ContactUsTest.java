package tests;

import objectData.ContactUsObject;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.IndexPage;
import sharedData.SharedData;

public class ContactUsTest extends SharedData {
    @Test
    public void metodaTest(){
        ContactUsObject contactUsObject=new ContactUsObject("src/test/resources/testData/ContactUsFormData.json");
        IndexPage indexPage=new IndexPage(getDriver());
        indexPage.closeConsentEngine();
        ContactUsPage contactUsPage=new ContactUsPage(getDriver());
        contactUsPage.fillFormForContactUs(contactUsObject);
        contactUsPage.submitForm();
    }
}
