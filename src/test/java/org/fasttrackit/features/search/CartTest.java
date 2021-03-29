package org.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.steps.serenity.CartSteps;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.fasttrackit.steps.serenity.RegisterSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {

    @Managed(uniqueSession = false)
    private WebDriver webDriver;

    @Steps private CartSteps cartSteps;
    @Steps private LoginSteps loginSteps;
    @Steps private RegisterSteps registerSteps;

    private CartPage cartPage;

    @Before
    public void setupDriver(){
        webDriver.manage().window().maximize();
    }

    @Test
    public void ValidAddProductToCartTest(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.AddProductToCart();
        cartSteps.verifyCheckoutButtonIsDisplayed();}

    @Test
    public void DeleteProductFromCart(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.AddProductToCart();
        cartSteps.deleteProductFromCart();
        cartSteps.verifyDeleteMessage("“Belt”");
        }

    @Test
    public void goToNextPageUsingPageNumberButton(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.goToNextPage1();
        cartSteps.verifyCurrentPage("2");
    }


    @Test
    public void goToNextPageUsingArrows(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.goToNextPage2();
        cartSteps.verifyCurrentPage("2");
    }

    @Test
    public void sortByLowToHighPrice(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.sortByLtoHPrice();
        cartPage.verifySortedByPrice();
    }

    @Test public void IncreaseProductQuantityInCart(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        cartSteps.clickShopButton();
        cartSteps.clickAddToCart();
        cartSteps.clickViewCart();
        cartSteps.increaseQuantity();
        cartPage.verifyCartUpdated("Cart updated.");
    }

    @Test public void accessCartFromAccountPage(){
         loginSteps.login("romosandiana@gmail.com","proiectacreditare");
         cartSteps.clickShopButton();
         cartSteps.clickAddToCart();
         cartSteps.clickViewCart();
         registerSteps.clickAccountLink();
         registerSteps.clickCartLink();
         cartSteps.verifyCheckoutButtonIsDisplayed();
    }

}
