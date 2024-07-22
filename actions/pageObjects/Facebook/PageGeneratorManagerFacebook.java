package pageObjects.Facebook;

import org.openqa.selenium.WebDriver;
import pageObjects.jquery.HomePageObjectjQuery;

public class PageGeneratorManagerFacebook {
    public static HomePageObjectFacebook getHomePage(WebDriver driver){
        return new HomePageObjectFacebook(driver);
    }

}
