package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {

    public static Connection getMySQLConnection() {
        String hostName = "localhost";
        String dbName = "new_schema";
        String userName = "root";
        String password = "Matkhau@123";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
        Connection conn = null;
        try {
            // Khai báo class Driver cho MySQL
            // Việc này cần thiết với Java 5private static final
            // Java 6 tự động tìm kiếm Driver thích hợp - ko bắt buộc cần dòng này
//            Class.forName("com.mysql.jdbc.Driver");

            // Cấu trúc URL Connection dành cho MySQL
            // Ví dụ: jdbc:mysql://localhost:3306/automationfc
            String connectionURL = "jdbc:mysql://" + hostName + ":3309/" + dbName;
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
