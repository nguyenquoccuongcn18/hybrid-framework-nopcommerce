package account;


import commons.BaseTest;
import commons.PageGeneratorManager;
import commons.UserObjects;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;

import java.util.Set;


public class Level_24_Data_in_international extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     public static Set<Cookie> cookie ;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver= getBrowerDriverLocal(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);


        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextBox(UserObjects.getFirstName);
        registerPage.enterToLastNameTextBox(UserObjects.getLastName);
        registerPage.enterToEmailTextBox(UserObjects.email);
        registerPage.enterToPsswordTextBox(UserObjects.password);
        registerPage.enterToconfirmPasswordTextBox(UserObjects.password);

        registerPage.clickToRegisterButton();
        registerPage.refreshCurrentPage(driver);
        sleepInsecons(5);
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
        cookie = registerPage.getBrowserCookies(driver);

        System.out.println("Log Email Common_Register : " + UserObjects.email);
        System.out.println("Log Password Common_Register: " + UserObjects.password);
       closeBrowser();
    }

}
