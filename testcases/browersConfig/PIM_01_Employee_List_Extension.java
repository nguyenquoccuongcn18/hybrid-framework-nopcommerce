package browersConfig;

import commons.BaseTest;
import commons.GlobalConstants;
import orangehrmPageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_01_Employee_List_Extension extends BaseTest {
    private WebDriver driver;
    private String employeeID,firstName,lastName;
    private String driverLicenseNumber,licenseExpiryDate, ssnNumber,nickName;
    private String dateOfBirth,genderStatus,smokerStatus,sinNumber,nationality,maritalStatus;
    private LoginPageObjects loginPage;
    private DashboardObjects dashboardPage;
    private EmployeeListObjects employeeListPage;
    private PersonalDetailObjects personalDetailPage;
    private AddEmployeeObjects addEmployeePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {

        //Data EmployeeList_01_Add_New
        driver= getBrowserDriverWithExtensions(browserName,url);
        firstName="John";
        lastName="Terry";

        //Data EmployeeList_02_Person_Detail
        nickName="Owen";
        driverLicenseNumber="85D1-99.999";
        licenseExpiryDate="2029-01-02";
        ssnNumber ="428-79-79-778";
        dateOfBirth="1999-09-29";
        genderStatus="Male";
        smokerStatus="Yes";
        sinNumber="9998887799";
        nationality="Vietnamese";
        maritalStatus="Married";

        loginPage = PageGeneratorManager.getLoginPage(driver);
        sleepInsecons(3);
        loginPage.inputToUsernameField(GlobalConstants.ADMIN_ORGANGE_HRM_USERNAME);
        sleepInsecons(3);
        loginPage.inputToPasswordField(GlobalConstants.ADMIN_ORGANGE_HRM_PASSWORD);
        sleepInsecons(3);
        dashboardPage = loginPage.clickToLoginButton();
        sleepInsecons(5);
        employeeListPage = dashboardPage.openPIMModule();
    }

    @Test
    public void EmployeeList_01_Add_New(){
        sleepInsecons(3);
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();
        sleepInsecons(3);
        addEmployeePage.enterFirstNameTextBox(firstName);
        addEmployeePage.enterLastNameTextBox(lastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSave();

//        Assert.assertTrue(addEmployeePage.isSuccessSaveMessageDisplayed("Successfully Saved"));
        sleepInsecons(3);
//        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);
        sleepInsecons(3);
        Assert.assertTrue(personalDetailPage.isPersonalDetailHeaderDisplay());
        personalDetailPage.waitForSpinnerIconInvisible();

        sleepInsecons(1);
        Assert.assertEquals(personalDetailPage.getFirstNameValue(),firstName);
        Assert.assertEquals(personalDetailPage.getLastNameValue(),lastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeID);

        sleepInsecons(2);
        employeeListPage = personalDetailPage.clickToEmployeeList();

        employeeListPage.enterToEmployeeIDTextBox(employeeID);
        sleepInsecons(2);
        employeeListPage.clickToSearchButton();

        sleepInsecons(2);
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id", "1",employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", "1",firstName));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name", "1",lastName));

    }
    @Test(enabled = false)
    public void EmployeeList_02_Person_Detail(){
        sleepInsecons(3);
        personalDetailPage = employeeListPage.clickToEditIconByEmployeeID(employeeID);

        sleepInsecons(3);
        Assert.assertEquals(personalDetailPage.getFirstNameValue(),firstName);
        Assert.assertEquals(personalDetailPage.getLastNameValue(),lastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeID);

//        sleepInsecons(3);
//        personalDetailPage.enterToNicknameTextBox(nickName);

        sleepInsecons(3);
        personalDetailPage.enterToDriverLicenseNumberTextBox(driverLicenseNumber);
        sleepInsecons(3);
        personalDetailPage.enterToDriverLicenseExpiryDatePicker(licenseExpiryDate);

            //Chỉ chạy cho LIVE chứ k chạy LOCAL
//        personalDetailPage.enterToSocialSecurityNumberTextBox(ssnNumber);
//        personalDetailPage.enterToSocialInsuranceNumberTextBox(sinNumber);
        personalDetailPage.selectToNationalityDropdown(nationality);
        personalDetailPage.selectToMaritalStatusDropdown(maritalStatus);
        personalDetailPage.enterToDateOfBirthDatePicker(dateOfBirth);
        personalDetailPage.clickToRadioButtonByLabelName(genderStatus);

//        personalDetailPage.clickToSmokerCheckBoxByLabelName(smokerStatus);

        sleepInsecons(3);
        personalDetailPage.clickToSaveButtonAtPersonalDetailPart();

        sleepInsecons(3);
        Assert.assertTrue(personalDetailPage.isSuccessSaveMessageDisplayed("Successfully Updated"));
        personalDetailPage.waitForSpinnerIconInvisible();
        sleepInsecons(3);
        Assert.assertEquals(personalDetailPage.getNationalityDropdownSelectedText(),nationality);
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownSelectedText(),maritalStatus);
        sleepInsecons(3);
        Assert.assertFalse(personalDetailPage.isRadioButtonSelectedByLabelName(genderStatus));

//        Assert.assertTrue(personalDetailPage.isSmokerCheckBoxSelectedByLabelName(genderStatus));

    }
    @Test
    public void EmployeeList_03_Contact_Detail(){

    }
    @Test
    public void EmployeeList_04_Emergency_Detail(){

    }
    @Test
    public void EmployeeList_05_Dependents(){

    }
    @Test
    public void EmployeeList_06_Immigration(){

    }
    @Test
    public void EmployeeList_07_Job(){

    }
    @Test
    public void EmployeeList_08_Slary(){

    }
    @Test
    public void EmployeeList_08_Report(){

    }




    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
