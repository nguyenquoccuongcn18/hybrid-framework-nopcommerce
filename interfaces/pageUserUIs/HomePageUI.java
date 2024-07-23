package pageUserUIs;

public class HomePageUI {
    //1. public : bất kì 1 class nào cũng có thể gọi đến để sử dụng
    //2. static : không cần khởi tạo đối tượng để sử dụng
    //3. final : không thể thay đổi giá trị
    //4. String : kiểu dữ liệu chuỗi
    //5. REGISTER_LINK : tên element_loại element

    // 6 link trên header trước và sau login
    public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
    public static final String LOGIN_REGISTER_LINK = "xpath=//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";

    public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";

    public static final String LOGIN_SUCCESS = "xpath=//button[normalize-space()='Log in']";





}
