package com.nopcommerce.account;


import pojoData.nopcommer.UserInfo;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;

import java.util.Set;


public class Level_25_Data_POJO extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     public static Set<Cookie> cookie ;
     private UserInfo userInfo ;



    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        userInfo = UserInfo.getUser();
        userInfo.setFirstName("John");
        userInfo.setLastName("Fildon");
        userInfo.setEmailAddress("Fildon@gmail.com");
        userInfo.setPassword("User123!");


        registerPage = homePage.clickToRegisterLink();
        registerPage.setToRegisterForm(userInfo);

        registerPage.clickToRegisterButton();
        registerPage.refreshCurrentPage(driver);
        sleepInsecons(5);
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
        cookie = registerPage.getBrowserCookies(driver);

        System.out.println("Log Email Common_Register : " + userInfo.getEmailAddress());
        System.out.println("Log Password Common_Register: " + userInfo.getPassword());
       closeBrowser();
    }

}
