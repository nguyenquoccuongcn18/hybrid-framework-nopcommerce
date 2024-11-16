package commons;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class dd {


    public class SauceLabsTest {

        public static void main(String[] args) {
            // Bảo mật: Lấy thông tin từ biến môi trường
            String username = System.getenv("SAUCE_USERNAME"); // Đặt biến môi trường này trong hệ thống của bạn
            String accessKey = System.getenv("SAUCE_ACCESS_KEY"); // Đặt biến môi trường này trong hệ thống của bạn
            String buildId = System.getenv("SAUCE_BUILD_ID"); // Có thể sử dụng một build ID tự động
            String testName = "Sauce Labs Test - Chrome";

            // Thiết lập các tùy chọn cho Chrome
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");

            // Thiết lập Sauce Labs options
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", username);
            sauceOptions.put("accessKey", accessKey);
            sauceOptions.put("build", buildId); // Dùng biến hoặc ID tự động
            sauceOptions.put("name", testName);
            browserOptions.setCapability("sauce:options", sauceOptions);

            // Khởi tạo RemoteWebDriver và bắt đầu phiên làm việc
            RemoteWebDriver driver = null;
            try {
                URL sauceURL = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(sauceURL, browserOptions);

                // Chạy các lệnh kiểm thử và xác nhận
                driver.get("https://saucedemo.com");
                String title = driver.getTitle();
                boolean titleIsCorrect = title.contains("Swag Labs");
                String jobStatus = titleIsCorrect ? "passed" : "failed";

                // Gửi kết quả công việc đến Sauce Labs
                driver.executeScript("sauce:job-result=" + jobStatus);

            } catch (Exception e) {
                // In ra lỗi nếu có sự cố trong quá trình kết nối hoặc thực thi
                System.out.println("Error occurred: " + e.getMessage());
                if (driver != null) {
                    try {
                        driver.executeScript("sauce:job-result=failed");
                    } catch (Exception ex) {
                        System.out.println("Failed to update job result in Sauce Labs.");
                    }
                }
            } finally {
                // Đảm bảo phiên làm việc được đóng lại
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }

}
