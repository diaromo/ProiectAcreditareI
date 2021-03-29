package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    //ForLoginTest
    @FindBy(css="a.account")
    private WebElementFacade loginLink;
    public void clickLoginLink(){
        clickOn(loginLink);
    }

    //ForRegisterTest
    @FindBy(css="li[id='menu-item-70'] a")
    private WebElementFacade accountLink;
    public void clickAccountLink(){clickOn(accountLink);}
}
