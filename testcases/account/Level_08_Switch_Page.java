package account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.*;


public class Level_08_Switch_Page extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     private CustomerPageObject customerPage;
     private LoginPageObjectUser loginPage;
     private AddressPageObjects addressPage;
     private OrderPageObjects oderPage;
     private final String emailAddress = getEmailRandom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriverLocal(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Test
    public void Register_01_Success() {

        registerPage = homePage.clickToRegisterLink();
//        homePage = registerPage.clickToNopCommerceLogo();

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("antonyCompa000000014@gmail.com");
        registerPage.enterToPsswordTextBox("12345678");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }
    @Test
    public void Register_02_Success_Login() {
        //Step 05 Đăng kí thành công -> Login user luôn nên Step 06 không cần login lại
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToMyAccountLink();
        homePage = new HomePageObject(driver);

        customerPage = homePage.clickToMyAccountLink();
//        customerPage = new CustomerPageObject(driver);

        Assert.assertEquals(customerPage.getFirtNameAtrributeValue(),"antony");

        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),"antonyCompa000000014@gmail.com");

        Assert.assertEquals(customerPage.getEmailAtrributeValue(),"antonyCompa000000014@gmail.com");
    }

    @Test
    public void User_03_Switch_Page() {
//        //CustomerPage -> AddressPage
//        addressPage = customerPage.openAddressPage(driver);
//        //CustomerPage -> OrderPage
//        oderPage = customerPage.openOderPage(driver);
//        //AddressPage -> OrderPage
//        oderPage = addressPage.openOrderPage(driver);
//        //OderPage -> CustomerPage
//        customerPage = oderPage.openCustomerPage(driver);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }



}
