package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectsUser.CustomerPageObject;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.LoginPageObjectUser;
import pageObjectsUser.RegisterPageObject;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Level_03_PageObject extends BasePage {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     private CustomerPageObject customerPage;
     private LoginPageObjectUser loginPage;
     private String emailAddress = getEmailRandom();

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        openPageUrl(driver,"https://demo.nopcommerce.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        //1. Mở 1 Url của Page nào đó ra thì phải khởi tạo lên
        //2. Từ 1 Page này chuyển sang Page kia thì khởi tạo lên
        homePage = new HomePageObject(driver);
    }

    @Test
    public void Register_01_Empty_Data() {
        homePage.clickToRegisterLink();

        //Từ HomePage click Register nó sẽ mở ra trang Register Page
        registerPage = new RegisterPageObject(driver);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
        Assert.assertEquals(registerPage.getEmailMessageText(),"Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"First name is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
       registerPage.clickToNopCommerceLogo();
       homePage = new HomePageObject(driver);

       homePage.clickToRegisterLink();
       registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("compa@atony@1gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailMessageText(),"Please enter a valid email address.");

    }

    @Test
    public void Register_03_Invalid_Password() {
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

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
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("compa@gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("1234567");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),"The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("antonyCompa000000012@gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @Test
    public void Register_06_Success_Login() {
        //Step 05 Đăng kí thành công -> Login user luôn nên Step 06 không cần login lại
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);
        homePage.clickToMyAccountLink();
//      customerPage = new CustomerPageObject(driver);

//        loginPage = new LoginPageObject(driver);
//
//        loginPage.enterToEmailTextBox("antonyCompa000000010@gmail.com");
//        loginPage.enterToPasswordTextBox("12345678");
//        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);
        homePage.clickToMyAccountLink();
        customerPage = new CustomerPageObject(driver);

        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),"antony");

        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),"antonyCompa000000012@gmail.com");

        Assert.assertEquals(customerPage.getEmailAtrributeValue(),"antonyCompa000000012@gmail.com");


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInsecons(long timeInsecons) {
        try {
            Thread.sleep(timeInsecons * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailRandom(){
        Random rand = new Random();
        return "John Smith" + rand.nextInt(100) + "@gmail.com";
    }
}
