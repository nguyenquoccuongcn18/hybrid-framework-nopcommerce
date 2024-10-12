package orangehrmPageObjects;

import commons.BasePage;
import orangehrmUIs.BaseActionUIs;
import orangehrmUIs.PersonalDetailUIs;
import org.openqa.selenium.WebDriver;
import pojoData.orangehrm.EmployeeInfo;

public class PersonalDetailObjects extends BaseActions {
    WebDriver driver;
    public PersonalDetailObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameValue() {
        waitForElementVisible(driver, PersonalDetailUIs.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailUIs.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameValue() {
        waitForElementVisible(driver, PersonalDetailUIs.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailUIs.LASTNAME_TEXTBOX,"value");
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailUIs.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailUIs.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public EmployeeListObjects clickToEmployeeList() {
        waitForElementClickable(driver,PersonalDetailUIs.EMPLOYEE_LIST_BUTTON);
        clickToElement(driver,PersonalDetailUIs.EMPLOYEE_LIST_BUTTON);
        return PageGeneratorManager.getEmployeeListPage(driver);
    }

    public boolean isPersonalDetailHeaderDisplay() {
        waitForElementVisible(driver, PersonalDetailUIs.PERSONAL_DETAIL_PAGE_HEADER);
        return isElementDisplay(driver, PersonalDetailUIs.PERSONAL_DETAIL_PAGE_HEADER);
    }

    public void enterToNicknameTextBox(String nickName) {
        waitForElementVisible(driver, PersonalDetailUIs.NICKNAME_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailUIs.NICKNAME_TEXTBOX, nickName);
    }

    public void enterToDriverLicenseNumberTextBox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailUIs.DRIVER_LICENSE_NUMBER_TEXBOX);
        sendKeysToElement(driver, PersonalDetailUIs.DRIVER_LICENSE_NUMBER_TEXBOX, driverLicense);
    }

    public void enterToDriverLicenseExpiryDatePicker(String driverLicenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailUIs.DRIVER_EXPIRY_DATE_PICKER);
        sendKeysToElement(driver, PersonalDetailUIs.DRIVER_EXPIRY_DATE_PICKER, driverLicenseExpiryDate);
    }

    public void enterToSocialSecurityNumberTextBox(String ssNumber) {
        waitForElementVisible(driver, PersonalDetailUIs.SOCIAL_SCURITY_NUMBER_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailUIs.SOCIAL_SCURITY_NUMBER_TEXTBOX, ssNumber);
    }

    public void enterToSocialInsuranceNumberTextBox(String siNumber) {
        waitForElementVisible(driver, PersonalDetailUIs.SOCIAL_INSURANCE_NUMBER_TEXTBOX);
        sendKeysToElement(driver, PersonalDetailUIs.SOCIAL_INSURANCE_NUMBER_TEXTBOX, siNumber);
    }

    public void selectToNationalityDropdown(String nationality) {
        waitForElementClickable(driver,PersonalDetailUIs.NATIONALITY_DROPDOWN_PARENT);
        selectItemInDropdown(driver, PersonalDetailUIs.NATIONALITY_DROPDOWN_PARENT,PersonalDetailUIs.NATIONALITY_DROPDOWN_CHILD_ITEM,nationality);
    }

    public void selectToMaritalStatusDropdown(String maritalStatusDropdown) {
        waitForElementClickable(driver,PersonalDetailUIs.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInDropdown(driver, PersonalDetailUIs.MARITAL_STATUS_DROPDOWN_PARENT,PersonalDetailUIs.MARITAL_STATUS_DROPDOWN_CHILD_ITEM,maritalStatusDropdown);
    }

    public void enterToDateOfBirthDatePicker(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailUIs.DATE_OF_BIRTH_PICKER);
        sendKeysToElement(driver, PersonalDetailUIs.DATE_OF_BIRTH_PICKER, dateOfBirth);
    }

    public void clickToSaveButtonAtPersonalDetailPart() {
        waitForElementClickable(driver,PersonalDetailUIs.SAVE_BUTTON_AT_PERSON_DETAIL);
        clickToElement(driver,PersonalDetailUIs.SAVE_BUTTON_AT_PERSON_DETAIL);
    }

    public String getNationalityDropdownSelectedText() {
        return getElementText(driver, PersonalDetailUIs.NATIONALITY_DROPDOWN_SELECTED_TEXT);
    }

    public String getMaritalStatusDropdownSelectedText() {
        return getElementText(driver, PersonalDetailUIs.MARITAL_STATUS_DROPDOWN_SELECTED_TEXT);
    }

    public void setPersonalDetail(EmployeeInfo employeeInfo) {
        enterToDriverLicenseNumberTextBox(employeeInfo.getDriverLicenseNumber());
        enterToDriverLicenseExpiryDatePicker(employeeInfo.getLicenseExpiryDate());
        selectToNationalityDropdown(employeeInfo.getNationality());
        selectToMaritalStatusDropdown(employeeInfo.getMaritalStatus());
        enterToDateOfBirthDatePicker(employeeInfo.getDateOfBirth());
        clickToRadioButtonByLabelName(employeeInfo.getGenderStatus());

    }
}
