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


public class Product extends BaseTest {

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
    public void Product_01_New_Product() {
    }
    @Test
    public void Product_02_View_Product() {
    }
    @Test
    public void Product_03_Edit_Product() {
    }
//    @Test
//    public void Register_06_Success_Login() {
//        //Step 05 Đăng kí thành công -> Login user luôn nên Step 06 không cần login lại
//        homePage = registerPage.clickToNopCommerceLogo();
//
//        homePage.clickToMyAccountLink();
//        homePage = new HomePageObject(driver);
//
//        customerPage = homePage.clickToMyAccountLink();
////        customerPage = new CustomerPageObject(driver);
//
//        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),"antony");
//
//        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),"antonyCompa000000012@gmail.com");
//
//        Assert.assertEquals(customerPage.getEmailAtrributeValue(),"antonyCompa000000012@gmail.com");
//
//
//    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
