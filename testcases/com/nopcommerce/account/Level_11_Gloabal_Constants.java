package com.nopcommerce.account;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsAdmin.AdminDashboardPageObjects;
import pageObjectsAdmin.AdminLoginPageObject;
import pageObjectsUser.CustomerPageObject;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.LoginPageObjectUser;
import pageObjectsUser.RegisterPageObject;


public class Level_11_Gloabal_Constants extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private CustomerPageObject customerPage;
     private RegisterPageObject registerPage;
     private LoginPageObjectUser loginPageObjectUser;
     private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObjects adminDashboardPage;
     private final String emailAddress = getEmailRandom();
     private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
    private String endUserUrl = GlobalConstants.DEV_USER_URL;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriverAdminEndUser(browserName,endUserUrl);
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
        //logout
        homePage.clickToLogoutLink();

        //Homepage user -> login page admin
        homePage.openPageUrl(driver,adminUrl);

        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        //Login Admin -> login page admin
        adminDashboardPage = adminLoginPage.clickToLoginButtonAdmin(GlobalConstants.DEV_ADMIN_USERNAME,GlobalConstants.DEV_ADMIN_PASSWORD);
//        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
        sleepInsecons(10);

    }
    @Test
    public void User_02_Admin_To_User() {
        adminLoginPage = adminDashboardPage.clickToLogOutLinkAdmin();

        //Loout Admin -> Login homepage User
        adminLoginPage.openPageUrl(driver,endUserUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

        loginPageObjectUser = homePage.clickToLogInLink();
        loginPageObjectUser.loginToUser(driver);




    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
