package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.*;


public class Level_15_Assert_Verify extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;



    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Test
    public void Register_01_Success() {
// Verify my account link undisplay
        verifyFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getFirstNameErrorMessageText(),"Last name is required.");
        verifyEquals(registerPage.getLastNameErrorMessageText(),"Last name is required");

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("antonyCompa00000008@gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();
        verifyEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



}
