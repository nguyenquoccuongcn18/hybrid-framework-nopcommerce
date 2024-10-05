package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;


public class Level_18_Extent_Report extends BaseTest {

    private WebDriver driver;
     WebDriverWait explicitWait;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
    private String browerName ;



    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browerName = browserName;
        driver= getBrowerDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Test
    public void Register_01_Validate (Method method) {
        ExtentTestManager.startTest(method.getName()," - Run on - "  + browerName.toUpperCase() + " - Register_01");
        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required.");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        verifyEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");



    }
    @Test
    public void Register_02_Success(Method method) {
        ExtentTestManager.startTest(method.getName(),"Register_01");
        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.refreshCurrentPage(driver);
        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.enterToFirstNameTextBox("antony");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.enterToLastNameTextBox("Compa");


        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.enterToEmailTextBox("antonyCompa00000008@gmail.com");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.enterToPsswordTextBox("12345678");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.enterToconfirmPasswordTextBox("12345678");

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register_01 - Step 01 : Navigate to Register page");
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed.");


    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



}
