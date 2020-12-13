package pageUIs.alpaca;

public class AbstracPageUI {
    public static final String TAO_BUTTON="//button[contains(.,'Tạo')]";
    public static final String HUY_BUTTON="//button[contains(.,'Hủy')]";
    public static final String TAO_MOI_BUTTON="//button[text()='Tạo mới']";
    //public static final String MAIN_MENU="//i[@class='far fa-bars']";
    public static final String MAIN_MENU="//i[contains(@class,'far fa-bars')]";
    public static final String FUNCTION_MENU="//ul[@class='navigation navigation-main']//span[text()='%s']";
    public static final String TRANG_THAI_LABEL="//a[contains(text(),'%s')]//parent::td//following-sibling::td/div[contains(text(),'%s')]";
    public static final String VALUE_TEXTBOX="//div[contains(text(),'%s')]//ancestor::table//*[contains(text(),'%s')]";
    public static final String TOAST_MESSAGE="//div[contains(text(),'%s')]";
    public static final String COMMON_PARENT_SELECTBOX="//label[contains(text(),'%s')]/parent::*[1]/*[2]";
    public static final String COMMON_CHILD_SELECTBOX="//div[contains(@id,'react-select')]";
    public static final String COMMON_TEXTBOX="//label[contains(text(),'%s')]/following-sibling::input";

}
