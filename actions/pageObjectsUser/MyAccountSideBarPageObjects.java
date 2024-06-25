package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUserUIs.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObjects extends BasePage {
     WebDriver driver;

    public MyAccountSideBarPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    public AddressPageObjects openAddressPage() {
        waitForElementInvisible(driver, MyAccountSideBarPageUI.ADDRESS_MENU_LEFT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_MENU_LEFT);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public OrderPageObjects openOrderPage() {
        waitForElementInvisible(driver, MyAccountSideBarPageUI.ORDERS_MENU_LEFT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDERS_MENU_LEFT);
        return PageGeneratorManager.getOrderPage(driver);
    }

    public CustomerPageObject openCustomerPage() {
        waitForElementInvisible(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_MENU_LEFT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_MENU_LEFT);
        return PageGeneratorManager.getCustomerPage(driver);
    }
    public MyAccountSideBarPageObjects openDynamicSideBarPage(String pageName) throws Exception {
        waitForListElementVisible(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINKTEXT,pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINKTEXT,pageName);
        return switch (pageName) {
            case "Customer Info" -> PageGeneratorManager.getCustomerPage(driver);
            case "Orders" -> PageGeneratorManager.getOrderPage(driver);
            case "Address" -> PageGeneratorManager.getAddressPage(driver);
            default -> throw new Exception("Side bar page" + pageName + "invalid");
        };


    }
    public void openDynamicSideBarPageName(String pageName) throws Exception {
        waitForListElementVisible(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINKTEXT,pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINKTEXT,pageName);
    };

}
