package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?product=hoodie-with-zipper")
public class ProductSearchPage extends PageObject {

    //Assert product Hoodie with Zipper was found
    @FindBy(css = "span.sku_wrapper")
    private WebElementFacade productCode;

    public void verifyIfProdCodeIsDisplayed(String productSerial){
    productCode.shouldContainOnlyText("SKU: " + productSerial);
    }

}
