package orangehrmUIs;

public class BaseActionUIs {
    public static final String SPINNER_ICON = "css=div.oxd-loading-spinner-container";
    public static final String SUCCESS_MESSAGE = "xpath=//p[contains(@class,'oxd-text--toast-message') and text()='%s']";

    public static final String DYNAMIC_INDEX_BY_COMLUMN_NAME_Test = "xpath=//div[contains(@class,'oxd-table-header-cell') and text()='%s']/preceding-sibling::div";
    public static final String DYNAMIC_CELL_VALUE_BY_COMLUMN_INDEX_AND_ROW_INDEX_Test = "xpath=//div[@class='oxd-table-card'][%s]//div[%s]/div[text()='%s']";
    public static final String DYNAMIC_INDEX_BY_COMLUMN_NAME = "xpath=//div[text()='%s']/preceding-sibling::div";
    public static final String DYNAMIC_RADIO_BUTTON_LABEL_NAME = "xpath=//label[text()='Male']/input";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME = "xpath=//label[normalize-space()='%s']//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_NAME = "xpath=//label[string()='%s']/input";


    public static final String DYNAMIC_ROW_VALUE_BY_COMLUMN_INDEX_AND_ROW_INDEX = "xpath=//div[@class='oxd-table-card']/div[@role='row'][%s]/div[%s]/div[contains(text(),'%s')]";
}

