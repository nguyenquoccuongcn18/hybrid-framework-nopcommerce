package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    // Thay đổi các thông tin kết nối theo cơ sở dữ liệu của bạn
    private static final String URL = "jdbc:postgresql://localhost:5432/tên_cơ_sở_dữ_liệu";
    private static final String USER = "tên_người_dùng";
    private static final String PASSWORD = "mật_khẩu";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Tạo kết nối
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");

            // Thực hiện các thao tác với cơ sở dữ liệu ở đây

        } catch (SQLException e) {
            System.err.println("Kết nối thất bại!");
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
