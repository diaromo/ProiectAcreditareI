package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.*;

public class CartSteps {

    private HomePage homepage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ProductPage productPage;
    private CartPage cartPage;

    //Add Belt to Cart
    @Step public void clickShopButton(){accountPage.clickShopLink();}
    @Step public void clickAddToCart(){productPage.addToCart();}
    @Step public void clickViewCart(){productPage.viewCart();}
    @Step public void verifyCheckoutButtonIsDisplayed(){cartPage.checkOutButtonIsDisplayed();}
    @Step public void AddProductToCart(){
        clickShopButton();
        clickAddToCart();
        clickViewCart(); }
    @Step public void proceedToCheckout(){cartPage.clickCheckOutButton();}

    //Delete product from Cart
    @Step public void deleteProductFromCart(){cartPage.clickDeleteButton();}

    //Assert delete product
    @Step public void verifyDeleteMessage(String productName){
        cartPage.verifyDeleteMessage(productName); }

    //GoToNextPage1
    @Step public void goToNextPage1(){cartPage.clickNextPage1();}
    @Step public void verifyCurrentPage(String currentPage){
        cartPage.verifyCurrentPage(currentPage);
    }

    //GoToNextPage2
    @Step public void goToNextPage2(){cartPage.clickNextPage2();}

    //SortByLtoHPrice
    @Step public void sortByLtoHPriceFilter(){cartPage.sortByPriceLtoHFilter();}
    @Step public void sortByLtoHPriceButton(){cartPage.sortByPriceLtoHButton();}
    @Step public void sortByLtoHPrice(){
        sortByLtoHPriceFilter();
        sortByLtoHPriceButton();
    }

    //IncreaseQTY
    @Step public void clearQuantityField(){cartPage.clearQuantityField();}
    @Step public void setQuantity(String number){cartPage.setQuantityField(number);}
    @Step public void clickUpdateCartButton(){cartPage.clickUpdateCartButton();}

    @Step public void increaseQuantity(){
        clearQuantityField();
        setQuantity("2");
        clickUpdateCartButton();
    }

}
