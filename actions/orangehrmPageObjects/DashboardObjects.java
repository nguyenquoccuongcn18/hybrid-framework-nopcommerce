package orangehrmPageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardObjects extends BasePage {
    WebDriver driver;
    public DashboardObjects(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListObjects openPIMModule() {
        return null;
    }
}
