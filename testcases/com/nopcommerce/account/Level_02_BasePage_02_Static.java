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

import static commons.BasePage.getBasePage;

//Không khởi tạo trực tiếp đối tượng trên class Test
//Nên che dấu và ẩn dấu nó đi tính đóng gói
public class Level_02_BasePage_02_Static  {

    private WebDriver driver;
     WebDriverWait explicitWait;

     //Đóng gói BasePage không cần khởi tạo
    private BasePage basePage = getBasePage();

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void Register_01_Empty_Data() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons(3);

        basePage.clickToElement(driver,"//button[@id='register-button']");
        sleepInsecons(3);
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
//l11
        basePage.sendKeysToElement(driver,"//input[@id='FirstName']", "antony");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", "compa@atony@1gmail.com");
        basePage.sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "12345678");
        basePage.clickToElement(driver,"//button[@id='register-button']");
//a1
        //Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"), "Wrong email");

    }

    @Test
    public void Register_03_Invalid_Password() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons (3);

        basePage.sendKeysToElement(driver,"//input[@id='FirstName']", "antony");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", "compa@atony@1gmail.com");
        basePage.sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "12345678");
        sleepInsecons (3);

        basePage.clickToElement(driver,"//button[@id='register-button']");
        sleepInsecons (3);
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Please enter a valid email address.");

    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons (3);
        basePage.sendKeysToElement(driver,"//input[@id='FirstName']", "antony");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", "compaatony@gmail.com");
        basePage.sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "1234567");


        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        sleepInsecons (3);
        basePage.sendKeysToElement(driver,"//input[@id='FirstName']", "Atony");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']", "Compa");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", "compaatony@gmail.com");
        basePage.sendKeysToElement(driver,"//input[@id='Password']", "12345678");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']", "12345678");

        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"), "Your registration completed");


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
