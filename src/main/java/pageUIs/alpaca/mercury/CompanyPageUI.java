package pageUIs.alpaca.mercury;

public class CompanyPageUI {
    public static final String ADD_BUTTON="//button[contains(.,'Tạo mới')]";
    public static final String SEARCH_TEXTBOX="//input[@name='keyword']";
    public static final String FILTER_BUTTON="//a[@title='Bộ lọc']";
    public static final String FILTER_SELECT="//label[text()='Khu vực']//parent::div//div[@class='filter-select__control css-yk16xz-control']";
    public static final String REMOVE_FILTER_BUTTON="//button[contains(.,'Xóa')]";
    public static final String CLOSE_FILTER_CONTENT_RIGHT="//button[@class='btn btn-lg p-0']";
    public static final String PAGINATE_ITEMS_IN_PAGE="//select[@class='custom-select custom-select-sm form-control form-control-sm']";
    public static final String PAGINATE_BUTTON_FIRST_PAGE="//li[@title='Trang đầu']";
    public static final String PAGINATE_BUTTON_NEXT_PAGE="//li[@title='Trang sau']";
    public static final String PAGINATE_BUTTON_PREVIOUS_PAGE="//li[@title='Trang trước']";
    public static final String PAGINATE_BUTTON_LAST_PAGE="//li[@title='Trang cuối']";
    public static final String PAGE_HEADER_TITLE="//h5[contains(.,'Công ty')]";
    public static final String USER_TABLE="//table[@role='table']";
    public static final String NUMBER_OF_USER="//div[@class='float-left pb-2']//b[2]";
    public static final String EDIT_USER="//table[@role='table']//tr[2]//td[6]//a[contains(.,'Chỉnh sửa')]";
    public static final String BLOCK_USER="//table[@role='table']//tr[2]//td[6]//a[contains(.,'Khóa')]";
    public static final String DELETE_USER="//table[@role='table']//tr[2]//td[6]//a[contains(.,'Xóa')]";
    public static final String UNBLOCK_USER="//table[@role='table']//tr[2]//td[6]//a[contains(.,'Mở khóa')]";
    public static final String HAMBURGER_MENU="//i[@class='feather icon-menu']";
    public static final String COMPANY_NAME="//table[@role='table']//tr[2]//td[1]//a";
    public static final String USER_AVT="//li[@class='dropdown dropdown-user nav-item']//a//div";
    public static final String SIGN_OUT="//li[@class='dropdown dropdown-user nav-item show']//div//a[contains(.,'Đăng xuất')]";
    public static final String USER_LEFT_MENU="//a[@class='menu-item']//span[contains(.,'Người dùng')]";
    public static final String COMPANY_LEFT_MENU="//a[@class='menu-item']//span[contains(.,'Công ty')]";
}
