package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

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
        return "John Smith" + rand.nextInt(100) + "@gmail.com";
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
    protected void closeBrowser(){
        driver.quit();
    }
}
