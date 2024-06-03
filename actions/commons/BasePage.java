package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    //Toàn cục phạm vi là ở class
    WebDriver driver;

    // 1 - Access Modifier: public/protected/private/default

    // 2 - Kiểu dữ liệu của hàm (data type): void/int/String/boolean/Webelemnt/ListElement
    // Nó sẽ liên quan đến các chức năng mình viết trong thân hàm

    // 3 - Tên hàm phải có nghĩa với chức năng mình đang làm
    //camelCase: từ đầu viết thường - các chữ cái bắt đầu phía sau viết hoa

    // 4- - Có tham số hay không tùy vào chức năng mình đang viết

    // 5 - Kiểu trả về dữ liệu cho hàm
    //Hoàn thành xong phần thân của hàm
    // Nếu như có return dữ liệu thì sẽ khớp với kiểu dữ liệu ở số 2
    // Nếu như có return thì nó sẽ là step cuối cùng



    /*Web Browser */
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

    //Window
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    public void sleepInsecons(long timeInsecons) {
        try {
            Thread.sleep(timeInsecons * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}
