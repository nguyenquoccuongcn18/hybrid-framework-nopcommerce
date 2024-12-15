package orangehrm.PIM;

import commons.BaseTest;
import commons.GlobalConstants;
import orangehrmPageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojoData.orangehrm.EmployeeInfo;

public class PIM_01_Employee_List_POJO_Data extends BaseTest {
    private EmployeeInfo employeeInfo;
    private LoginPageObjects loginPage;
    private DashboardObjects dashboardPage;
    private EmployeeListObjects employeeListPage;
    private PersonalDetailObjects personalDetailPage;
    private AddEmployeeObjects addEmployeePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriverLocalV2(browserName,url);

        employeeInfo = EmployeeInfo.getEmployeeInfo();
        employeeInfo.setFirstName("John");
        employeeInfo.setLastName("Terry");
        employeeInfo.setNickName("Owen");
        employeeInfo.setDriverLicenseNumber("85D1-99.999");
        employeeInfo.setLicenseExpiryDate("2029-01-02");
        employeeInfo.setSsnNumber("428-79-79-778");
        employeeInfo.setDateOfBirth("1999-09-29");
        employeeInfo.setGenderStatus("Male");
        employeeInfo.setSmokerStatus("Yes");
        employeeInfo.setSinNumber("9998887799");
        employeeInfo.setNationality("Vietnamese");
        employeeInfo.setMaritalStatus("Married");

        loginPage = PageGeneratorManager.getLoginPage(driver);
        sleepInsecons(3);
        loginPage.inputToUsernameField(GlobalConstants.getGlobalConstants().getAdminOrgangeHrmUsernameLocal());
        sleepInsecons(3);
        loginPage.inputToPasswordField(GlobalConstants.getGlobalConstants().getAdminOrgangeHrmPasswordLocal());
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

        addEmployeePage.enterFirstNameTextBox(employeeInfo.getFirstName());
        addEmployeePage.enterLastNameTextBox(employeeInfo.getLastName());

        employeeInfo.setEmployeeID(addEmployeePage.getEmployeeID());
        addEmployeePage.clickToSave();

//        Assert.assertTrue(addEmployeePage.isSuccessSaveMessageDisplayed("Successfully Saved"));
        sleepInsecons(3);
//        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);
        sleepInsecons(3);
        Assert.assertTrue(personalDetailPage.isPersonalDetailHeaderDisplay());
        personalDetailPage.waitForSpinnerIconInvisible();

        sleepInsecons(1);
        Assert.assertEquals(personalDetailPage.getFirstNameValue(),employeeInfo.getFirstName());
        Assert.assertEquals(personalDetailPage.getLastNameValue(),employeeInfo.getLastName());
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeInfo.getEmployeeID());

        sleepInsecons(2);
        employeeListPage = personalDetailPage.clickToEmployeeList();

        employeeListPage.enterToEmployeeIDTextBox(employeeInfo.getEmployeeID());
        sleepInsecons(2);
        employeeListPage.clickToSearchButton();

        sleepInsecons(2);
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id", "1",employeeInfo.getEmployeeID()));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", "1",employeeInfo.getFirstName()));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name", "1",employeeInfo.getLastName()));

    }
    @Test
    public void EmployeeList_02_Person_Detail(){
        sleepInsecons(3);
        personalDetailPage = employeeListPage.clickToEditIconByEmployeeID(employeeInfo.getEmployeeID());

        sleepInsecons(3);
        Assert.assertEquals(personalDetailPage.getFirstNameValue(),employeeInfo.getFirstName());
        Assert.assertEquals(personalDetailPage.getLastNameValue(),employeeInfo.getLastName());
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeInfo.getEmployeeID());

        personalDetailPage.setPersonalDetail(employeeInfo);
        sleepInsecons(3);
        personalDetailPage.clickToSaveButtonAtPersonalDetailPart();

        sleepInsecons(3);
        Assert.assertTrue(personalDetailPage.isSuccessSaveMessageDisplayed("Successfully Updated"));
        personalDetailPage.waitForSpinnerIconInvisible();
        sleepInsecons(3);
        Assert.assertEquals(personalDetailPage.getNationalityDropdownSelectedText(),employeeInfo.getNationality());
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownSelectedText(),employeeInfo.getMaritalStatus());
        sleepInsecons(3);
        Assert.assertFalse(personalDetailPage.isRadioButtonSelectedByLabelName(employeeInfo.getGenderStatus()));

//        Assert.assertTrue(personalDetailPage.isSmokerCheckBoxSelectedByLabelName(genderStatus));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
