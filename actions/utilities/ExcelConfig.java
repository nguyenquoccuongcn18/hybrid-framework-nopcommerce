package utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import commons.GlobalConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelConfig {
    private Sheet currentSheet;
    private final String testDataExcelPath = GlobalConstants.DATA_TEST_PATH_EXCEL + "UserData.xlsx" ;
    private Map<String, Integer> columns;

    public static ExcelConfig getExcelData() {
        return new ExcelConfig();
    }

    public void switchToSheet(String name) {
        columns = new HashMap<String, Integer>();

        try (var workbooks = WorkbookFactory.create(new File(testDataExcelPath))) {
            currentSheet = workbooks.getSheet(name);
            currentSheet.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Tên cột là gì -> dòng thứ mấy
    public String getCellData(String columnName, int row) {
        var dataRow = currentSheet.getRow(row);
        return getCellDataAsString(dataRow.getCell(columns.get(columnName)));
    }

    private String getCellDataAsString(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();//nếu dữ liệu là công thức thì dùng getStringCellValue để nó convert sang String
            case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
            case FORMULA -> cell.getStringCellValue();
            default -> "";
        };
    }
}
