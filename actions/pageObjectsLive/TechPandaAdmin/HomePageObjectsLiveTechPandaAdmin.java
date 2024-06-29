package pageObjectsLive.TechPandaAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsLive.TechPandaUser.HomePageObjectsLiveTechPandaUser;
import pageUIsLive.TechPanDa.HomePageUIsAdmin;

public class HomePageObjectsLiveTechPandaAdmin extends BasePage {
    WebDriver driver ;
    public HomePageObjectsLiveTechPandaAdmin(WebDriver driver) {
        this.driver = driver;
    }

    public static HomePageObjectsLiveTechPandaAdmin getHomePageAdmin(WebDriver driver) {
        return new HomePageObjectsLiveTechPandaAdmin(driver);

    }

    public HomePageObjectsLiveTechPandaUser LoginUserAdmin(String username){
        waitForElementClickable(driver, HomePageUIsAdmin.INPUT_USERNAME);
        sendKeysToElement(driver, HomePageUIsAdmin.INPUT_USERNAME,username);
        return null;
    }
    public void LoginPassWordAdmin(String password){
        waitForElementClickable(driver, HomePageUIsAdmin.INPUT_PASSWORDUSER);
        sendKeysToElement(driver, HomePageUIsAdmin.INPUT_PASSWORDUSER, password);

    }
    public void clickButtonLoginAdmin(){
        waitForElementClickable(driver, HomePageUIsAdmin.LOGIN_BUTTON);
        clickToElement(driver, HomePageUIsAdmin.LOGIN_BUTTON);
    }

    public void enterToTextboxSelectEmailIndex(String columnName, String rowIndex, String ValueSendkey) {
        //lấy ra index
        int columnIndex = getListElementSize(driver, HomePageUIsAdmin.DYNAMIC_COLUMN_INDEX_BY_CLOUMN_NAME, columnName,rowIndex,ValueSendkey) + 1;

        waitForElementVisible(driver,HomePageUIsAdmin.DYNAMIC_COLUMN_INDEX_BY_CLOUMN_NAME, rowIndex, String.valueOf(columnIndex));
        sendKeysToElement(driver, HomePageUIsAdmin.DYNAMIC_COLUMN_INDEX_BY_CLOUMN_NAME,ValueSendkey,rowIndex, String.valueOf(columnIndex));
    }

    public void senKeySelectEmail(String column, String values) {
        waitForElementClickable(driver, HomePageUIsAdmin.SELECT_VALUES_COLUMN,column);
        sendKeysToElement(driver, HomePageUIsAdmin.SELECT_VALUES_COLUMN, values,column);
    }

    public void closePopup() {
        waitForElementVisible(driver, HomePageUIsAdmin.CLOSE_POPUP_BUTTON);
        clickToElement(driver, HomePageUIsAdmin.CLOSE_POPUP_BUTTON);
    }
}

