package live.TechPanDa;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsLive.TechPandaAdmin.HomePageObjectsLiveTechPandaAdmin;
import pageObjectsLive.TechPandaUser.GlobalConstantsLiveTechPanda;
import pageObjectsLive.TechPandaUser.HomePageObjectsLiveTechPandaUser;
import pageObjectsLive.TechPandaUser.PageGeneratorManagerLiveTechPanda;


public class Level_13_Handle_LiveTechPanDa extends BaseTest {
    private WebDriver driver;
    private HomePageObjectsLiveTechPandaUser homePageUser;
    private HomePageObjectsLiveTechPandaAdmin homePageAdmin;
    private String adminUrl = GlobalConstantsLiveTechPanda.DEV_ADMIN_URL;
    private String userUrl = GlobalConstantsLiveTechPanda.DEV_USER_URL;


    @Parameters({"browser","adminUrl","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        driver= getBrowerDriverAdminEndUser(browserName,userUrl);
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        homePageUser = HomePageObjectsLiveTechPandaUser.gethomePageUser(driver);

    }

    @Test
    public void TC_01_Search() {
        homePageUser.clickAccountUser();
        homePageUser.clickRegisterUser("Register");
        homePageUser.inputFirstName("firstname","Toni1");
        homePageUser.inputLastName("lastname","Montoya1");
        homePageUser.inputEmailAddress("email_address","tonimontoya2@gmail.com");
        homePageUser.inputPasswordUser("password","12345678");
        homePageUser.inputConfirmPasswordUser("confirmation","12345678");
        homePageUser.clickButtonRegister();
//        Assert.assertEquals(1, homePageUser.verifyAccountSuccess(),"Thank you for registering with Main Website Store.");
    }
    @Test
    public void TC_02_PageToPage() {
        homePageUser.openPageUrl(driver,adminUrl);
        homePageAdmin = HomePageObjectsLiveTechPandaAdmin.getHomePageAdmin(driver);
        homePageAdmin.LoginUserAdmin("user01");
        homePageAdmin.LoginPassWordAdmin("guru99com");
        homePageAdmin.clickButtonLoginAdmin();

        homePageAdmin.closePopup();
        homePageAdmin.senKeySelectEmail("email","tonimontoya2@gmail.com");
    }


    @AfterClass
    public void afterClass() {
   closeBrowser();
    }
}



