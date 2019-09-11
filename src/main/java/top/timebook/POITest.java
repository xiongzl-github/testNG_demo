package top.timebook;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author xiongzl
 **/
public class POITest {

    public static final String FILE_PATH = "d:\\ExcelRead.xlsx";

    public static void readExcel() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int lastRowIndex = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowIndex; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                String cellValue = row.getCell(j).getStringCellValue();
                System.out.println(cellValue);
            }
        }
        bufferedInputStream.close();
    }

    public static void main(String[] args) throws IOException {
        readExcel();
    }

}
