package reportConfig;

import commons.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.sql.DriverManager;

public class AllureManager extends BaseTest {
        //Text attachments for Allure
        @Attachment(value = "{0}", type = "text/plain")
        public static String saveTextLog(String message) {
            return message;
        }

        //Screenshot attachments for Allure
        @Attachment(value = "Page screenshot", type = "image/png")
        public static byte[] saveScreenshotPNG() {
            return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        }


}
