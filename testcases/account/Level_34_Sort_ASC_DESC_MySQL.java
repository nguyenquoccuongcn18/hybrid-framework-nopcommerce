package account;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;
import pageObjects.SauceLab.dataUiPageObject;
import retryConfig.RetryListener;

import java.sql.SQLException;

@Listeners(RetryListener.class)
public class Level_34_Sort_ASC_DESC_MySQL extends BaseTest {

    private WebDriver driver;

     private LoginPageObjects loginPage;
    private ProductPageObjects productPage;
    private dataUiPageObject dataItemNameUI;
    private LoginPageObjects LoginPage;



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

    public void VerifyDataUIEqualsDB() throws SQLException, ClassNotFoundException {

        dataItemNameUI = productPage.clickToItem();

        //Data UI
//        int totalNumberItemNameUI = dataItemNameUI.getDataUiSauceLabUI();
        String totalNumberItemNameUI = dataItemNameUI.getDataUiSauceLabUIV2();


        //Data MySQL
//        int totalNumberItemNameDB = dataItemNameUI.getDataUiSauceLabDB();
        String totalNumberItemNameDB = dataItemNameUI.getDataUiSauceLabDBV2();


        //Matching UI and SQL
        verifyEquals(totalNumberItemNameUI, totalNumberItemNameDB);
        System.out.println("Data UI: " + totalNumberItemNameUI);
        System.out.println("Data DB: " + totalNumberItemNameDB);


        dataItemNameUI.checkTotalRecordMemorySizeFromDB("1000008","Sauce Labs Backpack","roleAdmin");

    }
    @AfterMethod
         public void afterTest() {
            driver.quit();
    }
}
