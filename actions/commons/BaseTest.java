package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    private Logger log;
//    protected final Logger log;
//    protected final Log log;

    public static WebDriver getDriver() {
        return driver;
    }


    protected static WebDriver driver;

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-results");
    }
    public void deleteAllFileInFolder(String folderName){
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

//    public BaseTest() {
//        log = LogFactory.getLog(getClass());
//    }

//    public BaseTest() {
//        log = LogManager.getLogger(getClass());
//    }


    protected WebDriver getBrowerDriver(String browserName){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.CHROME){
//            //tự tải về + settings
//            FirefoxDriver.SystemProperty (WebDriver driver , " ");

            //WebDriverManager: tải về driver + settings biến môi trường và khởi tạo browser lên
            driver = WebDriverManager.chromedriver().create();

//            //Selenium manager
//            driver = new FirefoxDriver();
        }
        else if(browser == BrowserList.FIREFOX){
            driver = WebDriverManager.firefoxdriver().create();
        }   else if(browser == BrowserList.EDGE){
            driver = WebDriverManager.edgedriver().create();
        }else {
            throw new RuntimeException("Lỗi không mở được trình duyệt");
        }
//        //vị trí browser
//        driver.manage().window().setPosition(new Point(0,0));
//        //kích thước màn hình
//        driver.manage().window().setSize(new Point(1920, 1080));
//        //mở trang web
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.get("https://demo.nopcommerce.com/");
        return driver;
    }


    protected String getEmailRandom(){
        Random rand = new Random();
        return "JohnSmith" + rand.nextInt(1000) + "@gmail.com";
    }
    protected void sleepInsecons(long timeInsecons) {
        try {
            Thread.sleep(timeInsecons * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected WebDriver getBrowerDriverAdminEndUser(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.CHROME){
            driver = WebDriverManager.chromedriver().create();
        }
        else if(browser == BrowserList.FIREFOX){
            driver = WebDriverManager.firefoxdriver().create();
        }   else if(browser == BrowserList.EDGE){
            driver = WebDriverManager.edgedriver().create();
        }else {
            throw new RuntimeException("Lỗi không mở được trình duyệt");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.get(url);
        return driver;
    }
    protected WebDriver getBrowerDriver(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.CHROME){
            driver = WebDriverManager.chromedriver().create();
        }
        else if(browser == BrowserList.FIREFOX){
            driver = WebDriverManager.firefoxdriver().create();
        }   else if(browser == BrowserList.EDGE){
            driver = WebDriverManager.edgedriver().create();
        }else {
            throw new RuntimeException("Lỗi không mở được trình duyệt");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.get(url);
        return driver;
    }
    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
//            log.info("--------------PASSED--------------");
        } catch (Throwable e) {
//            log.info("--------------FAILED--------------");
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertFalse(condition);
//            log.info("--------------PASSED--------------");
        } catch (Throwable e) {
//            log.info("--------------FAILED--------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
//            log.info("--------------PASSED--------------");
        } catch (Throwable e) {
//            log.info("--------------FAILED--------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected void closeBrowser(){
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
    //

    protected void closeBrowserCloseTaskManger(){
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
