package jquery.table;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObjectjQuery;
import pageObjects.jquery.PageGeneratorManagerjQuery;

import java.util.ArrayList;
import java.util.List;


public class Level_13_Handle_DataTable extends BaseTest {
    private WebDriver driver;
    private HomePageObjectjQuery homePage;
    List<String> allValuesUI = new ArrayList<String>();
    List<String> allValuesDB = new ArrayList<String>();
    List<String> allValuesAPI = new ArrayList<String>();

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriver(browserName,url);
        homePage = PageGeneratorManagerjQuery.getHomePage(driver);
    }


    @Test
    public void TC_01_Search() {
        homePage.inputToColomnTextBoxByName("Females","283821");
        homePage.inputToColomnTextBoxByName("Country","Algeria");
        homePage.inputToColomnTextBoxByName("Males","295140");
        homePage.inputToColomnTextBoxByName("Total","578961");

    }
    @Test
    public void TC_02_PageToPage() {
        homePage.clickToPageByNumber("2");
        sleepInsecons(2);
        Assert.assertTrue(homePage.isPageByNumberActive("2"));
        homePage.clickToPageByNumber("1");


    }
    @Test
    public void TC_03_Displayed() {
        Assert.assertTrue(homePage.isRowValuesDisplay("283821","Algeria","295140","578961"));
        homePage.refreshCurrentPage(driver);
    }
    @Test
    public void TC_04_Icon_Button_Checkbox() {
        homePage.clickToRowActionByCountryName("Algeria","edit");
        homePage.clickClosePopup(driver);
        homePage.clickToRowActionByCountryName("Algeria","remove");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Albania","edit");
        homePage.clickClosePopup(driver);
        homePage.refreshCurrentPage(driver);
    }
    @Test
    public void TC_05_Get_All_Column_Values() {
//        //UI
//        allValuesUI = homePage.getAllPageValuesByColumnNumber("Country");
//        //API
//        allValuesAPI = homePage.getAllPageValuesByColumnNameInAPI("Country");
//
//        //DB
//        allValuesDB = homePage.getAllPageValuesByColumnNameInDB("Country");
//        Assert.assertEquals(allValuesUI,allValuesDB);
//
//
//        homePage.getAllPageValuesByColumnNumber("Males");
    }
    @Test(testName = "TC06")
    public void TC_06_Action_By_Index() {

        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        //Nhập dữ liệu textbox tại cột Contact Person dòng thứ 2
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","Dacwin - Nunez");
        //Select dữ liệu tại cột Country dòng thứ 3
        homePage.selectDropdownByColumnNameAndRowIndex("Country","3","United Kingdom");
        //Click vào checkbox tại cột NPO? dòng thứ 1
        homePage.clickCheckboxByColumnNameAndRowIndex("NPO?","1");
        homePage.clickCheckboxByColumnNameAndRowIndex("NPO?","3");
        homePage.clickCheckboxByColumnNameAndRowIndex("NPO?","2");
    }


    @AfterClass
    public void afterClass() {
//        closeBrowser();
    }
}



