package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.ProductSearchPage;
import org.yecht.Data;

public class ProductSteps {

    private ProductSearchPage productSearchPage;

    //Assert product in cart
    @Step public void checkProductCode(String productCode){
        productSearchPage.verifyIfProdCodeIsDisplayed(productCode);
    }
}
