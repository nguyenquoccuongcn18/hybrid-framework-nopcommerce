package com.facebook.home;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.grid.config.EnvConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.HomePageObject;


import java.lang.reflect.Method;

public class Level_32_GRID extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    EnvConfig envConfig;
    private String browserName, osName;

    @Parameters({"server", "browser", "url", "osName", "ipAddress", "port"})
    @BeforeClass
    public void beforeClass(String serverName, String browserName, String url, String osName, String ipAddress, String portNumber) {
        ConfigFactory.setProperty("server", serverName);
//        envConfig = ConfigFactory.create(envConfig.class);
        this.browserName = browserName;
        this.osName = osName;

        driver = getBrowserDriverGRID(browserName, url, osName, ipAddress, portNumber);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed(Method method) {

    }

    @Test
    public void User_01_Register_Validate(Method method) {
    }

    @Test
    public void User_02_Register_Success(Method method) {
    }

    @Test
    public void User_03_Login_Success(Method method) {
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}