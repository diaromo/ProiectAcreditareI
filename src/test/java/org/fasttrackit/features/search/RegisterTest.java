package org.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.RegisterPage;
import org.fasttrackit.steps.serenity.RegisterSteps;
import org.fasttrackit.steps.serenity.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest {

    @Managed(uniqueSession = false)
    private WebDriver webDriver;

    @Steps
    private RegisterSteps registerSteps;

    private RegisterPage registerPage;

    @Before
    public void setupDriver(){
        webDriver.manage().window().maximize();
    }

    @Test
    public void validUserRegister(){
        registerSteps.userRegister();
        registerPage.verifyRegisterMessageIsDisplayed(); }

    @Test
    public void longTextRegistration(){

    }
}
