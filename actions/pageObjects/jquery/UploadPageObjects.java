package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUIs;

import java.util.List;

public class UploadPageObjects extends BasePage {
    WebDriver driver ;
    public UploadPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFilesLoadSucces(String imageName) {
        waitForElementVisible(driver, UploadPageUIs.FILE_LOADED_BY_NAME,imageName);
        return isElementDisplay(driver, UploadPageUIs.FILE_LOADED_BY_NAME,imageName);
    }

    public void clickStartButtonOnEchFile() {
        List<WebElement> startButtons = getListWebElement(driver, UploadPageUIs.START_BUTTON);
        for (WebElement startButton : startButtons) {
            waitForElementClickable(driver,startButton);
            clickToElement(driver,startButton);
        }

    }

    public boolean isFileUploadMultipleFiles(String fileUpload) {
        waitForElementVisible(driver,UploadPageUIs.FILE_UPLOAD_BUTTON,fileUpload);
        return  isElementDisplay(driver,UploadPageUIs.FILE_UPLOAD_BUTTON,fileUpload);
    }
}
