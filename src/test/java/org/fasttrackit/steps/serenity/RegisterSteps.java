package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.RegisterPage;
import org.jruby.runtime.callsite.ShiftRightCallSite;

public class RegisterSteps {

    private HomePage homepage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private RegisterPage registerPage;


    @Step
    public void navigateToLogin(){
        homepage.open();
        homepage.clickLoginLink();}
    @Step public void clickAccountLink(){
        homepage.clickAccountLink();
    }
    @Step public void setRegisterEmail(){
        accountPage.setRegisterEmailField();
    }
    @Step public void setRegisterPassword(){
        accountPage.setRegisterPasswordField();
    }
    @Step public void clickRegisterButton(){
        accountPage.clickRegisterIcon();
    }
    @Step public void userRegister(){
        navigateToLogin();
        clickAccountLink();
        setRegisterEmail();
        setRegisterPassword();
        clickRegisterButton();
    }
    @Step public void clickCartLink(){accountPage.clickCartLink();}

}
