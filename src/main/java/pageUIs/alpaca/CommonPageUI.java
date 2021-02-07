package pageUIs.alpaca;

public class CommonPageUI {
    /*    public static final String TAO_BUTTON="//button[contains(.,'Tạo')]";
        public static final String HUY_BUTTON="//button[contains(.,'Hủy')]";
        public static final String TAO_MOI_BUTTON="//button[text()='Tạo mới']";*/
    public static final String COMMON_BUTTON = "//button[contains(.,'%s')]";
    //public static final String MAIN_MENU="//i[@class='far fa-bars']";
    public static final String MAIN_MENU = "//i[contains(@class,'far fa-bars')]";
    public static final String FUNCTION_MENU = "//ul[@class='navigation navigation-main']//span[text()='%s']";
    public static final String TRANG_THAI_LABEL = "//a[contains(text(),'%s')]//parent::td//following-sibling::td/div[contains(text(),'%s')]";
    public static final String VALUE_TEXTBOX = "//div[contains(text(),'%s')]//ancestor::table//*[contains(text(),'%s')]";
    //public static final String TOAST_MESSAGE="//div[contains(text(),'%s')]";
    public static final String TOAST_MESSAGE = "//div[contains(@class,'react-toast-notifications__toast__content')]";
    public static final String COMMON_PARENT_SELECTBOX = "//label[contains(text(),'%s')]/parent::*[1]/*[2]";
    //public static final String COMMON_PARENT_SELECTBOX = "//label[contains(text(),'%s')]/parent::*[1]/*[2]//div[contains(@class,'placeholder')]";
    public static final String COMMON_CHILD_SELECTBOX = "//div[contains(@id,'react-select')]";
    public static final String COMMON_SELECTBOX = "//label[contains(text(),'%s')]/following-sibling::select";
    //public static final String COMMON_TEXTBOX="//label[contains(text(),'%s')]/following-sibling::input";
     public static final String COMMON_TEXTBOX="//label[contains(text(),'%s')]/following-sibling::input";
    //public static final String COMMON_TEXTBOX="//label[contains(text(),'%s')]/following-sibling::article//input";
    //public static final String COMMON_TEXTBOX = "//label[contains(text(),'%s')]/following-sibling::input";
    public static final String COMMON_COLOUMN_INDEX = "//th[contains(.,'%s')]//preceding-sibling::th";
    public static final String COMMON_ROW_INDEX = "//td/*[text()='%s']/parent::td/parent::tr/preceding-sibling::tr";
    //public static final String COMMON_ROW_INDEX ="//td//*[text()='%s']/parent::span/parent::td/preceding-sibling::td";
    public static final String COMMON_CELL_INPUT_INDEX = "//tr[%s]/td[%s]/input";
    public static final String COMMON_TRANG_THAI_INDEX_XPTAH = "//tr[%s]/td[%s]/div";
    public static final String COMMON_TRANG_THAI_INDEX = "tr:nth-of-type(%s) > td:nth-of-type(%s) > div";
    public static final String COMMON_CELL_INDEX = "//tr[%s]/td[%s]/span";
    public static final String COMMON_CHINH_SUA_LAN_CUOI_INDEX = "//tr[%s]/td[%s]";
    public static final String COMMON_CELL_LINK = "//tr[%s]/td[%s]/a";
    public static final String PHAM_VI_BH_CHECKBOX = "//b[contains(text(),'%s')]/parent::td/preceding-sibling::td";
    public static final String ACTION_MENU = "//a[contains(text(),'%s')]//parent::td//following-sibling::td[@class='action-col']";
    //public static final String ACTION_OPTION="//a[contains(text(),'%s')]//parent::td//following-sibling::td[@class='action-col']//button[contains(.,'%s')]";
    public static final String ACTION_OPTION = "//a[text()='%s']//parent::td//following-sibling::td[@class='action-col']//*[@class='dropdown-item delete' and contains(.,'%s')]";
    public static final String ACTION_OPTION1 = "/a[text()='%s']//parent::td//following-sibling::td[@class='action-col']//*[@class='dropdown-item delete' and contains(.,'%s')]";
    public static final String POPUP = "//div[@class='modal-content']//h3";
    public static final String POPUP_CSS = "h3.modal-title";
    public static final String COMMON_TEXTAREA = "//label[contains(text(),'%s')]/parent::*//textarea";
    public static final String NGAY_HIEU_LUC_DATE_PICKER = "//label[contains(text(),'%s')]/parent::div//div[@class='react-datepicker-wrapper']";
    public static final String CLOSE_POPUP_BUTTON = "//button[@class='close rounded-pill']";
    public static final String SEARCH_TEXTBOX = "//input[@name='keyword']";
    public static final String SECTION_LABEL = "//h5[contains(.,'%s')]";
    public static final String COMMON_DATETIME_PICKER="//label[contains(text(),'%s')]/following-sibling::article//input";
    //public static final String COMMON_DATETIME_PICKER = "//label[contains(text(),'%s')]/following-sibling::div//input";
    public static final String COMMON_LABEL = "//label[contains(text(),'%s')]";

}
