package jquery.uploads;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.PageGeneratorManagerjQuery;
import pageObjects.jquery.UploadPageObjects;


public class Level_14_Upload_Files extends BaseTest {
    private WebDriver driver;
     UploadPageObjects upLoadPage;
     String food1 = "food1.jpg";
    String food2 = "food2.jpg";
    String food3 = "food3.jpg";

    String[] fileNames = {food1, food2, food3};

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriver(browserName,url);
        upLoadPage = PageGeneratorManagerjQuery.getUploadPage(driver);
    }


    @Test
    public void TC_01_Upload_Single_File() {
        upLoadPage.uploadMultipleFiles(driver,food1);
        upLoadPage.sleepInsecons(2);
        upLoadPage.uploadMultipleFiles(driver,food2);
        upLoadPage.sleepInsecons(2);
        upLoadPage.uploadMultipleFiles(driver,food3);
        upLoadPage.sleepInsecons(2);

        Assert.assertTrue(upLoadPage.isFilesLoadSucces(food1));
        Assert.assertTrue(upLoadPage.isFilesLoadSucces(food2));
        Assert.assertTrue(upLoadPage.isFilesLoadSucces(food3));

        upLoadPage.clickStartButtonOnEchFile();

        Assert.assertTrue(upLoadPage.isFileUploadMultipleFiles(food1));
        Assert.assertTrue(upLoadPage.isFileUploadMultipleFiles(food2));
        Assert.assertTrue(upLoadPage.isFileUploadMultipleFiles(food3));



    }
    @Test
    public void TC_02_Upload_Multiple_File() {
        upLoadPage.refreshCurrentPage(driver);
        upLoadPage.uploadMultipleFiles(driver,fileNames);
        upLoadPage.sleepInsecons(2);

        Assert.assertTrue(upLoadPage.isFilesLoadSucces(food1));
        Assert.assertTrue(upLoadPage.isFilesLoadSucces(food2));
        Assert.assertTrue(upLoadPage.isFilesLoadSucces(food3));

        upLoadPage.clickStartButtonOnEchFile();

        Assert.assertTrue(upLoadPage.isFileUploadMultipleFiles(food1));
        Assert.assertTrue(upLoadPage.isFileUploadMultipleFiles(food2));
        Assert.assertTrue(upLoadPage.isFileUploadMultipleFiles(food3));


    }
    @Test
    public void TC_03_Displayed() {

    }



    @AfterClass
    public void afterClass() {
//        closeBrowser();
    }
}



