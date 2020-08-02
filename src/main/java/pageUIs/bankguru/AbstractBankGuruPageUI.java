package pageUIs.bankguru;

public class AbstractBankGuruPageUI {
	//Textbox
	public static final String DYNAMIC_TEXTBOX="//td[text()='%s']//following-sibling::td//input";
	
	//Label
	public static final String DYNAMIC_LABEL="//td[text()='%s']";
	
	//Error message
	public static final String DYNAMIC_ERROR_MESSAGE="//td[text()='%s']//following-sibling::td/label";
	
	//Textarea
	public static final String DYNAMIC_TEXTAREA="//td[text()='%s']//following-sibling::td//textarea";

	//Radio button
	public static final String DYNAMIC_RADIO_BUTTON="//input[@type='radio' and @value='%s']";
	
	//Menu link
	//public static final String DYNAMIC_MENU_LINK="//ul[@class='menusubnav']//a[text()='%s']";
	public static final String DYNAMIC_LINK="//a[text()='%s']";
	
	//Button
	public static final String DYNAMIC_BUTTON="//input[@value='%s']";
	
	//Message
	public static final String DYNAMIC_MESSAGE="//p[@class='heading3' and text()='%s']";

	//Column value
	public static final String DYNAMIC_VALUE_BY_COLUMN_NAME="//td[contains(text(),'%s')]/following-sibling::td";
	
	//Irame
	public static final String IFRAME="//div[@id='primis_container_div']/iframe[@id='flow_close_btn_iframe']";
	//public static final String IFRAME="//iframe";
	public static final String IFRAME_CLOSE_BUTTON="//div[@id='closeBtn']";

	

	
}
