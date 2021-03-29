package org.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.ProductSearchPage;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.fasttrackit.steps.serenity.ProductSteps;
import org.fasttrackit.steps.serenity.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = false)
    private WebDriver webDriver;

    @Steps
    private SearchSteps searchSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private ProductSteps productSteps;

    @Before
    public void setupDriver(){
        webDriver.manage().window().maximize();
    }

    @Test
    public void validProductSearch(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        searchSteps.setSearchField("Hoodie with Zipper");
        searchSteps.clickSearchButton();
        productSteps.checkProductCode("woo-hoodie-with-zipper");  }
}
