package commons;

import org.openqa.selenium.WebDriver;
import pageObjectsAdmin.AdminDashboardPageObjects;
import pageObjectsAdmin.AdminLoginPageObject;
import pageObjectsUser.*;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static LoginPageObjectUser getLoginPageUser(WebDriver driver){
        return new LoginPageObjectUser(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static CustomerPageObject getCustomerPage(WebDriver driver){
        return new CustomerPageObject(driver);
    }
    public static AddressPageObjects getAddressPage(WebDriver driver){
        return new AddressPageObjects(driver);
    }
    public static OrderPageObjects getOrderPage(WebDriver driver){
        return new OrderPageObjects(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }
    public static AdminDashboardPageObjects getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPageObjects(driver);
    }

//    public static MyAccountSideBarPageObjects getCustomerPage(WebDriver driver) {
//        return new MyAccountSideBarPageObjects(driver);
//    }
}
