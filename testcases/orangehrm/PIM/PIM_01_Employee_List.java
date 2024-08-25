package orangehrm.PIM;

import commons.BaseTest;
import orangehrmPageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_01_Employee_List extends BaseTest {
    private WebDriver driver;
    private String employeeID;
    private LoginPageObjects loginPage;
    private DashboardObjects dashboardPage;
    private EmployeeListObjects employeeListPage;
    private PersonalDetailObjects personalDetailPage;
    private AddEmployeeObjects addEmployeePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriver(browserName,url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.inputToUsernameField("automation");
        loginPage.inputToPasswordField("Matkhau@123");
        dashboardPage = loginPage.clickToLoginButton();

        employeeListPage = dashboardPage.openPIMModule();

    }

    @Test
    public void EmployeeList_01_Add_New(){
        addEmployeePage.clickToAddEmployeeButton();
        addEmployeePage.enterFirstNameTextBox("");
        addEmployeePage.enterLastNameTextBox("");
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSave();
        addEmployeePage.isSuccessSaveMessageDisplayed();
        //p[contains(@class,'oxd-text--toast-message') and text()='Successfully Saved']

        personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);
        Assert.assertEquals(personalDetailPage.getFirstNameValue(),"");
        Assert.assertEquals(personalDetailPage.getLastNameValue(),"");
        Assert.assertEquals(personalDetailPage.getEmployeeID(),employeeID);

        employeeListPage = personalDetailPage.clickToEmployeeList();

        employeeListPage.enterToEmployeeIDTextBox(employeeID);
        employeeListPage.clickToSearchButton();

        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id",employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name","John"));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name",employeeID));






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
