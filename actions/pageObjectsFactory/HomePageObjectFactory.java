package pageObjectsFactory;

import commons.BasePageFactoty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePageObjectFactory extends BasePageFactoty {
    WebDriver driver ;

    //1 - Define các element bằng Webelement
    @CacheLookup
    @FindBy(how = How.XPATH , using = "//a[@class='ico-register']")
    private WebElement registerLink;
    @FindBy(className = "//a[@class='ico-login']")
    private WebElement loginLink;

//    @FindBys({
//            @FindBy(xpath = "//a[@class='ico-']"),
//            @FindBy(xpath = "//a[@class='']")})
    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;

    //2 - kết hợp page object : NullpointException - 1 biến mới chỉ khai báo chứ chưa sử dụng
//    public HomePageObjectFactory(WebDriver driver) {
//        super.driver = driver;
//        //init lại element
//        PageFactory.initElements(this.driver, driver);
//    }
    public HomePageObjectFactory(WebDriver driver) {
        super();
        this.driver =driver;
        PageFactory.initElements(this.driver,driver);
    }


    public void clickToMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(driver, myAccountLink);
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(driver, registerLink);
    }
}
