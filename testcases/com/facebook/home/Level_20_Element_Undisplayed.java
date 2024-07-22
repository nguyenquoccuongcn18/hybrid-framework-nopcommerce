package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Facebook.HomePageObjectFacebook;
import pageObjects.Facebook.PageGeneratorManagerFacebook;


public class Level_20_Element_Undisplayed extends BaseTest {

     WebDriver driver;
     WebDriverWait explicitWait;
     HomePageObjectFacebook homePage;




    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String urlValue) {
        driver= getBrowerDriver(browserName,urlValue);
        homePage = PageGeneratorManagerFacebook.getHomePage(driver);
    }


    @Test
    public void Home_01_Element_Displayed() {
        homePage.clickToNewAccountButton();

        verifyTrue(homePage.isFirstNameTextBoxDisplayed());
        verifyTrue(homePage.isSurnNameTextBoxDisplayed());
        verifyTrue(homePage.isEmailTextBoxDisplayed());
        verifyTrue(homePage.isPasswordTextBoxDisplayed());

        homePage.enterToEmailTextBox("");
        verifyTrue(homePage.isConfirmEmailTextBoxDisplayed());

    }
    @Test
    public void Home_02_Element_Undisplayed_In_HTML() {
        homePage.enterToEmailTextBox("");

        verifyTrue(homePage.isConfirmEmailTextBoxDisplayed());


    }
    @Test
    public void Home_03_Element_Undisplayed_Not_In_HTML() {
        homePage.clickToCloseSignUpPopup();

        verifyFalse(homePage.isFirstNameTextBoxDisplayed());
        verifyFalse(homePage.isSurnNameTextBoxDisplayed());
        verifyFalse(homePage.isEmailTextBoxDisplayed());
        verifyFalse(homePage.isPasswordTextBoxDisplayed());

    }
    @Test
    public void Home_03_Element_Undisplayed_Not_In_HTML_02() {
        homePage.clickToCloseSignUpPopup();

        verifyFalse(homePage.isFirstNameTextBoxUnDisplayed());
        verifyFalse(homePage.isSurnNameTextBoxUnDisplayed());
        verifyFalse(homePage.isEmailTextBoxUnDisplayed());
        verifyFalse(homePage.isPasswordTextBoxUnDisplayed());

    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



}
