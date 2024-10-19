package pageObjects.SauceLab;

import org.openqa.selenium.WebDriver;
import pageObjects.jquery.HomePageObjectjQuery;
import pageObjects.jquery.UploadPageObjects;

public class PageGeneratorManagerSauceLab {
    public static LoginPageObjects getLoginPage(WebDriver driver){
        return new LoginPageObjects(driver);
    }
    public static ProductPageObjects getProductPage(WebDriver driver){
        return new ProductPageObjects(driver);
    }
}
