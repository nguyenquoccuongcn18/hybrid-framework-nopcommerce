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

}
