package account;


import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;
import utilities.ExcelConfig;

import java.io.IOException;
import java.util.Set;


public class Level_27_Data_Excel_V2 extends BaseTest {

    private WebDriver driver;
     private HomePageObject homePage;
     private RegisterPageObject registerPage;
     public static Set<Cookie> cookie ;
     public ExcelConfig excelConfig;
     String Firstname,Lastname,Email,Password;






    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) throws IOException {

        driver= getBrowerDriverLocal(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("UserData.xlsx");

        Firstname = excelConfig.getCellData("Firstname",1);
        Lastname = excelConfig.getCellData("Lastname",1);
        Email = getEmailRandoms(excelConfig.getCellData("Email",1));
        Password = excelConfig.getCellData("Password",1);




        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox(Firstname);
        registerPage.enterToLastNameTextBox(Lastname);
        registerPage.enterToEmailTextBox(Email);
        registerPage.enterToPsswordTextBox(Password);
        registerPage.enterToconfirmPasswordTextBox(Password);
        registerPage.clickToRegisterButton();
        registerPage.refreshCurrentPage(driver);
        sleepInsecons(5);
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
        cookie = registerPage.getBrowserCookies(driver);

        System.out.println("Log Email Common_Register : " + Email);
        System.out.println("Log Password Common_Register: " + Password);
       closeBrowser();
    }

}
