package account;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;


public class Level_30_Enviroment_01_Parameter_Name_V2 extends BaseTest {

    private WebDriver driver;

     private LoginPageObjects loginPage;
    private ProductPageObjects productPage;



    @Parameters({"browser","server"})
    @BeforeClass
    public void beforeClass(String browserName,String serverName) {
        driver= getBrowserEnvironment(browserName,serverName);
        loginPage = PageGeneratorManagerSauceLab.getLoginPage(driver);

        loginPage.enterToUsername(GlobalConstants.getGlobalConstants().getUserNameSaucedemo());
        loginPage.enterToPassword(GlobalConstants.getGlobalConstants().getPasswordSaucedemo());
        productPage = loginPage.clickToLoginButton();

    }
    @Test
    public void Sort_01_Name() {
//        productPage.selectItemInSortDropdown("Name (A to Z)");
//        Assert.assertTrue(productPage.isProductByNameSortAscendingASC());
//
//        productPage.selectItemInSortDropdown("Name (Z to A)");
//        Assert.assertTrue(productPage.isProductByNameSortDescendingDESC());


    }
    @Test
    public void Sort_01_Price() {
//        productPage.selectItemInSortDropdown("Price (low to high)");
//        Assert.assertTrue(productPage.isProductByPriceSortAscendingASC());
//
//        productPage.selectItemInSortDropdown("Price (high to low)");
//        Assert.assertTrue(productPage.isProductByPriceSortDescendingDESC());
        
    }
    @Test
    public void Sort_01_Date_Month() {

    }
    @AfterClass
         public void afterTest() {
            driver.quit();
    }
}
