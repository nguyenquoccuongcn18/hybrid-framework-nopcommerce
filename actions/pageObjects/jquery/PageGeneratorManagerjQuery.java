package pageObjects.jquery;

import org.openqa.selenium.WebDriver;
import pageObjectsUser.HomePageObject;

public class PageGeneratorManagerjQuery {
    public static HomePageObjectjQuery getHomePage(WebDriver driver){
        return new HomePageObjectjQuery(driver);
    }
}
