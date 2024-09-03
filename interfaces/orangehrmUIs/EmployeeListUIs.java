package orangehrmUIs;

public class EmployeeListUIs {
    public static final String ADD_EMPLOYEE_BUTTON = "xpath=//a[text()='Add Employee']";
    public static final String ADD_BUTTON = "xpath=//button[normalize-space()='Add']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String SEARCH_BUTTON = "xpath=//button[contains(string(),'Search')]";
    public static final String EDIT_BUTTON_BY_EMPLOYEE_ID = "xpath=//div[string()='%s']/following-sibling::div/div[contains(@class,'oxd-table-cell-actions')]//i[@class='oxd-icon bi-pencil-fill']";



}
