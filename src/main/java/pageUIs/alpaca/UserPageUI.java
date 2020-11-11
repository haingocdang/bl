package pageUIs.alpaca;

public class UserPageUI {
    public static final String ADD_BUTTON="//button[contains(.,'Tạo mới')]";
    public static final String SEARCH_TEXTBOX="//input[@name='keyword']";
    public static final String FILTER_BUTTON="//a[@title='Bộ lọc']";
    public static final String FILTER_SELECT="//label[text()='Công ty']//parent::div//div[@class='filter-select__control css-yk16xz-control']";
    public static final String REMOVE_FILTER_BUTTON="//button[contains(.,'Xóa')]";
    public static final String CLOSE_FILTER_CONTENT_RIGHT="//button[@class='btn btn-lg p-0']";
    public static final String PAGINATE_ITEMS_IN_PAGE="//select[@class='custom-select custom-select-sm form-control form-control-sm']";
    public static final String PAGINATE_BUTTON_FIRST_PAGE="//li[@title='Trang đầu']";
    public static final String PAGINATE_BUTTON_NEXT_PAGE="//li[@title='Trang sau']";
    public static final String PAGINATE_BUTTON_PREVIOUS_PAGE="//li[@title='Trang trước']";
    public static final String PAGINATE_BUTTON_LAST_PAGE="//li[@title='Trang cuối']";
    public static final String PAGE_HEADER_TITLE="//h5[contains(.,'Người dùng')]";
}
