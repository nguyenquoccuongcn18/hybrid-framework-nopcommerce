package cookie;

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

import static share.Common_Register.email;
import static share.Common_Register.password;


public class Payment extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
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

        homePage.setCookie(driver, Common_Register.cookie);
        sleepInsecons(5);
        homePage.refreshCurrentPage(driver);

        homePage = new HomePageObject(driver);

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameAtrributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAtrributeValue(), email);
    }



    @Test
    public void Payment_01_Visa() {
    }
    @Test
    public void Payment_02_Napas() {
    }
    @Test
    public void Payment_03_Paypal() {
    }
//    @Test
//    public void Register_06_Success_Login() {
//        homePage = registerPage.clickToNopCommerceLogo();
//
//        homePage.clickToMyAccountLink();
//        homePage = new HomePageObject(driver);
//        customerPage = homePage.clickToMyAccountLink();
//
//        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),Common_Register.firstName);
//        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),Common_Register.lastName);
//        Assert.assertEquals(customerPage.getEmailAtrributeValue(),Common_Register.email);
//
//    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
