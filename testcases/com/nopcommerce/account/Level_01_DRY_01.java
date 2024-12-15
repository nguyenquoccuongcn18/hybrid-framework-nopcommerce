package account;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//Vi phạm nguyên tắc DRY
public class Level_01_DRY_01 {

     WebDriver driver;
     WebDriverWait explicitWait;
    private BasePage basePage;



    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://demo.nopcommerce.com/");
        sleepInsecons(3);
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),"First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),"Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),"Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();
//l11
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Atony");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Compa");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("compa@atony@1gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345678");

        driver.findElement(By.cssSelector("button#register-button")).click();
//a1
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Wrong email");


    }

    @Test
    public void Register_03_Invalid_Password() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();
        sleepInsecons (3);

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Atony");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Compa");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("compaatony@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Password")).getText(),
                "Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters");

    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Atony");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Compa");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("compaatony@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1234567");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),"The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Atony");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Compa");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("compaatony@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345678");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    public void sleepInsecons(long timeInsecons) {
        try {
            Thread.sleep(timeInsecons * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
