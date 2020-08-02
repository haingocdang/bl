package pageUIs.liveguru;

public class AbstractLiveGuruPageUI {
	
	public static final String ACCOUNT_INFOLINK="//a[text()='Account Information']";
	public static final String ADDRESS_BOOK_LINK="//a[text()='Address Book']";
	public static final String BILLING_AGREEMENTS_LINK="//a[text()='Billing Agreements']";
	public static final String ACCOUNT_DASHBOARD_LINK="//a[text()='Account Dashboard']";
	public static final String MY_APPLICATIONS_LINK="//a[text()='My Applications']";
	
	//Dynamic Locator
	public static final String DYNAMIC_PAGE_LINK="//a[text()='%s']";
//	public static final String DYNAMIC_PAGE_LINK="//div[@class='wp-menu-name' and text()='%s']";
	public static final String UPLOAD_FILE_TYPE="//input[@type='file']";
	public static final String PROGRESS_BAR="//div[@class='thumbnail']//div[@class='media-progress-bar']";
	public static final String UPLOADED_IMAGES="//div[@class='thumbnail']//img[contains(@src,'%s')]";

	
}
