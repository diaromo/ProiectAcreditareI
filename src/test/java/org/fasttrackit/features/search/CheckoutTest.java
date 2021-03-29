package org.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.CheckOutConfirmationPage;
import org.fasttrackit.pages.CheckoutPage;
import org.fasttrackit.steps.serenity.CartSteps;
import org.fasttrackit.steps.serenity.CheckoutSteps;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class CheckoutTest {

    @Managed(uniqueSession = false)
    private WebDriver webDriver;

    @Steps private LoginSteps loginSteps;
    @Steps private CartSteps cartSteps;
    @Steps private CheckoutSteps checkoutSteps;

    private CheckOutConfirmationPage checkOutConfirmationPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setupDriver(){
        webDriver.manage().window().maximize();
    }

    @Test public void validCheckoutTest(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.AddProductToCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.setBillingFirstNameField("Diana");
        checkoutSteps.setBillingLastNameField("Romosan");
        checkoutSteps.setBillingAddressField("Marinescu");
        checkoutSteps.setBillingCityField("Cluj");
        checkoutSteps.setBillingPostCodeField("400516");
        checkoutSteps.setBillingPhoneField("0748578954");
        checkoutSteps.clickPlaceOrder();
        checkOutConfirmationPage.verifyCheckoutMessage("Thank you. Your order has been received.");

        }

        @Test public void incompleteBillingDetails(){
            loginSteps.login("romosandiana@gmail.com","proiectacreditare");
            cartSteps.clickShopButton();
            cartSteps.AddProductToCart();
            cartSteps.proceedToCheckout();
            checkoutSteps.setBillingFirstNameField("");
            checkoutSteps.setBillingLastNameField("Romosan");
            checkoutSteps.setBillingAddressField("Marinescu");
            checkoutSteps.setBillingCityField("Cluj");
            checkoutSteps.setBillingPostCodeField("400516");
            checkoutSteps.setBillingPhoneField("0748578954");
            checkoutSteps.clickPlaceOrder();
            checkoutPage.verifyIncompleteBillingInfoMsg("Billing First name is a required field.");
        }

    @Test public void invalidCharactersInPhoneField(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.AddProductToCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.setBillingFirstNameField("Diana");
        checkoutSteps.setBillingLastNameField("Romosan");
        checkoutSteps.setBillingAddressField("Marinescu");
        checkoutSteps.setBillingCityField("Cluj");
        checkoutSteps.setBillingPostCodeField("400516");
        checkoutSteps.setBillingPhoneField("cifre");
        checkoutSteps.clickPlaceOrder();
        checkoutPage.verifyInvalidCharactersMsg("Billing Phone is not a valid phone number.");
    }

}
