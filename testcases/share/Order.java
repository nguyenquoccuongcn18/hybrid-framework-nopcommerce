package share;

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
import pageObjectsUser.RegisterPageObject;

import static share.Common_Register.email;
import static share.Common_Register.password;


public class Order extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
    private CustomerPageObject customerPage;

    private RegisterPageObject registerPage;

     private final String emailAddress = getEmailRandom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriverLocal(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);


        homePage.clickToLoginLink();

        homePage.enterToTextBoxByID("Email",email);
        homePage.enterToTextBoxByID("Password", password);

        homePage.clickToLogInButton();
        homePage = new HomePageObject(driver);

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAtrributeValue(), email);
    }



    @Test
    public void Order_01() {
    }
    @Test
    public void Order_02() {
    }
    @Test
    public void Order_03() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
