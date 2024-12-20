package notify;

import commons.BasePageFactoty;
import commons.GlobalConstants;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LineNotify {

    public static void sendLineNotify(String message, String accessToken) {
        
        try {
            // Tạo URL đến LINE Notify API
            URL url = new URL(GlobalConstants.getGlobalConstants().LINE_NOTIFY_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập phương thức kết nối là POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Authorization", "Bearer " + GlobalConstants.getGlobalConstants().getAccessTokenLine()); // Thêm Bearer token
            connection.setDoOutput(true);

            // Nội dung thông báo cần gửi
            String data = "message=" + message;

            // Gửi dữ liệu
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = data.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Kiểm tra mã trạng thái phản hồi
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Thông báo đã được gửi thành công!");
            } else {
                System.out.println("Lỗi: Không thể gửi thông báo, mã lỗi: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Đã xảy ra lỗi khi gửi thông báo.");
        }
    }

    public static void main(String[] args) {
        String accessToken = "0EHm9nsAloymhxYP4N1YU44jggnBOpGdUxGgSgjk9BB"; //  Access Token
        String message = "Hi Mẫn Nhi thông báo từ LINE Notify API.";

        sendLineNotify(message, accessToken);
    }
}
