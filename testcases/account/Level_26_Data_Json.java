package account;


import JSON_Data.nopcommer.DataJson;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;

import java.io.IOException;
import java.util.Set;


public class Level_26_Data_Json extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     public static Set<Cookie> cookie ;
     private DataJson dataJson ;
    public static String password,firstName,lastName,email;




    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) throws IOException {
        driver= getBrowerDriverLocal(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        dataJson = DataJson.getData();
        firstName = dataJson.getFirstname();
        lastName = dataJson.getLastname();
        email = dataJson.getEmail() + getEmailRandom();
        dataJson.setEmail(email);
        password = dataJson.getPassword();


        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToRegisterForm(dataJson);

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
