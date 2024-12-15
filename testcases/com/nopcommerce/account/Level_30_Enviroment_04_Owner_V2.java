package account;


import commons.BaseTest;
import commons.GlobalConstants;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;
import utilities.EnviromentConfig;


public class Level_30_Enviroment_04_Owner_V2 extends BaseTest {

    private EnviromentConfig enviromentConfig;

     private LoginPageObjects loginPage;
    private ProductPageObjects productPage;



    @Parameters({"browser","server"})
    @BeforeClass
    public void beforeClass(String browserName,String serverName) {
        ConfigFactory.setProperty("server",serverName);
        enviromentConfig = ConfigFactory.create(EnviromentConfig.class);
        driver = getBrowserEnvironmentV2(browserName, enviromentConfig.appUrl());

        System.out.println("url:" + enviromentConfig.appUrl());
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
