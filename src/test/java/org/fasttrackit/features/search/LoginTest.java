package org.fasttrackit.features.search;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = false)
    private WebDriver webDriver;

    @Steps
    private LoginSteps loginSteps;
    private LoginPage loginPage;

    @Before
    public void setupDriver(){
        webDriver.manage().window().maximize();
    }

    @Test
    public void validCredentialsLoginTest(){
        loginSteps.login("romosandiana@gmail.com","proiectacreditare");
        loginSteps.verifyLoginMessage("romosandiana"); }

    @Test
    public void invalidEmailLoginTest() {
        loginSteps.login("romosandianagmail.com", "proiectacreditare");
        loginPage.verifyInvalidUserMsg("ERROR: Invalid username.");
    }
    @Test
    public void invalidPassword(){
        loginSteps.login("romosandiana@gmail.com", "proiectacreditar");
        loginPage.verifyIncorrectPassMsg("ERROR");
        }

}
