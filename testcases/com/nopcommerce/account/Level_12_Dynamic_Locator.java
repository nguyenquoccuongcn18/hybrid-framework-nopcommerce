package com.nopcommerce.account;

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


public class Level_12_Dynamic_Locator extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     private CustomerPageObject customerPage;
     private LoginPageObjectUser loginPage;
     private AddressPageObjects addressPage;
     private OrderPageObjects orderPage;
     private final String emailAddress = getEmailRandom();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Test
    public void Register_01_Success() {

        registerPage = homePage.clickToRegisterLink();
//        homePage = registerPage.clickToNopCommerceLogo();

        registerPage.enterToFirstNameTextBox("antony");
        registerPage.enterToLastNameTextBox("Compa");
        registerPage.enterToEmailTextBox("antonyCompa00000008@gmail.com");
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

        Assert.assertEquals(customerPage.getLastNameAtrributeValue(),"antonyCompa00000008@gmail.com");

        Assert.assertEquals(customerPage.getEmailAtrributeValue(),"antonyCompa00000008@gmail.com");
    }

//    @Test
//    public void User_03_Page_Navigation() throws Exception {
//        //CustomerPage -> AddressPage
//        addressPage = (AddressPageObjects) customerPage.openDynamicSideBarPage("Addresses");
//        //CustomerPage -> OrderPage
//        orderPage = (OrderPageObjects) customerPage.openDynamicSideBarPage("Orders");
//        //OderPage -> CustomerPage
//        customerPage = (CustomerPageObject) orderPage.openDynamicSideBarPage("Customer info");
//        //AddressPage -> OrderPage
//        orderPage = (OrderPageObjects) addressPage.openDynamicSideBarPage("Addresses");
//
//    }
    @Test
    public void User_04_Page_Navigation() throws Exception {
        //CustomerPage -> AddressPage
        customerPage.openDynamicSideBarPageName("Addresses");
        addressPage = PageGeneratorManager.getAddressPage(driver);
//        //CustomerPage -> OrderPage
//        orderPage = (OrderPageObjects) customerPage.openDynamicSideBarPage("Order");
//        //OderPage -> CustomerPage
//        customerPage = (CustomerPageObject) orderPage.openDynamicSideBarPage("Customer");
//        //AddressPage -> OrderPage
//        orderPage = (OrderPageObjects) addressPage.openDynamicSideBarPage("Address");

        addressPage.openDynamicSideBarPageName("Orders");
        orderPage = PageGeneratorManager.getOrderPage(driver);

    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



}
