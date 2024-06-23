package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsFactory.CustomerPageObjectFactory;
import pageObjectsFactory.HomePageObjectFactory;
import pageObjectsFactory.LoginPageObjectFactory;
import pageObjectsFactory.RegisterPageObjectFactory;


public class Level_06_Selenium_Page_Factory extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObjectFactory homePage;
     private RegisterPageObjectFactory registerPage;
     private CustomerPageObjectFactory customerPage;
     private LoginPageObjectFactory loginPage;
     private String emailAddress = getEmailRandom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = new HomePageObjectFactory(driver);
    }

    @Test
    public void Register_01_Empty_Data() {
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObjectFactory(driver);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText(),"Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"First name is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
       registerPage.clickToNopCommerceLogo();
       homePage = new HomePageObjectFactory(driver);
       homePage.clickToRegisterLink();
       registerPage = new RegisterPageObjectFactory(driver);

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("compa@atony@1gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMessageText(),"Please enter a valid email address.");

    }

    @Test
    public void Register_03_Invalid_Password() {
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObjectFactory(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObjectFactory(driver);

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("compa@gmail.com");
        registerPage.enterToPsswordTextBox("123");
        registerPage.enterToconfirmPasswordTextBox("123");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObjectFactory(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObjectFactory(driver);

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("compa@gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("1234567");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"The password and confirmation password do not match.");
    }

//    @Test
//    public void Register_05_Success() {
//        registerPage.clickToNopCommerceLogo();
//        homePage = new HomePageObjectFactory(driver);
//
//        homePage.clickToRegisterLink();
//        registerPage = new RegisterPageObjectFactory(driver);
//
//        registerPage.enterToFirstNameTextBox("antony");
//        registerPage.enterToLastNameTextBox("Compa");
//        registerPage.enterToEmailTextBox("antonyCompa000000012@gmail.com");
//        registerPage.enterToPsswordTextBox("12345678");
//        registerPage.enterToconfirmPasswordTextBox("12345678");
//
//        registerPage.clickToRegisterButton();
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
//
//    }
//    @Test
//    public void Register_06_Success_Login() {
//        //Step 05 Đăng kí thành công -> Login user luôn nên Step 06 không cần login lại
//        registerPage.clickToNopCommerceLogo();
//        homePage = new HomePageObjectFactory(super.driver);
//        homePage.clickToMyAccountLink();
//        homePage = new HomePageObjectFactory(super.driver);
//        homePage.clickToMyAccountLink();
//        customerPage = new CustomerPageObjectFactory(driver);
//
//        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),"antony");
//
//        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),"antonyCompa000000012@gmail.com");
//
//        Assert.assertEquals(customerPage.getEmailAtrributeValue(),"antonyCompa000000012@gmail.com");
//
//
//    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
