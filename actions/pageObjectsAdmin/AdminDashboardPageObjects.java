package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageAdminUIs.AdminDashBoardPageUI;

public class AdminDashboardPageObjects extends BasePage {
     WebDriver driver;
    public AdminDashboardPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public AdminLoginPageObject clickToLogOutLinkAdmin() {
       waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_LOGOUT_ADM);
       clickToElement(driver, AdminDashBoardPageUI.DASHBOARD_LOGOUT_ADM);
       return PageGeneratorManager.getAdminLoginPage(driver);
    }
}
