package commons;

import java.io.File;

public class GlobalConstants {
    //Private static variables
    public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 60;
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD = "admin";
    public static final String OS_NAME = System.getProperty("user.dir");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = RELATIVE_PROJECT_PATH + File.separator+ "upload.txt" + File.separator;
    public static final String REPORTNG_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator+ "reportNGImage" + File.separator;
    public static final String SCREENSHOTS_FOLDER = OS_NAME + "/screenshots/";
    public static final String TEST_DATA_FOLDER = OS_NAME + "/src/test/resources/testData/";
    public static final String TEST_DATA_FILE = TEST_DATA_FOLDER + "data.xlsx";
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String ADMIN_ORGANGE_HRM_USERNAME = "automation";
    public static final String ADMIN_ORGANGE_HRM_PASSWORD = "Matkhau@123";
    public static final String USER_NAME_SAUCEDEMO = "standard_user";
    public static final String PASSWORD_SAUCEDEMO = "secret_sauce";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FIREFOX_DRIVER_PATH = PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "geckodriver.exe";
    public static final String CHROME_DRIVER_PATH = PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "chromedriver.exe";
    public static final String BROWSER_EXTENSIONS = PROJECT_PATH + File.separator + "browersExtension" + File.separator ;
    public static final String BROWSER_LOGS = PROJECT_PATH + File.separator + "browserLogs" + File.separator ;

    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String RESOURCES_PATH = RELATIVE_PROJECT_PATH + File.separator + "dataTest" + File.separator;
    public static final String DATA_TEST_PATH_EXCEL = RELATIVE_PROJECT_PATH + File.separator + "dataTest" + File.separator;
    public static final String ENVIRONMENT_CONFIG_PATH = RELATIVE_PROJECT_PATH + File.separator + "enviromentConfig" + File.separator;

    /**BrowserStack Config*/
    public static final String BROWSERSTACK_USERNAME = "quccng_wCZGKS";
    public static final String BROWSERSTACK_ACCESS_KEY = "LCq3izuaVySzPRp1c4qy";
    public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    /**SauceLabs Config*/
    public static final String SAUCELABS_USERNAME = "oauth-cuong01676234780-553d8";
    public static final String SAUCELABS_ACCESS_KEY = "b31bc60d-8e69-4357-bd53-d20400563625";
    public static final String SAUCELABS_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    /**BitBar Config*/
    public static final String BITBAR_ACCESS_KEY = "lwv0eKiY1TMOOHNW1LeWuhwNG8mhfCAS";
    public static final String BITBAR_URL = "https://eu-desktop-hub.bitbar.com/wd/hub";
}


