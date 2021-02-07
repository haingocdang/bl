package utils.excelutils;

import commons.GlobalConstants;
import commons.VerifyHelper;
import cucumber.api.DataTable;
import cucumber.api.Transformer;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.Platform;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import static tests.BaseTest.testDataExcelFileName;

/**
 * Created by obaskirt on 28-Oct-17.
 * Updated by obaskirt on 02-Apr-2019
 */
public class ExcelUtil extends Transformer<DataTable> {
    //Main Directory of the project

    @Override
    public DataTable transform(String filePath) {
        return null;
    }

    public static ExcelUtil getData() {
        return new ExcelUtil();

    }

    public static final String currentDir = System.getProperty("user.dir");

    //Location of Test data excel file
    public static String testDataExcelPath = null;

    //Excel WorkBook
    public static XSSFWorkbook excelWBook;

    //Excel Sheet
    public static XSSFSheet excelWSheet;

    //Excel cell
    public static XSSFCell cell;

    //Excel row
    public static XSSFRow row;

    //Row Number
    public static int rowNumber;

    //Column Number
    public static int columnNumber;

    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }

    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    public static void setExcelFileSheet(String sheetName) {
        //MAC or Windows Selection for excel path
        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "//src//test//resources//datatest//";
        } else if (Platform.getCurrent().toString().contains("WIN")) {
            testDataExcelPath = currentDir + "\\src\\test\\resources\\datatest\\";
        }
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME);
            //  System.out.println("File path is"+testDataExcelPath+GlobalConstants.FILE_NAME);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public static String getCellData(int RowNum, int ColNum) {
        String cellData;
        CellType cellType;
        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            cell.setCellType(CellType.STRING);
            //  DataFormatter formatter = new DataFormatter();
            cellData = cell.getStringCellValue();
            if (cell.getCellStyle().getDataFormatString().contains("%")) {
                // Detect Percent Values
                Double value = Double.parseDouble(cellData)* 100;
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.HALF_EVEN);
                System.out.println("value " + value);

               // cellData=value.toString();
                cellData=df.format(value.doubleValue());
               //cellData=cellData+"%";
            }
            //String cellData = Integer.toString((int) cell.getNumericCellValue());
            //return cellData;
          /*  if (cell != null) {
                //cellType=cell.getCellType();
                switch (cell.getCellType()) {
                    case FORMULA:
                        XSSFFormulaEvaluator evaluator = excelWBook.getCreationHelper().createFormulaEvaluator();
                        evaluator.evaluateFormulaCell(cell);
                        cellValue = String.valueOf((cell.getNumericCellValue()));
                        cellValue = cellValue.substring(0, cellValue.length() - 2);
                        break;
                    case STRING:
                        cellValue = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        cellValue = String.valueOf((cell.getNumericCellValue()));
                        //cellValue = cellValue.substring(0, cellValue.length() - 2);
                        break;
                }
            }*/
        } catch (Exception e) {
            throw (e);
        }
        return cellData;
    }


    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }

    //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData(String value, int RowNum, int ColNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}