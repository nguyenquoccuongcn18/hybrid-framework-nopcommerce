package account;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;
import retryConfig.RetryListener;



@Listeners(RetryListener.class)
public class Level_35_NotifyLine_Error extends BaseTest {

    private WebDriver driver;
     private LoginPageObjects loginPage;
    private ProductPageObjects productPage;


    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriverLocalV2(browserName,url);

        System.out.println("ThreadID = " + Thread.currentThread().getId() + "with BrowserID = " + browserName);
        System.out.println("ThreadID = " + Thread.currentThread().getId() + "with DriverID = " + driver.toString());

        loginPage = PageGeneratorManagerSauceLab.getLoginPage(driver);
        loginPage.enterToUsername(GlobalConstants.getGlobalConstants().getUserNameSaucedemo());
        loginPage.enterToPassword(GlobalConstants.getGlobalConstants().getPasswordSaucedemo());
        productPage = loginPage.clickToLoginButton();
    }
    @Test
    public void Sort_01_Name() {

            productPage.selectItemInSortDropdown("Name (A to ZB)");
            Assert.assertTrue(productPage.isProductByNameSortAscendingASC(), "Sort by Name (A to Z) failed");

            productPage.selectItemInSortDropdown("Name (Z to AD)");
            Assert.assertTrue(productPage.isProductByNameSortDescendingDESC(), "Sort by Name (Z to A) failed");

    }
    @Test
    public void Filter_01_Price() {
            productPage.selectItemInSortDropdown("Name (A to Z)");
            Assert.assertTrue(productPage.isProductByNameSortAscendingASC(), "Sort by Name (A to Z) failed");

            productPage.selectItemInSortDropdown("Name (Z to A)");
            Assert.assertTrue(productPage.isProductByNameSortDescendingDESC(), "Sort by Name (Z to A) failed");



    }
    @AfterMethod
         public void afterTest(ITestResult result) {

         closeBrowserAndSendNotifyLine(result);
    }


}
