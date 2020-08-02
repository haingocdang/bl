package pageUI.jquerry;

public class DataTablePageUI {
	public static final String DYNAMIC_TEXTBOX = "//div[@class='qgrd-header-text' and text()='%s']/parent::div//following-sibling::input";
	public static final String DYNAMIC_ONLY_ONE_ROW_WITH_TEXT = "//tr[not(@style='display: none;')]/td[text()='%s']";
	public static final String DYNAMIC_ICON = "//td[@data-key='%s' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	public static final String DYNAMIC_EDIT_POPUP="//div[@class='qgrd-modal-content']//input[@name='%s' and @value='%s']";
	public static final String DYNAMIC_PAGE_NUMBER="//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String DYNAMIC_PAGE_ACTIVE="//li[@class='qgrd-pagination-page']/a[text()='%s' and contains(@class,'active')]";
	public static final String DYNAMIC_COLUMN_INDEX="//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_CELL_INDEX="//tr[%s]/td[%s]/input";

}
