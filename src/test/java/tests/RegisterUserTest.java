package tests;


import objectData.RegisterFormObject;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.RegisterPage;
import pages.SignupLoginPage;
import sharedData.SharedData;

public class RegisterUserTest extends SharedData{
    @Test
    public void metodaTest(){
        RegisterFormObject registerFormObject=new RegisterFormObject("src/test/resources/testData/RegisterFormData.json");
        IndexPage indexPage=new IndexPage(getDriver());
        indexPage.closeConsentEngine();
        SignupLoginPage signupLoginPage=new SignupLoginPage(getDriver());
        signupLoginPage.interactWithSignUpPage();
        signupLoginPage.fillCredentialsForSignUp(registerFormObject);
        RegisterPage registerPage=new RegisterPage(getDriver());
        registerPage.fillRegisterForm(registerFormObject);
        signupLoginPage.logOutUser();
        signupLoginPage.logInUserWithIncorectEmailAndPassword(registerFormObject);
        signupLoginPage.clearInput();
        signupLoginPage.logInUserWithCorrectEmailAndPassword(registerFormObject);
        signupLoginPage.logOutUser();
        signupLoginPage.registerWithExistingEmail(registerFormObject);
        signupLoginPage.logInUserWithCorrectEmailAndPassword(registerFormObject);
        signupLoginPage.deleteUserAccount();
    }
}
