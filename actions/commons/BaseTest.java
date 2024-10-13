package commons;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

    protected String getEmailRandoms(String email){
        Random rand = new Random();
        return "JohnSmith" + rand.nextInt(1000) + "@gmail.com";
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
    protected WebDriver getBrowserDriverWithLogs(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX:
                // Log to file
//                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOGS + "FirefoxDriver.log")).build();

                // Log to Console
                //FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogOutput(System.out).build();

                // Log to Level
                System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOGS + "FirefoxLevel.log");
                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogLevel(FirefoxDriverLogLevel.DEBUG).build();

                driver = new FirefoxDriver(ffService);
                break;
            case CHROME:
                // Log to file
                //ChromeDriverService chService = new ChromeDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOGS + "ChromeDriver.log")).build();

                // Log to Console
                //ChromeDriverService chService = new ChromeDriverService.Builder().withLogOutput(System.out).build();

                // Log to Level
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOGS + "ChromeLevel.log");
                ChromeDriverService chService = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();

                driver = new ChromeDriver(chService);
                break;
            case EDGE:
                // Log to file
                //EdgeDriverService edgeService = new EdgeDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOGS + "EdgeDriver.log")).build();

                // Log to Console
                //EdgeDriverService edgeService = new EdgeDriverService.Builder().withLogOutput(System.out).build();

                // Log to Level
                System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOGS + "EdgeLevel.log");
                EdgeDriverService edgeService = new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();

                driver = new EdgeDriver(edgeService);
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
    protected WebDriver getBrowserDriverCapabilities(String browserName, String url) {
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
                FirefoxOptions ffOptions = new FirefoxOptions();

           //Config tải file không hiển thị dowload mà tự động lưu về máy luôn
//                ffOptions.addPreference("browser.download.folderList", 2);
//                ffOptions.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_PATH + "\\downloadFiles");
//                ffOptions.addPreference("browser.download.useDownloadDir", true);
//                ffOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
//                        "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png,image/jpeg,application/pdf,text/html,text/plain,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/octet-stream");
//                ffOptions.addPreference("pdfjs.disabled", true);


                ffOptions.addPreference("intl.accept_languages", "vi-vn,vi");
                ffOptions.addArguments("--private"); // Run on an danh mode

                driver = new FirefoxDriver(ffOptions);
                break;
            case CHROME:
                Map<String, Object> chPrefs = new HashMap<String, Object>();
                chPrefs.put("profile.default_content_setting_values.notifications", 2); // Tat luu address
                chPrefs.put("credentials_enable_service", false);
                chPrefs.put("profile.password_manager_enabled", false); // Tat luu password
                chPrefs.put("autofill.profile_enabled", false); // Tat autofill suggestion
                chPrefs.put("autofill.credit_card_enable", false); // Tat save CARD info

                // Download file KHONG hien download dialog khi bam nut down
                chPrefs.put("profile.default_content_settings.popups", 0);
                chPrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

                ChromeOptions chOptions = new ChromeOptions();

                chOptions.addArguments("--lang=vi");
                chOptions.addArguments("--disable-notifications"); // tat thong bao
                chOptions.addArguments("--disable-geolocation"); // tat thong bao dinh vi vi tri
                //chOptions.addArguments("--incognito"); // Run on an danh mode

                // Run with Profile
//                chOptions.addArguments("user-data-dir= C:\\Users\\THIS PC\\AppData\\Local\\Google\\Chrome\\User Data");
//                chOptions.addArguments("profile-directory=Profile 4");

                // tat thong bao trinh duyet đang chạy là automation
                chOptions.setExperimentalOption("useAutomationExtension", false);
                chOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

                chOptions.setExperimentalOption("prefs", chPrefs); // Tat cac thong bao config o tren

                driver = new ChromeDriver(chOptions);
                break;
            case EDGE:
                Map<String, Object> edgePrefs = new HashMap<String, Object>();
                edgePrefs.put("profile.default_content_setting_values.notifications", 2); // Tat luu address
                edgePrefs.put("credentials_enable_service", false);
                edgePrefs.put("profile.password_manager_enabled", false); // Tat luu password
                edgePrefs.put("autofill.profile_enabled", false); // Tat autofill suggestion
                edgePrefs.put("autofill.credit_card_enable", false); // Tắt save CARD info

                // Download file KHONG hien download dialog khi bam nút down
                edgePrefs.put("profile.default_content_settings.popups", 0);
                edgePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=fr");
                edgeOptions.addArguments("--disable-notifications"); // tat thong bao
                edgeOptions.addArguments("--disable-geolocation"); // tat thong bao dinh vi vi tri
                edgeOptions.addArguments("--inprivate"); // Run on an danh mode

                // tat thong bao trinh duyet dang chay o auto mode
                edgeOptions.setExperimentalOption("useAutomationExtension", false);
                edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

                edgeOptions.setExperimentalOption("prefs", edgePrefs); // Tat cac thong bao config o tren

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
