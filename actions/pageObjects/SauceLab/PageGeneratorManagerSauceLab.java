package pageObjects.SauceLab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerSauceLab {
    public static dataUiPageObject getClickItem(WebDriver driver){
        return new dataUiPageObject(driver);
    };

    public static LoginPageObjects getLoginPage(WebDriver driver){
        return new LoginPageObjects(driver);
    }
    public static ProductPageObjects getProductPage(WebDriver driver){
        return new ProductPageObjects(driver);
    }

}
