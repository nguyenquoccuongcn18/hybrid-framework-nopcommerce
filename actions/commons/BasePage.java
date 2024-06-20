package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    //05/06/2024 - 63 hàm
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

    //Không cần phải khởi tạo đối tượng mà vẫn truy cập được hàm BasPage
    //
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


    /*Web Element*/
    //Viêt lặp lại thành hàm mới

    public By getByXpath(String loacator){
        return By.xpath(loacator);
    }
    public WebElement getWebElement(WebDriver driver, String loacator){
        return driver.findElement(getByXpath(loacator));
    }

    public List<WebElement> getListElement(WebDriver driver, String loacator){
        return driver.findElements(getByXpath(loacator));
    }
    public void clickToElement(WebDriver driver, String locator){
        getWebElement(driver,locator).click();
    }
    public void sendKeysToElement(WebDriver driver, String locator, String valueToSend){
        getWebElement(driver,locator).clear();
        getWebElement(driver,locator).sendKeys(valueToSend);
    }

    public String getElementText(WebDriver driver, String locator){
        return getWebElement(driver,locator).getText();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue){
    //        Select select = new Select(getWebElement(driver,locator));
    //        select.selectByVisibleText(itemValue);
    // Nếu ko dùng nhiều lần NEW lên dùng luôn
        new Select(getWebElement(driver,locator)).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver,String loator){
        return new Select(getWebElement(driver,loator)).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String loator){
       return new Select(getWebElement(driver,loator)).isMultiple();
    }

    public void SelectItemDropdown (WebDriver driver,String parrentLocator, String ChilLocator ,String ItemTextExpected){
        getWebElement(driver,parrentLocator);
        sleepInsecons(3);
        List<WebElement> AllItems =new WebDriverWait(driver,Duration.ofMillis(300)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(ChilLocator)));;
        for (WebElement item : AllItems){
            if (item.getText().equals(ItemTextExpected)){
                item.click();
                break;
            }
        }

    }

    public String getElementAttribute(WebDriver driver, String locator,String AttributeName){
        return getWebElement(driver,locator).getAttribute(AttributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator,String CssPropertyName){
        return getWebElement(driver,locator).getCssValue(CssPropertyName);
    }

    public String convertRGBAToHexaColor(WebDriver driver, String locator){
//        String backgroundColorRGBA=getElementCssValue(driver, locator,"background-color");
//        return Color.fromString(backgroundColorRGBA).asHex();
        //Viết gọn lại
        return Color.fromString(getElementCssValue(driver, locator,"background-color")).asHex();
    }

    //Hàm này getListWebElement
    public int getListElementSize(WebDriver driver, String locator){
        return getListElement(driver, locator).size();
    }




/*
* Apply for checkbox and radio button
* */
    public void checkToElement(WebDriver driver, String locator){
        if (!getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }
    /*
     * Only Apply for checkbox
     * */
    public void unCheckToElement(WebDriver driver, String locator){
        if (getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locator){
        return getWebElement(driver,locator).isDisplayed();
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getWebElement(driver,locator).isSelected();
    }
    public boolean isElementEnable(WebDriver driver, String locator){
        return getWebElement(driver,locator).isEnabled();
    }

    public void switchToIFrame(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofMillis(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXpath(locator)));
        driver.switchTo().frame(getWebElement(driver,locator));
    }

    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        Actions action = new Actions(driver);
        action.doubleClick(getWebElement(driver,locator)).perform();
    }
    public void hoverToElement(WebDriver driver, String locator){
         new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }
    public void dragAndDropElement(WebDriver driver, String sourceLocator , String targetLocator){
        new Actions(driver).dragAndDrop(getWebElement(driver,sourceLocator),getWebElement(driver,targetLocator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getWebElement(driver,locator),key).perform();
    }

    //
    public Object executeForBrowser(String javaScript) {
        return ((JavascriptExecutor)driver).executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) ((JavascriptExecutor)driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) ((JavascriptExecutor)driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        ((JavascriptExecutor)driver).executeScript("window.location = '" + url + "'");
        sleepInsecons(3);
    }

    public void hightlightElement(WebDriver driver,String locator) {
        WebElement element = getWebElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInsecons(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getWebElement(driver,locator));
        sleepInsecons(3);
    }

    public void scrollToElementOnTop(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,locator));
    }

    public void scrollToElementOnDown(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,locator));
    }

    public void setAttributeInDOM(WebDriver driver,String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getWebElement(driver,locator));
    }

    public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver,locator));
    }

    public void sendkeyToElementByJS(WebDriver driver,String locator, String value) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver,locator));
    }

    public String getAttributeInDOM(WebDriver driver,String locator, String attributeName) {
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
        boolean status = (boolean) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver,locator));
        return status;
    }

    //Wait
    public void waitForElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(3)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForListElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(3)).until(ExpectedConditions.visibilityOfAllElements(getListElement(driver,locator)));
    }
    public void waitForElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(3)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForListElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(3)).until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }
    public void waitForElementClickable(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,locator)));
    }



}
