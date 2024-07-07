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
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;


public class Level_17_ReportNG extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;



    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Test
    public void Register_01_Validate() {
//        log.info("User_01 - Step 01: Verify register link is displayed");
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

//        log.info("User_01 - Step 02: Click to register link");
        registerPage = homePage.clickToRegisterLink();

//        log.info("User_01 - Step 03: Enter valid data to register form");
        registerPage.clickToRegisterButton();

//        log.info("User_01 - Step 04: verify Last name is required.");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"Last name is required.");

//        log.info("User_01 - Step 05: verify Last name is required");
        verifyEquals(registerPage.getLastNameErrorMessageText(),"Last name is required");



    }
    @Test
    public void Register_02_Success() {

//        log.info("Register_02_Success - Step 01: Enter First Name");
        registerPage.refreshCurrentPage(driver);
        registerPage.enterToFirstNameTextBox("antony");

//        log.info("Register_02_Success - Step 02: Enter Last Name");
        registerPage.enterToLastNameTextBox("Compa");

//        log.info("Register_02_Success - Step 03: Enter Email");
        registerPage.enterToEmailTextBox("antonyCompa00000008@gmail.com");

//        log.info("Register_02_Success - Step 04: Enter Pssword");
        registerPage.enterToPsswordTextBox("12345678");

//        log.info("Register_02_Success - Step 05: Enter confirm Password");
        registerPage.enterToconfirmPasswordTextBox("12345678");

//        log.info("Register_02_Success - Step 06: Click to register button");
        registerPage.clickToRegisterButton();

//        log.info("Register_02_Success - Step 07: Verify success message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed.");


    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



}
