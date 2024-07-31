package commons;

import org.openqa.selenium.WebDriver;
import pageObjectsUser.AddressPageObjects;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.OrderPageObjects;
import pageUserUIs.*;

public class BaseElement extends BasePage{
    WebDriver driver;
    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    public BaseElement() {
    }

    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        return PageGeneratorManager.getHomePage(driver);
    }
    public void clickToHeaderLinkByName(String pageName) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME,pageName);
        clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME,pageName);
    }

    public void clickToButtonByText(String buttonText) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_TEXT,buttonText);
        clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_TEXT,buttonText);
    }

    public String getTextboxErrorMessageByID(String errorMessageID) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID,errorMessageID);
        return getElementText(driver,BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID,errorMessageID);

    }

    public void enterToTextBoxByID(String textboxID, String valueSendKey) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
        sendKeysToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,valueSendKey,textboxID);

    }
    public String getTextboxAtrributeByID(String textboxID) {
        waitForElementInvisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
        return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,"value",textboxID);
    }
    public void openDynamicSideBarPageName(String pageName) throws Exception {
        waitForListElementVisible(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINKTEXT,pageName);
        clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINKTEXT,pageName);
    };

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

    public boolean isRegisterLinkDisplayed() {
        waitForElementInvisible(driver,BaseElementUI.DYNAMIC_TEXTBOX_BY_ID);
        clickToElement(driver, MyAccountSideBarPageUI.ORDERS_MENU_LEFT);
        return PageGeneratorManager.getOrderPage(driver).isRegisterLinkDisplayed();
    }
}
