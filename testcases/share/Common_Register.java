package share;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjectsUser.CustomerPageObject;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.LoginPageObjectUser;
import pageObjectsUser.RegisterPageObject;

import java.util.Set;


public class Common_Register extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     private final String emailAddress = getEmailRandom();
     public static String password,firstName,lastName,email;
     public static Set<Cookie> cookie ;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        password = "12345678";
        firstName = "Donald";
        lastName = "Trump";
        email =emailAddress;


        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
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
