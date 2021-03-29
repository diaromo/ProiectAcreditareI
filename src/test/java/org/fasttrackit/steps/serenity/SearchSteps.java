package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AccountPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.ProductSearchPage;
import org.junit.Assert;

public class SearchSteps {

    private HomePage homepage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ProductSearchPage productSearchPage;

    @Step public void setSearchField(String searchWord){accountPage.setSearchField();}
    @Step public void clickSearchButton(){accountPage.clickSearchIcon();}
    @Step public void searchProduct(String searchWord){
        setSearchField(searchWord);
        clickSearchButton();}

    }
