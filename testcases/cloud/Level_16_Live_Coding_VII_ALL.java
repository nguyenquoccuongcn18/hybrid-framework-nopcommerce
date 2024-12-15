package cloud;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;


public class Level_16_Live_Coding_VII_ALL extends BaseTest {

    private WebDriver driver;

     private LoginPageObjects loginPage;
    private ProductPageObjects productPage;



    @Parameters({"envName", "serverName", "browser", "ipAddress","portNumber","osName","osVer"})
    @BeforeMethod
    public void beforeClass(@Optional("local") String envName,@Optional("dev") String serverName,@Optional("chrome") String browserName,@Optional("localhost") String ipAddress,@Optional("4444") String portNumber,@Optional("Windows") String osName,@Optional("10") String osVer) {
        driver= getBrowserDriver(envName, serverName,browserName,ipAddress,portNumber, osName,osVer);
        loginPage = PageGeneratorManagerSauceLab.getLoginPage(driver);

        loginPage.enterToUsername(GlobalConstants.getGlobalConstants().getUserNameSaucedemo());
        loginPage.enterToPassword(GlobalConstants.getGlobalConstants().getPasswordSaucedemo());
        productPage = loginPage.clickToLoginButton();

    }
    @Test
    public void Sort_01_Name() {
        productPage.selectItemInSortDropdown("Name (A to Z)");
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
