package commons;

import java.io.File;

public class GlobalConstants {
    public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD = "admin";
    public static final String OS_NAME = System.getProperty("user.dir");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = RELATIVE_PROJECT_PATH + File.separator+ "upload.txt" + File.separator;

    public static final String SCREENSHOTS_FOLDER = OS_NAME + "/screenshots/";
    public static final String TEST_DATA_FOLDER = OS_NAME + "/src/test/resources/testData/";
    public static final String TEST_DATA_FILE = TEST_DATA_FOLDER + "data.xlsx";

}
