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
import pageObjectsUser.CustomerPageObject;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.LoginPageObjectUser;
import pageObjectsUser.RegisterPageObject;


public class Level_22_Close_Browser extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     private CustomerPageObject customerPage;
     private LoginPageObjectUser loginPage;
     private final String emailAddress = getEmailRandom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        registerPage = homePage.clickToRegisterLink();
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required....");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"),"First name is required.");

    }

    @Test
    public void Register_01_Empty_Data() {
        registerPage = homePage.clickToRegisterLink();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

//        registerPage.clickToRegisterButton();
        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");
//        Assert.assertEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
//        Assert.assertEquals(registerPage.getEmailErrorMessageTextEmpty(),"Email is required.");
//        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"First name is required.");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"),"First name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"),"Last name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"),"Email is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"),"Password is required.");




    }

    @Test
    public void Register_02_Invalid_Email() {
        homePage = registerPage.clickToNopCommerceLogo();

//        registerPage = homePage.clickToRegisterLink();
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

//        registerPage.enterToFirstNameTextBox("antony");
//        registerPage.enterToLastNameTextBox("Compa");
//        registerPage.enterToEmailTextBox("compa@atony@1gmail.com");
//        registerPage.enterToPsswordTextBox("12345678");
//        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.enterToTextBoxByID("FirstName","antony");
        registerPage.enterToTextBoxByID("LastName","Compa");
        registerPage.enterToTextBoxByID("Email","compa@atony@1gmail.com");
        registerPage.enterToTextBoxByID("Password","12345678");
        registerPage.enterToTextBoxByID("ConfirmPassword","12345678");



//        registerPage.clickToRegisterButton();
        registerPage.clickToButtonByText("Register");

//        Assert.assertEquals(registerPage.getEmailErrorMessageText1(),"Please enter a valid email address.");

    }

    @Test
    public void Register_03_Invalid_Password() {
        homePage = registerPage.clickToNopCommerceLogo();

//        registerPage = homePage.clickToRegisterLink();
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

//        registerPage.enterToFirstNameTextBox("antony");
//        registerPage.enterToLastNameTextBox("Compa");
//        registerPage.enterToEmailTextBox("compa@gmail.com");
//        registerPage.enterToPsswordTextBox("123");
//        registerPage.enterToconfirmPasswordTextBox("123");

        registerPage.enterToTextBoxByID("FirstName","antony");
        registerPage.enterToTextBoxByID("LastName","Compa");
        registerPage.enterToTextBoxByID("Email","compa@gmail.com");
        registerPage.enterToTextBoxByID("Password","123");
        registerPage.enterToTextBoxByID("ConfirmPassword","123");


//        registerPage.clickToRegisterButton();
        registerPage.clickToButtonByText("Register");


        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        homePage=registerPage.clickToNopCommerceLogo();

//        registerPage = homePage.clickToRegisterLink();
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

//        registerPage.enterToFirstNameTextBox("antony");
//        registerPage.enterToLastNameTextBox("Compa");
//        registerPage.enterToEmailTextBox("compa@gmail.com");
//        registerPage.enterToPsswordTextBox("12345678");
//        registerPage.enterToconfirmPasswordTextBox("1234567");


        registerPage.enterToTextBoxByID("FirstName","antony");
        registerPage.enterToTextBoxByID("LastName","Compa");
        registerPage.enterToTextBoxByID("Email","compa@gmail.com");
        registerPage.enterToTextBoxByID("Password","12345678");
        registerPage.enterToTextBoxByID("ConfirmPassword","1234567");

//        registerPage.clickToRegisterButton();
        registerPage.clickToButtonByText("Register");


        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

//        registerPage = homePage.clickToRegisterLink();
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

//        registerPage.enterToFirstNameTextBox("antony");
//        registerPage.enterToLastNameTextBox("Compa");
//        registerPage.enterToEmailTextBox("antonyCompa000000012@gmail.com");
//        registerPage.enterToPsswordTextBox("12345678");
//        registerPage.enterToconfirmPasswordTextBox("12345678");


        registerPage.enterToTextBoxByID("FirstName","antony");
        registerPage.enterToTextBoxByID("LastName","Compa");
        registerPage.enterToTextBoxByID("Email","antonyCompa000000012@gmail.com");
        registerPage.enterToTextBoxByID("Password","12345678");
        registerPage.enterToTextBoxByID("ConfirmPassword","12345678");

//        registerPage.clickToRegisterButton();
        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @Test
    public void Register_06_Success_Login() {
        //Step 05 Đăng kí thành công -> Login user luôn nên Step 06 không cần login lại
        homePage = registerPage.clickToNopCommerceLogo();

//        homePage.clickToMyAccountLink();
        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        homePage = new HomePageObject(driver);

        customerPage = homePage.clickToMyAccountLink();
        homePage.clickToHeaderLinkByName("My account");

        customerPage = PageGeneratorManager.getCustomerPage(driver);
//        customerPage = new CustomerPageObject(driver);

        Assert.assertEquals(customerPage.getTextboxAtrributeByID("FirstName"),"antony");
        Assert.assertEquals(customerPage.getTextboxAtrributeByID("LastName"),"antonyCompa000000012@gmail.com");
        Assert.assertEquals(customerPage.getTextboxAtrributeByID("Email"),"antonyCompa000000012@gmail.com");



    }
    @AfterClass
    public void afterClass() {

        closeBrowser();
    }



}
