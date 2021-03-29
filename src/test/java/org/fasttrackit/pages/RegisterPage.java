package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")

public class RegisterPage extends PageObject {
    //Valid register Test
    @FindBy(css = "p:nth-child(1)")
    private WebElementFacade registerMessage;

    //Assert Valid Register
    public void verifyRegisterMessageIsDisplayed(){
        registerMessage.shouldContainText("Hello romosandiana11 (not romosandiana11? Log out)"); }
}
