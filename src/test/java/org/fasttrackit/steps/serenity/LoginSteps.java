package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.junit.Assert;
import org.yecht.Data;

public class LoginSteps {


    private HomePage homepage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    //AssertLogin
    @Step public void verifyLoginMessage(String userName){
        accountPage.verifyWelcomeMessage(userName);}

    //Login
    @Step public void navigateToLogin(){
        homepage.open();
        homepage.clickLoginLink(); }

    @Step public void setUserName(String username){
        loginPage.setUsernameField(username);
    }
    @Step public void setPassword(String password){
        loginPage.setLoginPasswordField(password);
    }
    @Step public void clickLoginButton(){
        loginPage.clickLoginButton();
    }
    @Step public void login(String username, String password){
       navigateToLogin();
       setUserName(username);
       setPassword(password);
       clickLoginButton();
    }
}
