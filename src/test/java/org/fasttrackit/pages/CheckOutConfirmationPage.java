package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=6&order-received=679&key=wc_order_6054af0de2ecf")

public class CheckOutConfirmationPage extends PageObject {

    //Assert CheckOut
    @FindBy(css = "p[class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")
    private WebElementFacade checkoutMessage;

    public void verifyCheckoutMessage(String confirmationMessage){
        checkoutMessage.shouldContainText(confirmationMessage);}
}
