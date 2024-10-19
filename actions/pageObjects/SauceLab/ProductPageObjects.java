package pageObjects.SauceLab;

import orangehrmPageObjects.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.SauceLab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPageObjects extends BaseActions {
    WebDriver driver ;
    public ProductPageObjects(WebDriver driver) {
        this.driver = driver;
    }


    public void selectItemInSortDropdown(String sortItem) {
        waitForElementClickable(driver, ProductPageUI.SORT_ITEM);
        selectItemInDefaultDropdown(driver,ProductPageUI.SORT_ITEM,sortItem);
        sleepInsecons(3);
        System.out.println(sortItem);
    }

    public boolean isProductByNameSortAscendingASC() {
//        B1: Lấy hết productname lưu lại
           List<WebElement> allProductNameText = getListWebElement(driver,ProductPageUI.PRODUCT_NAME_TEXT);

           List<String> actualProductNameText = new ArrayList<String>();
           for (WebElement productName : allProductNameText) {
               actualProductNameText.add(productName.getText());  //chạy for xong có dữ liệu 6 text trong này
           }
           logArrayListString(actualProductNameText);

//        B2: Sắp xếp dữ liệu tăng dần
        List<String> expectedProductNameText = new ArrayList<String>();
        for (String name : actualProductNameText) {
            expectedProductNameText.add(name);
        }

//        B3: Cho sort dữ liêu ở B2
        Collections.sort(expectedProductNameText);
            //Default:ASC
            //Reverse:DESC
        logArrayListString(expectedProductNameText);

//        B4: verify dữ liệu trước và sau khi sort có giống nhau ko
        return actualProductNameText.equals(expectedProductNameText);
    }

    public boolean isProductByNameSortDescendingDESC() {
        //        B1: Lấy hết productname lưu lại
        List<WebElement> allProductNameText = getListWebElement(driver,ProductPageUI.PRODUCT_NAME_TEXT);

        List<String> actualProductNameText = new ArrayList<String>();
        for (WebElement productName : allProductNameText) {
            actualProductNameText.add(productName.getText());  //chạy for xong có dữ liệu 6 text trong này
        }
        logArrayListString(actualProductNameText);


//        B2: Sắp xếp dữ liệu tăng dần
        List<String> expectedProductNameText = new ArrayList<String>();
        for (String name : actualProductNameText) {
            expectedProductNameText.add(name);
        }
//        B3: Cho sort dữ liêu ở B2
        Collections.sort(expectedProductNameText);
        logArrayListString(expectedProductNameText);

        Collections.reverse(expectedProductNameText);//Đang là ESC dùng reverse sẽ thành  DESC
        logArrayListString(expectedProductNameText);

        //Default:ASC
        //Reverse:DESC


//        B4: verify dữ liệu trước và sau khi sort có giống nhau ko
        return actualProductNameText.equals(expectedProductNameText);
    }

    public void logArrayListString(List<String> products){
        System.out.println("================================================================");
        for (String product : products) {
            System.out.println(product);
        }
        System.out.println("================================================================");
    }

    public boolean isProductByPriceSortAscendingASC() {
        List<WebElement> allProductPrice = getListWebElement(driver,ProductPageUI.PRODUCT_PRICE_TEXT);

        List<Float> actualProductPriceText = new ArrayList<Float>();
        for (WebElement productPrice : allProductPrice) {
            actualProductPriceText.add(Float.parseFloat(productPrice.getText().replace("$"," ")));  // replace $ sang rỗng để order
        }
        logArrayListFloat(actualProductPriceText);

        List<Float> expectedPriceNameText = new ArrayList<Float>();
        for (Float name : actualProductPriceText) {
            expectedPriceNameText.add(name);
        }

        Collections.sort(expectedPriceNameText);
        logArrayListFloat(expectedPriceNameText);

        return actualProductPriceText.equals(expectedPriceNameText);
    }

    public boolean isProductByPriceSortDescendingDESC() {
        List<WebElement> allProductPrice = getListWebElement(driver,ProductPageUI.PRODUCT_PRICE_TEXT);

        List<Float> actualProductPriceText = new ArrayList<Float>();
        for (WebElement priceName : allProductPrice) {
            actualProductPriceText.add(Float.parseFloat(priceName.getText().replace("$"," ")));
        }
        logArrayListFloat(actualProductPriceText);


        List<Float> expectedProductPriceText = new ArrayList<Float>();
        for (Float name : actualProductPriceText) {
            expectedProductPriceText.add(name);
        }

        Collections.sort(expectedProductPriceText);
        logArrayListFloat(expectedProductPriceText);

        Collections.reverse(expectedProductPriceText);
        logArrayListFloat(expectedProductPriceText);

        return actualProductPriceText.equals(expectedProductPriceText);
    }
    public void logArrayListFloat(List<Float> products){
        System.out.println("================================================================");
        for (Float product : products) {
            System.out.println(product);
        }
        System.out.println("================================================================");
    }
    public boolean isProductByPriceSortJaveStreamApiDESC() {
        List<WebElement> allProductPrice = getListWebElement(driver,ProductPageUI.PRODUCT_PRICE_TEXT);

        List<Float> actualProductPriceText = toString(allProductPrice.stream().map(n -> n.getText()).collect(Collectors.toList()));
        List<Float> expectedProductPriceText = new ArrayList<Float>();


        Collections.sort(expectedProductPriceText);
        logArrayListFloat(expectedProductPriceText);

        Collections.reverse(expectedProductPriceText);
        logArrayListFloat(expectedProductPriceText);

        return actualProductPriceText.equals(expectedProductPriceText);
    }

    private List<Float> toString(List<String> collect) {
        List<Float> floatList = new ArrayList<>();
        for (String s : collect) {
            floatList.add(Float.parseFloat(s.replace("$", " ")));
        }
        return floatList;
    }
}
