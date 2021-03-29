package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")

public class AccountPage extends PageObject {

    //AssertValidLogin
    @FindBy(css = "p:nth-child(1)")
    private WebElementFacade welcomeMessage;
    public void verifyWelcomeMessage(String userName){
        welcomeMessage.shouldContainText("Hello "+userName+" (not "+userName+"? Log out)"); }


    //ValidSearchProductFromAccount
    @FindBy(css = "#search-2 > form > input.search-field")
    private WebElementFacade searchField;
    @FindBy(css = "#search-2 > form > button > i")
    private WebElementFacade searchLink;

    public void setSearchField(){ typeInto(searchField, "Hoodie with Zipper"); }
    public void clickSearchIcon(){ clickOn(searchLink); }

    //ValidRegisterTest
    @FindBy(css = "#reg_email")
    private WebElementFacade registerEmailField;
    @FindBy(css = "#reg_password")
    private  WebElementFacade registerPasswordField;
    @FindBy(css = "p.woocommerce-FormRow.form-row ")
    private WebElementFacade registerIcon;

    public void setRegisterEmailField(){typeInto(registerEmailField,"romosandiana11@gmail.com");}
    public void setRegisterPasswordField(){typeInto(registerPasswordField, "proiectacreditare11^");}
    public void clickRegisterIcon(){clickOn(registerIcon);}

    //Go to Product Page
    @FindBy(css = "#menu-item-73 > a")
    private WebElementFacade shopLink;
    public void clickShopLink(){clickOn(shopLink);}

    //Go to Cart from Account Page
    @FindBy(css = "span[class='amount']")
    private WebElementFacade cartLink;
    public void clickCartLink(){clickOn(cartLink);}
}
