package orangehrmPageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static AddEmployeeObjects getAddEmployeePage(WebDriver driver){
        return new AddEmployeeObjects(driver);
    }
    public static EmployeeListObjects getEmployeeListPage(WebDriver driver){
        return new EmployeeListObjects(driver);
    }
    public static ContactDetailObjects getContactDetailPage(WebDriver driver){
        return new ContactDetailObjects(driver);
    }
    public static DashboardObjects getDashboardPage(WebDriver driver){
        return new DashboardObjects(driver);
    }
    public static DependentsObjects getDependentsPage(WebDriver driver){
        return new DependentsObjects(driver);
    }
    public static EmergencyContactsObjects getEmergencyContactsPage(WebDriver driver){
        return new EmergencyContactsObjects(driver);
    }
    public static ImmigrationObjects getImmigrationPage(WebDriver driver){
        return new ImmigrationObjects(driver);
    }
    public static JobObjects getJobPage(WebDriver driver){
        return new JobObjects(driver);
    }
    public static LoginPageObjects getLoginPage(WebDriver driver){
        return new LoginPageObjects(driver);
    }
    public static PersonalDetailObjects getPersonalDetailPage(WebDriver driver){
        return new PersonalDetailObjects(driver);
    }
    public static ReportObjects getReportPage(WebDriver driver){
        return new ReportObjects(driver);
    }
    public static SalaryObjects getSalaryPage(WebDriver driver){
        return new SalaryObjects(driver);
    }


}
