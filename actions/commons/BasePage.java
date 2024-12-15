package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUserUIs.BaseElementUI;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage  {
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
        Duration timeout = Duration.ofMillis(longTimeout);
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
    public static void closeCurrentWindow(WebDriver driver){
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
    public By getByLocator(String loacatorValue){
        By by = null;
        if (loacatorValue.startsWith("xpath=")||loacatorValue.startsWith("Xpath=")||loacatorValue.startsWith("XPATH=")){
            by = By.xpath(loacatorValue.substring(6));
        }else if (loacatorValue.startsWith("id=")||loacatorValue.startsWith("Id=")||loacatorValue.startsWith("ID=")){
            by = By.id(loacatorValue.substring(6));
        }else if (loacatorValue.startsWith("name=")||loacatorValue.startsWith("Name=")||loacatorValue.startsWith("NAME=")){
            by = By.name(loacatorValue.substring(5));
        }else if (loacatorValue.startsWith("tagname=")||loacatorValue.startsWith("Tagname=")||loacatorValue.startsWith("TAGNAME=")) {
            by = By.tagName(loacatorValue.substring(8));
        }else if (loacatorValue.startsWith("class=")||loacatorValue.startsWith("Class=")||loacatorValue.startsWith("CLASS=")) {
            by = By.className(loacatorValue.substring(6));
        }else if (loacatorValue.startsWith("css=")||loacatorValue.startsWith("Css=")||loacatorValue.startsWith("CSS=")) {
            by = By.cssSelector(loacatorValue.substring(4));
        }else {
            throw new RuntimeException("Locator Type is not valid.");
        }
//        System.out.println(by);
        return by;

    }

    public By getByXpath(String loacator){
        return By.xpath(loacator);
    }
    public WebElement getWebElement(WebDriver driver, String loacator){
        return driver.findElement(getByLocator(loacator));
    }

    public List<WebElement> getListElement(WebDriver driver, String loacator){
        return driver.findElements(getByLocator(loacator));
    }
    public void clickToElement(WebDriver driver, String locator,String...restParams){
        hightlightElement(driver, locator);
        getWebElement(driver,getDynamicLocator(locator,restParams)).click();
    }
    public void clickToElement(WebDriver driver,WebElement element){
        element.click();
    }
    public boolean sendKeysToElement(WebDriver driver, String locator, String valueToSend, String...restParams){

        getWebElement(driver,getDynamicLocator(locator,restParams)).clear();
        hightlightElement(driver, locator);
        getWebElement(driver,getDynamicLocator(locator,restParams)).sendKeys(valueToSend);
        return false;
    }
    public String getDynamicLocator(String locator ,String ...restParams){
        return locator = String.format(locator,(Object[]) restParams);
    }

    public String getElementText(WebDriver driver, String locator){
        return getWebElement(driver,locator).getText();
    }
    public String getElementText(WebDriver driver, String locator,String...restParams){
        return getWebElement(driver,getDynamicLocator(locator,restParams)).getText();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue){
        //        Select select = new Select(getWebElement(driver,locator));
        //        select.selectByVisibleText(itemValue);
        // Nếu ko dùng nhiều lần NEW lên dùng luôn
        hightlightElement(driver, locator);
        new Select(getWebElement(driver,locator)).selectByVisibleText(itemValue);
    }
    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue,String ...restParam) {

        new Select(getWebElement(driver,getDynamicLocator(locator,restParam))).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver,String loator){
        return new Select(getWebElement(driver,loator)).getFirstSelectedOption().getText();
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String loator){
        return new Select(getWebElement(driver,loator)).isMultiple();
    }

    public void selectItemInDropdown(WebDriver driver, String parentLocator, String childItemLocator, String itemTextExpected) {
        getWebElement(driver, parentLocator).click();
        sleepInsecons(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            String textOfItem = item.getText();

            if (textOfItem.equals(itemTextExpected)) {
                System.out.println("Text item selected = " + textOfItem);
                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String locator,String AttributeName,String... restParams){
        return getWebElement(driver,getDynamicLocator(locator,restParams)).getAttribute(AttributeName);
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
    public List<WebElement> getListWebElement(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }
    public List<WebElement> getListWebElement(WebDriver driver, String locator,String... restParams){
        return driver.findElements(getByLocator(getDynamicLocator(locator,restParams)));
    }
    public int getListElementSize(WebDriver driver, String locator){
        return getListElement(driver, locator).size();
    }
    public int getListElementSize(WebDriver driver, String locator,String... restParams){
        return getListElement(driver, getDynamicLocator(locator,restParams)).size();
    }

    public void setImplicitWait(WebDriver driver, long timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    /*
     * Apply for checkbox and radio button
     * */
    public void checkToElement(WebDriver driver, String locator){
        if (!getWebElement(driver,locator).isSelected()){
            getWebElement(driver,locator).click();
        }
    }
    public void checkToElement(WebDriver driver, String locator,String ...restParams){
        if (!getWebElement(driver,getDynamicLocator(locator,restParams)).isSelected()){
            getWebElement(driver,getDynamicLocator(locator,restParams)).click();
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

    //Case 1: Element hiển thị và có trong html
    //Case 2: Element ko hiển thị và có trong html
    public boolean isElementDisplay(WebDriver driver, String locator,String...restParams){
        return getWebElement(driver,getDynamicLocator(locator,restParams)).isDisplayed();
    }
    public boolean isElementDisplayTrycatch(WebDriver driver, String locator){
        boolean status ;
        try{
            status = getWebElement(driver,locator).isDisplayed();
        } catch (NoSuchElementException e){
            status = false;
        }
        return status;
    }
    public boolean isElementUndisplay(WebDriver driver, String locator){
        setImplicitWait(driver,shortTimeout);
        List<WebElement> elements = getListWebElement(driver,locator);
        setImplicitWait(driver,longTimeout);

        if(elements.size() > 0 && elements.get(0).isDisplayed()){//Element có trên UI và có trong DOM ->false
            System.out.println("01 - Element có trên UI và có trong DOM ");
            return false;
        }else if(elements.size() == 1 && !elements.get(0).isDisplayed()){//Element ko có trên UI và có trong DOM
            System.out.println("02 - Element ko có trên UI và có trong DOM");
            return true;
        }else {
            System.out.println("03 - Element ko có trên UI và ko có trong DOM");
            return true;
        }
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getWebElement(driver,locator).isSelected();
    }
    public boolean isElementSelected(WebDriver driver, String locator,String... restparams){
        return getWebElement(driver,getDynamicLocator(locator,restparams)).isSelected();
    }
    public boolean isElementEnable(WebDriver driver, String locator){
        return getWebElement(driver,locator).isEnabled();
    }

    public void switchToIFrame(WebDriver driver, String locator){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
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
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 4px solid red; border-style: dashed;");
        sleepInsecons(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJSwebElement(WebDriver driver,String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getWebElement(driver,locator));
        sleepInsecons(3);
    }
    public void clickToElementByJSelement(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInsecons(3);
    }

    private Element getElement(WebDriver driver, String locator) {
        return (Element) driver.findElement(getByLocator(locator));
    }
    public boolean waitForListElementsInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void clickToElementByJS(WebDriver driver,String locator,String... restParameters) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getWebElement(driver,getDynamicLocator(locator,restParameters)));
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
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver,String locator,String...restParams){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator,restParams))));
    }
    public void waitForListElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getListElement(driver,locator)));
    }
    public void waitForListElementVisible(WebDriver driver,String locator,String...restParams){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getListElement(driver,getDynamicLocator(locator,restParams))));
    }

    public void waitForElementInvisible(WebDriver driver,String locator,String...restParams){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator,restParams))));
    }
    public boolean waitForElementInvisibleBoolean(WebDriver driver,String locator){
        return new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForListElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }
    public boolean waitForListElementInvisibleBoolean(WebDriver driver,String locator){
        return new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }
    public void waitForElementClickable(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,locator)));
    }
    public void waitForElementClickable(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementClickable(WebDriver driver,String locator,String...restParams){
        new WebDriverWait(driver,Duration.ofMillis(longTimeout)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver,getDynamicLocator(locator,restParams))));
    }
    public void uploadMultipleFiles(WebDriver driver,String...filesNames){
        String filePath = GlobalConstants.getGlobalConstants().getUploadPath();
        String fullFileName = "";
        for(String file : filesNames){
            fullFileName = fullFileName + filePath + file +"\n";
        }
        fullFileName=fullFileName.trim();
        getWebElement(driver, BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

    public long longTimeout = GlobalConstants.getGlobalConstants().getLongTimeout();
    public long shortTimeout = GlobalConstants.getGlobalConstants().getShortTimeout();

    public boolean isPageLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(this.driver,Duration.ofSeconds(longTimeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;


        //Điều kiện 1
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
        //Điều kiện 2
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad);
    }

}