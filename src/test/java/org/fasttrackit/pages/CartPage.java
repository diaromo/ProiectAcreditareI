package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")

public class CartPage extends PageObject {
    //Assert ValidCardTest
    @FindBy(css = "a[class='checkout-button button alt wc-forward']")
    private WebElementFacade checkOutButton;
    public void checkOutButtonIsDisplayed(){checkOutButton.isDisplayed();}

    //Checkout
    @FindBy(css = "a[class='checkout-button button alt wc-forward']")
    private WebElementFacade proceedToCheckOut;
    public void clickCheckOutButton(){clickOn(proceedToCheckOut);}

    //Delete product from cart
    @FindBy(css = "a[aria-label='Remove this item']")
    private WebElementFacade deleteProductFromCartLink;

    public void clickDeleteButton(){clickOn(deleteProductFromCartLink);}

    //Assert delete product from cart
    @FindBy(css = "div[role='alert']")
    private WebElementFacade deleteMessage;

    public void verifyDeleteMessage(String productName){
        deleteMessage.shouldContainText(productName + " removed. Undo?");}


    //GoToNextPageUsingPageNumbers
    @FindBy(css = "a[class='page-numbers']")
    private WebElementFacade goToNextPage1;

    public void clickNextPage1(){clickOn(goToNextPage1);}

    //AssertCurrentPage
    @FindBy(css = "#title_bread_wrap > div > div > span")
    private WebElementFacade currentPage;

    public void verifyCurrentPage(String pageNumber){
        currentPage.shouldContainText("Page " + pageNumber);
    }

    //GoToNextPageUsingArrows
    @FindBy(css = "ul.page-numbers:nth-child(1) > li:nth-child(3) > a")
    private WebElementFacade goToNextPage2;

    public void clickNextPage2(){clickOn(goToNextPage2);}

    //Sort by Lowest to Highest Price
    @FindBy(css = "select[name='orderby']")
    private WebElementFacade filterButton;
    @FindBy(css="#primary > div > form > select > option:nth-child(4)")
    private WebElementFacade sortLtoHLink;

    public void sortByPriceLtoHFilter(){clickOn(filterButton);}
    public void sortByPriceLtoHButton(){clickOn(sortLtoHLink);}

    @FindBy(css = ".post-32 > div.collection_desc.clearfix > div > span > span.woocommerce-Price-amount.amount")
    private WebElementFacade lowerPriceItem;
    @FindBy(css = ".post-633 > div.collection_desc.clearfix > div > span > span.woocommerce-Price-amount.amount")
    private WebElementFacade higherPriceItem;

    public void verifySortedByPrice(){
        Assert.assertTrue("Checking that the prices are ascending", Double.parseDouble(lowerPriceItem.getText().substring(3)) < Double.parseDouble(higherPriceItem.getText().substring(3)));
    }

    //IncreaseQTY
    @FindBy(css = "#post-5 > div > div > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-quantity > div > input")
    private WebElementFacade QuantityField;
    @FindBy(css = "button[name='update_cart']")
    private WebElementFacade updateCartButton;

    public void clearQuantityField(){QuantityField.clear();}
    public void setQuantityField(String number){typeInto(QuantityField,number);}
    public void clickUpdateCartButton(){clickOn(updateCartButton);}

    @FindBy(css = "#post-5 > div > div > div > div > div.woocommerce-message")
    private WebElementFacade cartUpdateMessage;

    public void verifyCartUpdated(String msg){
        cartUpdateMessage.shouldContainText(msg);
    }

}
