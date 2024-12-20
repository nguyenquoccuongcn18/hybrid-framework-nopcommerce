package commons;

import lombok.Getter;

import java.io.File;
@Getter
public class GlobalConstants {
    private static GlobalConstants globalInstance;
    private GlobalConstants() {

    }
    public static synchronized GlobalConstants getGlobalConstants(){
        if(globalInstance == null){
            globalInstance = new GlobalConstants();
        }return globalInstance;
    }
    private final String devUserUrl = "https://demo.nopcommerce.com/";
    private final String devAdminUrl = "https://admin-demo.nopcommerce.com/";
    private final long shortTimeout = 5;
    private final long longTimeout = 60;
    private final String devAdminUsername = "admin@yourstore.com";
    private final String devAdminPassword = "admin";
    private final String OS_NAME = System.getProperty("user.dir");
    private final String relativeProjectPath = System.getProperty("user.dir");
    private final String uploadPath = relativeProjectPath + File.separator + "uploadFiles" + File.separator;
    private final String downloadFile = relativeProjectPath + File.separator+ "upload.txt" + File.separator;
    private final String reportngImagePath = relativeProjectPath + File.separator+ "reportNGImage" + File.separator;
    private final String screenshotsFolder = OS_NAME + "/screenshots/";
    private final String TEST_DATA_FOLDER = OS_NAME + "/src/test/resources/testData/";
    private final String testDataFile = TEST_DATA_FOLDER + "data.xlsx";
    private final String javaVersion = System.getProperty("java.version");
    private final String adminOrgangeHrmUsernameLive = "Admin";
    private final String adminOrgangeHrmPasswordLive = "admin123";
    private final String adminOrgangeHrmUsernameLocal = "automation";
    private final String adminOrgangeHrmPasswordLocal = "Matkhau@123";
    private final String userNameSaucedemo = "standard_user";
    private final String passwordSaucedemo = "secret_sauce";
    private final String PROJECT_PATH = System.getProperty("user.dir");
    private final String firefoxDriverPath = PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "geckodriver.exe";
    private final String chromeDriverPath = PROJECT_PATH + File.separator + "browserDrivers" + File.separator + "chromedriver.exe";
    private final String browserExtensions = PROJECT_PATH + File.separator + "browersExtension" + File.separator ;
    private final String browserLogs = PROJECT_PATH + File.separator + "browserLogs" + File.separator ;

    private final String downloadPath = relativeProjectPath + File.separator + "downloadFiles" + File.separator;
    private final String resourcesPath = relativeProjectPath + File.separator + "dataTest" + File.separator;
    private final String dataTestPathExcel = relativeProjectPath + File.separator + "dataTest" + File.separator;
    private final String environmentConfigPath = relativeProjectPath + File.separator + "enviromentConfig" + File.separator;

    /**BrowserStack Config*/
    private final String BROWSERSTACK_USERNAME = "quccng_wCZGKS";
    private final String BROWSERSTACK_ACCESS_KEY = "LCq3izuaVySzPRp1c4qy";
    private final String browserstackUrl = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    /**SauceLabs Config*/
    private final String saucelabsUsername = "oauth-cuong01676234780-553d8";
    private final String saucelabsAccessKey = "b31bc60d-8e69-4357-bd53-d20400563625";
    private final String saucelabsUrl = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    /**BitBar Config*/
    private final String bitbarAccessKey = "lwv0eKiY1TMOOHNW1LeWuhwNG8mhfCAS";
    private final String bitbarUrl = "https://eu-desktop-hub.bitbar.com/wd/hub";

    private final String lambdaUsername = "cuong01676234780";
    private final String lambdaAccessKey = "fmq74vlVPidGeORDPxhqWbVO1dd1Uvr3j9n9TWJ8jTZnijaMm0";
//    public static final String LAMBDA_URL = "https://hub.lambdatest.com/wd/hub";
    private final String lambdaUrl = "https://" + lambdaUsername + ":" + lambdaAccessKey + "@hub.lambdatest.com/wd/hub";


    private final String accessTokenLine = "0EHm9nsAloymhxYP4N1YU44jggnBOpGdUxGgSgjk9BB";
    public static final String LINE_NOTIFY_API_URL = "https://notify-api.line.me/api/notify";
    public static final String message = "Hi thông báo từ LINE Notify API.";



}


