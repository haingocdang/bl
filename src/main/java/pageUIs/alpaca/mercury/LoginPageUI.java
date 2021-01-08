package pageUIs.alpaca.mercury;

public class LoginPageUI {
	public static final String DANG_NHAP_BUTTON="//button[contains(.,'Đăng')]";
	//public static final String DANG_NHAP_BUTTON="//button[contains(.,'Đăng Nhập')]";
	public static final String USER_NAME_TEXTBOX="//input[@id='user-name']";
	public static final String PASSWORD_TEXTBOX="//input[@id='user-password']";
	public static final String BLANK_USER_NAME_ERROR="//input[@id='user-name']/following-sibling::div[@class='invalid-feedback']";
	public static final String BLANK_PASSWORD_ERROR="//input[@id='user-password']/following-sibling::div[@class='invalid-feedback']";
	public static final String INVALID_LOGIN_ERROR_MESSAGE="//div[@class='alert bg-danger']";

}
