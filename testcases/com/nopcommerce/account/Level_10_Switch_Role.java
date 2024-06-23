package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsAdmin.AdminDashboardPageObjects;
import pageObjectsAdmin.AdminLoginPageObject;
import pageObjectsUser.*;


public class Level_10_Switch_Role extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private CustomerPageObject customerPage;
     private RegisterPageObject registerPage;
     private LoginPageObjectUser loginPageObjectUser;
     private AdminLoginPageObject loginPageObjectAdmin;
    private AdminDashboardPageObjects adminDashboardPageObjects;
     private final String emailAddress = getEmailRandom();
     private String adminUrl , endUserUrl ;


    @Parameters({"browser","adminUrl","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
        driver= getBrowerDriverAdminEndUser(browserName,endUserUrl);
        this.adminUrl = adminUrl;
        this.endUserUrl = endUserUrl;
        homePage = PageGeneratorManager.getHomePage(driver);
    }


    @Test
    public void User_01_User_To_Admin() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("antonyCompa00000003@gmail.com");

        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");
        registerPage.clickToRegisterButton();

        homePage = registerPage.clickToNopCommerceLogo();
        homePage.clickToMyAccountLink();
        homePage = new HomePageObject(driver);

        //Homepage user -> login page admin
        homePage.openPageUrl(driver,this.adminUrl);

//        adminDashboardPageObjects = loginPageObjectAdmin.clickToLoginButton();
        loginPageObjectAdmin = PageGeneratorManager.getAdminLoginPage(driver);
        //Login Admin -> login page admin
        adminDashboardPageObjects = loginPageObjectAdmin.clickToLoginButtonAdmin("admin@yourstore.com", "admin@yourstore.com");


    }
    @Test
    public void Register_02_Success_Login() {

    }

    @Test
    public void User_03_Page_Navigation() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
