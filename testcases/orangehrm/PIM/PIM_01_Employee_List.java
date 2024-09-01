package orangehrm.PIM;

import commons.BaseTest;
import commons.GlobalConstants;
import orangehrmPageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_01_Employee_List extends BaseTest {
    private WebDriver driver;
    private String employeeID,firstName,lastName;
    private LoginPageObjects loginPage;
    private DashboardObjects dashboardPage;
    private EmployeeListObjects employeeListPage;
    private PersonalDetailObjects personalDetailPage;
    private AddEmployeeObjects addEmployeePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriver(browserName,url);
        firstName="Michael";
        lastName="Owen";

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

        sleepInsecons(3);
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessageDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerIconInvisible();

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
    @Test
    public void EmployeeList_02_Person_Detail(){

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
