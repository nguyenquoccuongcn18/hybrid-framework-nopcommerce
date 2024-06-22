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
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;


public class Level_08_Switch_Page extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     private CustomerPageObject customerPage;
     private LoginPageObject  loginPage;
     private final String emailAddress = getEmailRandom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Test
    public void Register_01_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("antonyCompa000000012@gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @Test
    public void Register_02_Success_Login() {
        //Step 05 Đăng kí thành công -> Login user luôn nên Step 06 không cần login lại
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToMyAccountLink();
        homePage = new HomePageObject(driver);

        customerPage = homePage.clickToMyAccountLink();
//        customerPage = new CustomerPageObject(driver);

        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),"antony");

        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),"antonyCompa000000012@gmail.com");

        Assert.assertEquals(customerPage.getEmailAtrributeValue(),"antonyCompa000000012@gmail.com");


    }
    @Test
    public void User_03_Switch_Page() {}
    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
