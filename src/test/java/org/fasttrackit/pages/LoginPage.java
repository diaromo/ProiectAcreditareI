package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class LoginPage extends PageObject {

    //Login
    @FindBy(id = "username")
    private WebElementFacade usernameField;
    @FindBy(id = "password")
    private WebElementFacade loginPasswordField;
    @FindBy(name = "login")
    private WebElementFacade loginButton;

    public void setUsernameField(String username){
        typeInto(usernameField, username);
    }
    public void setLoginPasswordField(String password){
        typeInto(loginPasswordField,password);
    }
    public void clickLoginButton(){
        clickOn(loginButton);
    }

    //AssertInvalidEmailLogin
    @FindBy(css = "div[id='primary'] li:nth-child(1)")
    private WebElementFacade invalidUserMsg;
    public void verifyInvalidUserMsg(String invalidMail) {
        invalidUserMsg.shouldContainText(invalidMail);
    }

    //AssertInvalidPassword
    @FindBy(css = "strong:nth-child(1)")
    private WebElementFacade incorrectPassword;
    public void verifyIncorrectPassMsg(String incorrectPsw){
        incorrectPassword.shouldContainText(incorrectPsw);
    }



}
