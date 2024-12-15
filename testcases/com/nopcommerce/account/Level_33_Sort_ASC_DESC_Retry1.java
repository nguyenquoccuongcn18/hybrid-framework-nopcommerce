package account;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;
import retryConfig.RetryListener;
@Listeners(RetryListener.class)
public class Level_33_Sort_ASC_DESC_Retry1 extends BaseTest {

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
        Assert.assertTrue(productPage.isProductByNameSortAscendingASC());

        productPage.selectItemInSortDropdown("Name (Z to A)");
        Assert.assertTrue(productPage.isProductByNameSortDescendingDESC());


    }
    @Test
    public void Sort_01_Price() {
        productPage.selectItemInSortDropdown("Price (low to high)");
        Assert.assertTrue(productPage.isProductByPriceSortAscendingASC());

        productPage.selectItemInSortDropdown("Price (high to low)");
        Assert.assertTrue(productPage.isProductByPriceSortDescendingDESC());
        
    }
    @Test
    public void Sort_01_Date_Month() {

    }
    @AfterMethod
         public void afterTest() {
            driver.quit();
    }
}
