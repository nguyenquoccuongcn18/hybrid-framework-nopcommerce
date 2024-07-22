package pageUserUIs;

public class RegisterPageUI {
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";

    public static final String FIRSTNAME_ERROR_MSG = "xpath=//span[normalize-space()='First name is required.']";
    public static final String LASTNAME_ERROR_MSG = "xpath=//span[normalize-space()='Last name is required.']";
    public static final String EMAIL_ERROR_MSG = "xpath=//span[@id='Email-error']";
    public static final String EMAIL_ERROR_MSG_EMPTY = "xpath=//span[normalize-space()='Email is required.']";
    public static final String PASSWORD_ERROR_MSG = "xpath=//input[@id='Password-error']";
    public static final String CONFIRM_PASSWORD_ERROR_MSG = "xpath=//span[@class='field-validation-error']";
    public static final String REGISTER_COMPLETED_MSG = "xpath=//div[@class='result']";

}
