package orangehrmPageObjects;

import commons.BasePage;
import orangehrmUIs.AddEmployeeUIs;
import orangehrmUIs.BaseActionUIs;
import org.openqa.selenium.WebDriver;

public class BaseActions extends BasePage {
    WebDriver driver;
    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public BaseActions() {
    }

    public void waitForSpinnerIconInvisible() {
        waitForListElementsInvisible(driver, BaseActionUIs.SPINNER_ICON);
    }
    public boolean isSuccessSaveMessageDisplayed(String messageContent) {
        waitForElementVisible(driver, BaseActionUIs.SUCCESS_MESSAGE, messageContent);
        return isElementDisplay(driver, BaseActionUIs.SUCCESS_MESSAGE,messageContent);
    }
    public boolean isValueDisplayedAtColumnName(String columnName, String rowIndex,String valueCell) {
        int columnIndex = getListElementSize(driver,BaseActionUIs.DYNAMIC_INDEX_BY_COMLUMN_NAME, columnName) + 1;
        return isElementDisplay(driver,BaseActionUIs.DYNAMIC_ROW_VALUE_BY_COMLUMN_INDEX_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex), valueCell);
    }
//    public void clickToRadioButtonLabelName(String radioButtonName) {
//        clickToElementByJSelement(driver,BaseActionUIs.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME);
//    }
    public void clickToRadioButtonByLabelName(String radioButtonName) {
        clickToElement(driver,BaseActionUIs.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME,radioButtonName);
    }
    public void clickToSmokerCheckBoxByLabelName(String radioButtonName) {
        clickToElement(driver,BaseActionUIs.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME,radioButtonName);
    }

    public void clickToSmokerCheckBoxLabelName(String checkboxLabelName) {
        if(!isElementSelected(driver, BaseActionUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME)){
            clickToElementByJSelement(driver,BaseActionUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME);
        }

    }

    public boolean isRadioButtonSelectedByLabelName(String radioButtonName) {
        return isElementSelected(driver, BaseActionUIs.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME,radioButtonName);
    }

    public boolean isSmokerCheckBoxSelectedByLabelName(String checkboxLabelName) {
        return isElementSelected(driver, BaseActionUIs.DYNAMIC_CHECKBOX_BY_LABEL_NAME,checkboxLabelName);

    }
}
