package commons;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.alpaca.CommonPageUI;

import java.util.ArrayList;
import java.util.List;

public class CommonPageObjects extends AbstractPage {
    WebDriver driver;

    public void CommonPageObjects(WebDriver mappedDriver) {
        driver = mappedDriver;
    }

    /*public void clickTaoButton(WebDriver driver) {
        waitElementClickable(driver, CommonPageUI.TAO_BUTTON);
        clickToElement(driver, CommonPageUI.TAO_BUTTON);
    }

    public void clickTaoMoiButton(WebDriver driver) {
        waitElementClickable(driver, CommonPageUI.TAO_MOI_BUTTON);
        clickToElement(driver, CommonPageUI.TAO_MOI_BUTTON);
    }

    public void clickHuyButton(WebDriver driver) {
        waitElementClickable(driver, CommonPageUI.HUY_BUTTON);
        clickToElement(driver, CommonPageUI.HUY_BUTTON);
    }*/

    public void clickToDynamicButton(WebDriver driver, String buttonName) {
        waitElementClickable(driver, CommonPageUI.COMMON_BUTTON, buttonName);
        clickToElement(driver, CommonPageUI.COMMON_BUTTON, buttonName);
    }

    public void clickToDynamicSection(WebDriver driver, String sectionName) {
        waitElementClickable(driver, CommonPageUI.SECTION_LABEL, sectionName);
        clickToElement(driver, CommonPageUI.SECTION_LABEL, sectionName);
        sleepInSecond(1);
    }

    public void goToPage(WebDriver driver, String pageName) {
        sleepInSecond(1);
        waitElementClickable(driver, CommonPageUI.MAIN_MENU);
        clickToElement(driver, CommonPageUI.MAIN_MENU);
        waitElementClickable(driver, CommonPageUI.FUNCTION_MENU, pageName);
        clickToElement(driver, CommonPageUI.FUNCTION_MENU, pageName);
    }

    public boolean checkValueInList(WebDriver driver, String tenCot, String value) {
        waitElementVisible(driver, CommonPageUI.VALUE_TEXTBOX, tenCot, value);
        return checkTrue(isElementDisplay(driver, CommonPageUI.VALUE_TEXTBOX, tenCot, value));
    }

    public void checkToastMessage(WebDriver driver, String message) {
        sleepInSecond(1);
        waitElementVisible(driver, CommonPageUI.TOAST_MESSAGE);

        //return checkTrue(isElementDisplay(driver, CommonPageUI.TOAST_MESSAGE, message));
        Assert.assertEquals(message, getElementText(driver, CommonPageUI.TOAST_MESSAGE));
    }

    public String getGiaTriTextBox(WebDriver driver, String tenTextBox) {
        waitElementVisible(driver, CommonPageUI.COMMON_TEXTBOX, tenTextBox);
        return getElementAttribute(driver, CommonPageUI.COMMON_TEXTBOX, "value", tenTextBox);
    }

    public ArrayList<String> getAllGiaTriTrongSelectBox(WebDriver driver, String tenSelectBox) {
        waitElementVisible(driver, CommonPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
        sleepInSecond(1);
        clickToElement(driver, CommonPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
        List<WebElement> optionLists = finds(driver, CommonPageUI.COMMON_CHILD_SELECTBOX);
        ArrayList<String> optionValue = new ArrayList<String>();
        for (WebElement option : optionLists) {
			/*jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);*/
            optionValue.add(option.getText());
        }

        waitElementVisible(driver, CommonPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
        clickToElement(driver, CommonPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
        return optionValue;
    }

    public void chonGiaTri(WebDriver driver, String tenSelectBox, String giaTri) {
        waitElementVisible(driver, CommonPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
        selectItemInCustomDropdown(driver, CommonPageUI.COMMON_PARENT_SELECTBOX, CommonPageUI.COMMON_CHILD_SELECTBOX, giaTri, tenSelectBox);
      /*  waitElementVisible(driver, CommonPageUI.COMMON_SELECTBOX, tenSelectBox);
        selectItemInDropDown(driver, CommonPageUI.COMMON_SELECTBOX, giaTri, tenSelectBox);*/
    }

    public void selectGiaTri(WebDriver driver, String tenSelectBox, String giaTri) {
        waitElementVisible(driver, CommonPageUI.COMMON_PARENT_SELECTBOX + "/select", tenSelectBox);
        selectItemInDropDown(driver, CommonPageUI.COMMON_PARENT_SELECTBOX + "/select", giaTri, tenSelectBox);

    }

    public String getValueFromCell(WebDriver driver, String colummName, String rowName) {
        // waitElementVisible(driver, CommonPageUI.DYNAMIC_COLOUMN_INDEX, colummName);
        int columnPosition = countElementNumber(driver, CommonPageUI.COMMON_COLOUMN_INDEX, colummName) + 1;

        int rowPosition = countElementNumber(driver, CommonPageUI.COMMON_ROW_INDEX, rowName) + 1;
        waitElementVisible(driver, CommonPageUI.COMMON_CELL_INPUT_INDEX, Integer.toString(rowPosition), Integer.toString(columnPosition));
        //sendKeyToElement(driver, AbstracPageUI.DYNAMIC_CELL_INDEX, value,Integer.toString(rowPosition), Integer.toString(columnPosition));

        return getElementAttribute(driver, CommonPageUI.COMMON_CELL_INPUT_INDEX, "value", Integer.toString(rowPosition), Integer.toString(columnPosition));
    }

    public String getTextFromCell(WebDriver driver, String colummName, String rowName) {
        // waitElementVisible(driver, CommonPageUI.DYNAMIC_COLOUMN_INDEX, colummName);
        int columnPosition = countElementNumber(driver, CommonPageUI.COMMON_COLOUMN_INDEX, colummName) + 1;

        int rowPosition = countElementNumber(driver, CommonPageUI.COMMON_ROW_INDEX, rowName) + 1;
        waitElementVisible(driver, CommonPageUI.COMMON_CELL_INDEX, Integer.toString(rowPosition), Integer.toString(columnPosition));
        //sendKeyToElement(driver, AbstracPageUI.DYNAMIC_CELL_INDEX, value,Integer.toString(rowPosition), Integer.toString(columnPosition));

        return getElementText(driver, CommonPageUI.COMMON_CELL_INDEX, Integer.toString(rowPosition), Integer.toString(columnPosition));
    }

    public String getDateTimeChinhSua(WebDriver driver, String colummName, String rowName) {
        // waitElementVisible(driver, CommonPageUI.DYNAMIC_COLOUMN_INDEX, colummName);
        int columnPosition = countElementNumber(driver, CommonPageUI.COMMON_COLOUMN_INDEX, colummName) + 1;

        int rowPosition = countElementNumber(driver, CommonPageUI.COMMON_ROW_INDEX, rowName) + 1;
        waitElementVisible(driver, CommonPageUI.COMMON_CHINH_SUA_LAN_CUOI_INDEX, Integer.toString(rowPosition), Integer.toString(columnPosition));
        //sendKeyToElement(driver, AbstracPageUI.DYNAMIC_CELL_INDEX, value,Integer.toString(rowPosition), Integer.toString(columnPosition));

        return getElementText(driver, CommonPageUI.COMMON_CHINH_SUA_LAN_CUOI_INDEX, Integer.toString(rowPosition), Integer.toString(columnPosition));
    }

    public String getTrangThai(WebDriver driver, String colummName, String rowName) {
        // waitElementVisible(driver, CommonPageUI.DYNAMIC_COLOUMN_INDEX, colummName);
        sleepInSecond(1);
        int columnPosition = countElementNumber(driver, CommonPageUI.COMMON_COLOUMN_INDEX, colummName) + 1;

        int rowPosition = countElementNumber(driver, CommonPageUI.COMMON_ROW_INDEX, rowName) + 1;
        waitElementVisible(driver, CommonPageUI.COMMON_TRANG_THAI_INDEX_XPTAH, Integer.toString(rowPosition), Integer.toString(columnPosition));
        //sendKeyToElement(driver, AbstracPageUI.DYNAMIC_CELL_INDEX, value,Integer.toString(rowPosition), Integer.toString(columnPosition));

        return getElementTextByJS(driver, CommonPageUI.COMMON_TRANG_THAI_INDEX, Integer.toString(rowPosition), Integer.toString(columnPosition));
    }

    public void clickToCell(WebDriver driver, String colummName, String rowName) {
        //waitElementVisible(driver, CommonPageUI.DYNAMIC_COLOUMN_INDEX, colummName);
        int columnPosition = countElementNumber(driver, CommonPageUI.COMMON_COLOUMN_INDEX, colummName) + 1;

        int rowPosition = countElementNumber(driver, CommonPageUI.COMMON_ROW_INDEX, rowName) + 1;
        waitElementClickable(driver, CommonPageUI.COMMON_CELL_LINK, Integer.toString(rowPosition), Integer.toString(columnPosition));

        clickToElement(driver, CommonPageUI.COMMON_CELL_LINK, Integer.toString(rowPosition), Integer.toString(columnPosition));
    }

    public String applyCellFormular(String formular, String value) {
        if (formular.contains("{value}")) {
            formular = formular.replace("{value}", value);
        } else if(formular.contains("{SoChoNgoi}")) {
            formular = formular.replace("{SoChoNgoi}", value);
        }
        else if(!formular.contains("/100")){
            return "false";
        }
        return formular;
    }

    public String inputCellValue(WebDriver driver, String formular, String tenField, String value) {
        if (formular.contains("{value}<3")) {
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        } else if(formular.contains("{value}>=3&&{value}<=8")) {
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }
        else if(formular.contains("{value}>8&&{value}<=15")){
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        } else if (formular.contains("{value}>15")){
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }else if (formular.contains("{value}<6")){
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }
        else if (formular.contains("{value}>=6&&{value}<=11")){
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }
        else if (formular.contains("{value}>=12&&{value}<=24")){
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }
        else if (formular.contains("{value}>24")){
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }else {
            sendKeyToElement(driver,CommonPageUI.COMMON_TEXTBOX,value,tenField);
        }

        return formular;
    }

    public void selectOptionFromContextmenu(WebDriver driver, String option, String recordValue) {
        waitElementClickable(driver, CommonPageUI.ACTION_MENU, recordValue);
        clickToElement(driver, CommonPageUI.ACTION_MENU, recordValue);
        sleepInSecond(1);
        waitElementVisible(driver, CommonPageUI.ACTION_OPTION, recordValue, option);
        clickToElement(driver, CommonPageUI.ACTION_OPTION, recordValue, option);
      //  System.out.println("Text is " + getElementText(driver, CommonPageUI.ACTION_OPTION, recordValue, option));
    }

    public void closePopupbutton(WebDriver driver) {
        waitElementClickable(driver, CommonPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, CommonPageUI.CLOSE_POPUP_BUTTON);
    }

    public void inputValueIntoTextbox(WebDriver driver, String tenField, String value) {
        waitElementVisible(driver, CommonPageUI.COMMON_TEXTBOX, tenField);
        sendKeyToElement(driver, CommonPageUI.COMMON_TEXTBOX, value, tenField);
    }

    public void inputValueIntoTextArea(WebDriver driver, String tenField, String value) {
        waitElementVisible(driver, CommonPageUI.COMMON_TEXTAREA, tenField);
        sendKeyToElement(driver, CommonPageUI.COMMON_TEXTAREA, value, tenField);
    }

    public void iInputDateTimePicker(WebDriver driver, String tenField, String dateTime) {
        waitElementVisible(driver, CommonPageUI.COMMON_DATETIME_PICKER, tenField);
        clearValueInField(driver, CommonPageUI.COMMON_DATETIME_PICKER, tenField);
        sendKeyToElement(driver, CommonPageUI.COMMON_DATETIME_PICKER, dateTime, tenField);
        //clickToElement(driver, CommonPageUI.COMMON_DATETIME_PICKER, tenField);
       // clickToElement(driver, CommonPageUI.COMMON_LABEL, tenField);

        sendKeyBoardToElement(driver, CommonPageUI.COMMON_DATETIME_PICKER, Keys.ESCAPE, tenField);
    }

    public void waitTo(WebDriver driver, String dateTime) {
        waitUntilDateTime(driver, dateTime);
    }

    public void searchValue(WebDriver driver, String value) {
        waitElementVisible(driver, CommonPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, CommonPageUI.SEARCH_TEXTBOX, value);
        sendKeyBoardToElement(driver, CommonPageUI.SEARCH_TEXTBOX, Keys.ENTER);
    }


}
