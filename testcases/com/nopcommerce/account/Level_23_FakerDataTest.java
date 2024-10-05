package com.nopcommerce.account;


import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;
import utilities.FakerConfig;

import java.util.Set;


public class Level_23_FakerDataTest extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private FakerConfig fakerConfig ;
     private RegisterPageObject registerPage;
     private final String emailAddress = getEmailRandom();
     public static String password,firstName,lastName,email;
     public static Set<Cookie> cookie ;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        fakerConfig = FakerConfig.getFaker();
        password = fakerConfig.getPassword();
        email = fakerConfig.getRandomEmail();

        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextBox(fakerConfig.getFirtname());
        registerPage.enterToLastNameTextBox(fakerConfig.getLastName());
        registerPage.enterToEmailTextBox(email);
        registerPage.enterToPsswordTextBox(password);
        registerPage.enterToconfirmPasswordTextBox(password);

        registerPage.clickToRegisterButton();
        registerPage.refreshCurrentPage(driver);
        sleepInsecons(5);
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
        cookie = registerPage.getBrowserCookies(driver);

        System.out.println("Log Email Common_Register : " + email);
        System.out.println("Log Password Common_Register: " + password);
       closeBrowser();
    }

}
