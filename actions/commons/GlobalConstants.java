package commons;

import java.io.File;

public class GlobalConstants {

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
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FIREFOX_DRIVER_PATH = PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "geckodriver.exe";
    public static final String CHROME_DRIVER_PATH = PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "chromedriver.exe";
    public static final String BROWSER_EXTENSIONS = PROJECT_PATH + File.separator + "browersExtension" + File.separator ;
    public static final String BROWSER_LOGS = PROJECT_PATH + File.separator + "browserLogs" + File.separator ;

    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
}
