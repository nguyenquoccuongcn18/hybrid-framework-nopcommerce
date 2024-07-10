package pageObjects.jquery;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObjectjQuery extends BasePage {
    public boolean isPageByNumberActive;
    WebDriver driver ;
    private Object getListWebElement;

    public HomePageObjectjQuery(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Input to Column textbox with value is {0} and {1}")
    public void inputToColomnTextBoxByName(String columnName , String valueSendkey){
        waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME,columnName);
        sendKeysToElement(driver,  HomePageUI.COLUMN_TEXTBOX_BY_NAME,valueSendkey, columnName);

    }
    public void clickToPageByNumber(String pageNumber){
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }
    public boolean isPageByNumberActive(String pageNumber){
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_BY_NUMBER_ACTIVE, pageNumber);
        return isElementDisplay(driver, HomePageUI.PAGE_LINK_BY_NUMBER_ACTIVE,pageNumber);
    }
    public boolean isRowValuesDisplay(String females, String country, String males , String total){
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, females,country,males,total);
        return isElementDisplay(driver, HomePageUI.DYNAMIC_ROW_VALUES, females,country,males,total);
    }
    public void clickToRowActionByCountryName(String countryName, String rowAction){
        waitForElementVisible(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME,countryName,rowAction);
        clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME,countryName,rowAction);
    }

    public void clickClosePopup(WebDriver driver) {
        waitForElementVisible(driver, HomePageUI.CLICK_CLOSE_POPUP);
        clickToElement(driver, HomePageUI.CLICK_CLOSE_POPUP);
    }
    //Lấy dữ liệu từ UI
    public List<String> getAllPageValuesByColumnNumber(String columnName) {
        //Lưu lại bằng List
        List<String> allValues = new ArrayList<String>();

        //1. Lấy ra tất cả các page
        List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINK);
        //1.1 Lấy ra index của cột
        int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        //2.Duyệt qua từng page
        for (WebElement pageLink : allPageLinks) {
            pageLink.click();

            //3. Lấy ra tất cả các giá trị trong cột -> lưu vào List set
            List<WebElement> allRowValues = getListWebElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX,String.valueOf(columnIndex));
        for (WebElement rowValue : allRowValues){
            allValues.add(rowValue.getText());
            }
        }
            return allValues;
    }

    public List<String> getAllPageValuesByColumnNameInDB(String country) {
        return null;
    }

    public List<String> getAllPageValuesByColumnNameInAPI(String country) {
        return null;
    }

    public void enterToTextboxByColumnNameAndRowIndex(String contactPerson, String rowIndex, String ValueSendkey) {
        //lấy ra index
        int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, contactPerson,rowIndex,ValueSendkey) + 1;

        waitForElementVisible(driver,HomePageUI.DYNAMIC_TEXTBOX_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_ROW_INDEX_AND_COLUMN_INDEX,ValueSendkey,rowIndex, String.valueOf(columnIndex));
    }

    public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
        int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementClickable(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX,dropdownItem, rowIndex, String.valueOf(columnIndex));

    }

    public void clickCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementClickable(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        checkToElement(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,rowIndex,String.valueOf(columnIndex));


    }
}
