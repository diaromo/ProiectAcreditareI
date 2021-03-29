package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.*;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckOutConfirmationPage checkOutConfirmationPage;

    //SmokeCheckOut
    @Step public void setBillingFirstNameField(String firstName){checkoutPage.setBillingFirstNameField(firstName);}
    @Step public void setBillingLastNameField(String lastName){checkoutPage.setBillingLastNameField(lastName);}
    @Step public void setBillingAddressField(String billingAddress){checkoutPage.setBillingAddressField(billingAddress);}
    @Step public void setBillingCityField(String city ){checkoutPage.setBillingCityField(city);}
    @Step public void setBillingPostCodeField(String postCode){checkoutPage.setBillingPostCodeField(postCode);}
    @Step public void setBillingPhoneField(String phoneNumber){checkoutPage.setBillingPhoneField(phoneNumber);}
    @Step public void clickPlaceOrder(){checkoutPage.clickPlaceOrder();}

}
