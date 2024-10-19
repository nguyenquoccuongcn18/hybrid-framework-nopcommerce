package orangehrmPageObjects;

import orangehrmUIs.DashboardUIs;
import org.openqa.selenium.WebDriver;

public class DashboardObjects extends BaseActions {
    WebDriver driver;
    public DashboardObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EmployeeListObjects openPIMModule() {
        waitForElementClickable(driver, DashboardUIs.PIM_MODULE);
        clickToElement(driver, DashboardUIs.PIM_MODULE);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getEmployeeListPage(driver);
    }
    public EmployeeListObjects isSearchOrangeHRM (String values) {
        waitForElementVisible(driver, DashboardUIs.SEARCH_ORANGE_HRM);
        sendKeysToElement(driver, DashboardUIs.SEARCH_ORANGE_HRM,values);
        return PageGeneratorManager.getEmployeeListPage(driver);
    }

}
