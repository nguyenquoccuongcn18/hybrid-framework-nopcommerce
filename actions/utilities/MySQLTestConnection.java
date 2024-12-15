package utilities;

import jdbcTest.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Get connection... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = MySQLTestConnection.getMyConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = (Statement) conn.createStatement();

        // Câu lệnh SQL để lấy dữ liệu.
        String sql = "Select * From new_schema.branch Emp;";
        String sqlInsert = "insert into new_schema.branch (branch_id, name, address, city, state, Zip_Code)" +
               "values (null, 'thegioididong', 'D1.', 'HCM', 'ThuDuc', '000005')";
        //Insert
        int rowCount = statement.executeUpdate(sqlInsert);
        System.out.println("Data insert:" + rowCount);
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);


        // Duyệt trên kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ xuống bản ghi kế tiếp.
            int brandId = rs.getInt("BRANCH_ID");
            String brandAddress = rs.getString("ADDRESS");
            String brandCity = rs.getString("CITY");
            String brandName = rs.getString("NAME");
            String brandState = rs.getString("STATE");
            String brandZipcode = rs.getString("ZIP_CODE");

            System.out.println("--------------------");
            System.out.println("Emp Id:" + brandId);
            System.out.println("Emp Id:" + brandAddress);
            System.out.println("Emp Firstname:" + brandCity);
            System.out.println("Emp Lastname:" + brandName);
            System.out.println("Emp Firstname:" + brandState);
            System.out.println("Emp Lastname:" + brandZipcode);
        }
        // Đóng kết nối
        conn.close();
        System.out.println("---------- Closed connection ----------");
    }
}
