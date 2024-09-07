package commons;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    private Logger log;
    private String browserName;
    private String url;
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
        this.browserName = browserName;
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
//        driver.get("https://demo.nopcommerce.com/");
//        driver.get(url);
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

    protected WebDriver getBrowserNameHeadLess(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        /*
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

        /* Enum
        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME) {
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

    /*
        // Selenium 3.x
        switch (browser) {
            case FIREFOX:
                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

    /*
        // WebDriverManager - Selenium 3.x
        switch (browser) {
            case FIREFOX:
                // WebDriverManager 4.x/5.x (cung dung duoc): Download driver + setting bien moi truong
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                // WebDriverManager 5.x: Download driver + setting bien moi truong + Khoi tao browser
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX_HEADLESS:
                FirefoxOptions ffHeadlessOptions = new FirefoxOptions();
                ffHeadlessOptions.addArguments("--headless");
                ffHeadlessOptions.addArguments("window-size=1360x768");
                driver = new FirefoxDriver(ffHeadlessOptions);
                break;
            case CHROME_HEADLESS:
                ChromeOptions chHeadlessOptions = new ChromeOptions();
                chHeadlessOptions.addArguments("--headless");
                chHeadlessOptions.addArguments("window-size=1360x768");
                driver = new ChromeDriver(chHeadlessOptions);
                break;
            case EDGE_HEADLESS:
                EdgeOptions edgeHeadlessOptions = new EdgeOptions();
                edgeHeadlessOptions.addArguments("--headless");
                edgeHeadlessOptions.addArguments("window-size=1360x768");
                driver = new EdgeDriver(edgeHeadlessOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get("http://localhost:90/orangehrm");

        return driver;
    }
    protected WebDriver getBrowserDriverWithExtensions(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        Path path = null;
        File extensionFilePath = null;
        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX_EXTENSION:
                // options 1: selenium v3
                /*FirefoxProfile profile = new FirefoxProfile();
                File ffFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer-6.10.70.xpi");
                profile.addExtension(ffFile);
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setProfile(profile);
                driver = new FirefoxDriver(ffOptions);*/

                // options 2: selenium v4
                driver = new FirefoxDriver();
                Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.xpi");
                FirefoxDriver ffDriver = (FirefoxDriver) driver;
                ffDriver.installExtension(xpiPath);
                driver = ffDriver;

                break;
            case CHROME_EXTENSION:
                // options 1: selenium v3
                /*File chromeFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                ChromeOptions chOptions = new ChromeOptions();
                chOptions.addExtensions(chromeFile);
                driver = new ChromeDriver(chOptions);*/

                // options 2: selenium v4
                ChromeOptions chOptions = new ChromeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSIONS +"Wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                chOptions.addExtensions(extensionFilePath);
                driver = new ChromeDriver(chOptions);
                break;
            case EDGE_EXTENSION:
                // options 1: selenium v3
                /*File edgeFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addExtensions(edgeFile);
                driver = new EdgeDriver(edgeOptions);*/

                // options 2: selenium v4
                EdgeOptions edgeOptions = new EdgeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                edgeOptions.addExtensions(extensionFilePath);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);
        return driver;
    }

    protected boolean verifyTrue (boolean condition) {
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
