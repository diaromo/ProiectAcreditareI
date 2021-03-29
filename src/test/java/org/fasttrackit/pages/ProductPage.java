package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

public class ProductPage extends PageObject {

    //Add product to Cart and View Cart
    @FindBy(css = "a[aria-label='Add “Belt” to your cart']")
    private WebElementFacade addBeltToCartLink;
    @FindBy(css = "a[title='View cart']")
    private WebElementFacade viewCartLink;

    public void addToCart(){clickOn(addBeltToCartLink);}
    public void viewCart(){clickOn(viewCartLink);}


}
