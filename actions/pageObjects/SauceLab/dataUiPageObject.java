package pageObjects.SauceLab;

import SaucedemoUI.SaucedemoUI;
import orangehrmPageObjects.BaseActions;
import org.openqa.selenium.WebDriver;
import utilities.MySQLTestConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dataUiPageObject extends BaseActions {
    WebDriver driver;
    public dataUiPageObject(WebDriver driver){
        this.driver = driver;
    }
    public int getDataUiSauceLabUI(){
        waitForElementVisible(driver,SaucedemoUI.ITEM_NAME);
        String totalNumber = getElementText(driver,SaucedemoUI.ITEM_NAME);
        return Integer.parseInt(totalNumber.split(" ")[0]);
    }
    public String getDataUiSauceLabUIV2(){
        waitForElementVisible(driver, SaucedemoUI.ITEM_NAME);
        String totalNumber = getElementText(driver, SaucedemoUI.ITEM_NAME);
        return totalNumber; // Return the part before the first space as a String
    }
    public int getDataUiSauceLabDB() throws SQLException, ClassNotFoundException {
        Connection conn = MySQLTestConnection.getMyConnection();
        Statement statement;
        List<Integer> totalUsers = new ArrayList<>();
        try {
            statement = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM saucedemo.inventory";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                totalUsers.add(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {if (conn != null) {
                conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return totalUsers.size();
    }

    public String getDataUiSauceLabDBV2() throws SQLException, ClassNotFoundException {
        String brandAddress = null; // Default null if no address is found
        String sql = "select * from new_schema.branch where ADDRESS ='Sauce Labs Backpack';";

        // Use try-with-resources for automatic resource management
        try (Connection conn = MySQLTestConnection.getMyConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            if (rs.next()) {
                brandAddress = rs.getString("ADDRESS"); // Get the first address found
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception, possibly log it
        }

        return brandAddress; // Return the address (can be null if not found)
    }

    //Dùng để truyền tham số bên ngoài vào
    public boolean checkTotalRecordMemorySizeFromDB(String zipcode, String address, String role) throws SQLException, ClassNotFoundException {
//        waitForControl(driver, Agentool.DesktopsPage.MEMORY_SIZE_DROPDOWN, timeWait);
        Connection conn = MySQLTestConnection.getMyConnection();
        String sql = "";
        if (role.equals("roleAdmin")) {
            sql =  "Select ADDRESS From new_schema.branch where ZIP_CODE = ? and ADDRESS = ?";
        } else {
            sql =  "Select ADDRESS,ZIP_CODE From new_schema.branch where ZIP_CODE = ? and ADDRESS like ?";
        }
        int i = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, zipcode);
            statement.setString(2, address);
            ResultSet rs = statement.executeQuery();
            System.out.println( rs);
            System.out.println( "Param 1 :" + rs.getString(1));
            while (rs.next()) {
                i = rs.getInt("address");
                System.out.println("--------------------");
                System.out.println( "Param 1 :" + rs.getString(1));
                System.out.println( "Param 2 :" + rs.getString(2));

            }
            if (i == 3 ) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
