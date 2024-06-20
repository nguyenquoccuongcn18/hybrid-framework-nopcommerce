package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePageFactoty {


    protected WebDriver driver;

    public static BasePage getBasePage() {
        return new BasePage();
    }
    public void openPageUrl(WebDriver driver , String pageUrl){
        driver.get(pageUrl);
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresent(WebDriver driver){
        Duration timeout = Duration.ofMillis(30);
        return new WebDriverWait(driver,timeout).until(ExpectedConditions.alertIsPresent());
    }
    public void acceptToAlert (WebDriver driver){
        waitForAlertPresent(driver).accept();
    }
    public void cancleToAlert (WebDriver driver){
        waitForAlertPresent(driver).dismiss();
    }
    public String getTextToAlert (WebDriver driver){
        return  waitForAlertPresent(driver).getText();
    }
    public void sendKeyToAlert (WebDriver driver , String keyToSend){
        waitForAlertPresent(driver).sendKeys(keyToSend);
    }
    public void closeCurrentWindow(WebDriver driver){
        driver.close();
    }
    public Set<Cookie> getBrowserCookies(WebDriver driver){
        return driver.manage().getCookies();
    }
    public void setCookie(WebDriver driver, Set<Cookie> cookies  ){
        //Cookie cookie = new Cookie.Builder(name, value).build();
        for (Cookie cookie  : cookies){
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }

    public void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }

    public void sendKeysToElement(WebDriver driver, WebElement element){
        element.clear();
        element.sendKeys();
    }
    public String getElementText(WebDriver driver, WebElement element){
        return element.getText();
    }
    public void waitForElementVisible(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofMillis(3)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementClickable(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofMillis(20)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public String getElementAttribute(WebDriver driver, WebElement element,String AttributeName){
        return element.getAttribute(AttributeName);
    }

}
