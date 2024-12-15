package jdbcTest;

import java.sql.*;

public class MySQLTestConnectionExecuteQuery {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Get connection... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = MySQLTestConnectionExecuteQuery.getMyConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = (Statement) conn.createStatement();

        String paramSql = "Select ADDRESS,city,ZIP_CODE From new_schema.branch where BRANCH_ID like ? and ZIP_CODE = ? and ADDRESS = ?";

        PreparedStatement pstm  = conn.prepareStatement(paramSql);
        pstm.setInt(1, 3);
        pstm.setString(2,"02169");
        pstm.setString(3,"125 Presidential Way");


        ResultSet rs = pstm.executeQuery();

        // Duyệt trên kết quả trả về
        while (rs.next()) {
            System.out.println("--------------------");
            System.out.println( "Param 1 :" + rs.getString(1));
            System.out.println( "Param 2 :" + rs.getString(2));
            System.out.println( "Param 3 :" + rs.getInt(3));

        }
        // Đóng kết nối
        conn.close();
        System.out.println("---------- Closed connection ----------");
    }
}
