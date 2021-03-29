package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends PageObject{

    //CheckoutTest
    @FindBy(id = "billing_first_name")
    private WebElementFacade billingFirstNameField;
    @FindBy(id = "billing_last_name")
    private WebElementFacade billingLastNameField;
    @FindBy(id = "billing_address_1")
    private WebElementFacade billingAddressField;
    @FindBy(id = "billing_city")
    private WebElementFacade billingCityField;
    @FindBy(id ="billing_postcode")
    private WebElementFacade billingPostCodeField;
    @FindBy(id = "billing_phone")
    private WebElementFacade billingPhoneField;
    @FindBy(id = "place_order")
    private WebElementFacade placeOrderField;

    public void setBillingFirstNameField(String firstName){typeInto(billingFirstNameField,firstName);}
    public void setBillingLastNameField(String lastName){typeInto(billingLastNameField,lastName);}
    public void setBillingAddressField(String billingAddress){typeInto(billingAddressField,billingAddress);}
    public void setBillingCityField(String city ){typeInto(billingCityField,city);}
    public void setBillingPostCodeField(String postCode){typeInto(billingPostCodeField,postCode);}
    public void setBillingPhoneField(String phoneNumber){typeInto(billingPhoneField,phoneNumber);}
    public void clickPlaceOrder(){clickOn(placeOrderField);}

    //Assert IncompleteBillingInfoTest

    @FindBy(css = "ul[role='alert']")
    private WebElementFacade incompleteBillingInfoMsg;
    public void verifyIncompleteBillingInfoMsg(String billingMessage){
        incompleteBillingInfoMsg.shouldContainText(billingMessage);}

    //Assert invalidCharactersInPhoneNumberFieldTest

    @FindBy(css = "ul[role='alert']")
    private WebElementFacade invalidCharactersMsg;
    public void verifyInvalidCharactersMsg(String invalidChMsg){
        invalidCharactersMsg.shouldContainText(invalidChMsg);
    }
}
