package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Level_02_BasePage_03_Inheritance extends BasePage {

    private WebDriver driver;
     WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void Register_01_Empty_Data() {
        openPageUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons(3);

        clickToElement(driver,"//button[@id='register-button']");
        sleepInsecons(3);
        Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        openPageUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver,"//a[@class='ico-register']");
//l11
        sendKeysToElement(driver,"//input[@id='FirstName']", "antony");
        sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        sendKeysToElement(driver,"//input[@id='Email']", "compa@atony@1gmail.com");
        sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "12345678");
        clickToElement(driver,"//button[@id='register-button']");
//a1
        //Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"), "Wrong email");

    }

    @Test
    public void Register_03_Invalid_Password() {
        openPageUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons (3);

        sendKeysToElement(driver,"//input[@id='FirstName']", "antony");
        sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        sendKeysToElement(driver,"//input[@id='Email']", "compa@atony@1gmail.com");
        sendKeysToElement(driver,"//input[@id='Password']", "123");
        sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "123");
        sleepInsecons (3);

        clickToElement(driver,"//button[@id='register-button']");
        sleepInsecons (3);
        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"), "Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters");

    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        openPageUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons (3);
        sendKeysToElement(driver,"//input[@id='FirstName']", "antony");
        sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        sendKeysToElement(driver,"//input[@id='Email']", "compaatony@gmail.com");
        sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "1234567");


        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        openPageUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons (3);
        sendKeysToElement(driver,"//input[@id='FirstName']", "Atony");
        sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        sendKeysToElement(driver,"//input[@id='Email']", "compaatony@gmail.com");
        sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "12345678");

        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//div[@class='result']"), "Your registration completed");


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
