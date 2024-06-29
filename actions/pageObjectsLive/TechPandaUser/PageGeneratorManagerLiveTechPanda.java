package pageObjectsLive.TechPandaUser;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerLiveTechPanda {
    public static HomePageObjectsLiveTechPandaUser getHomePage(WebDriver driver){
        return new HomePageObjectsLiveTechPandaUser(driver);
    }


}
