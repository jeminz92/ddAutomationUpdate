package exceloperations;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readingExcelWithLoop {
    public static void main(String[] args) throws IOException {

        //String excelFilePath = "C:\\Users\\thech\\IdeaProjects\\deltaDentalAutomation\\src\\main\\java\\datafiles\\Countries.xlsx";
        String excelFilePath = ".\\src\\main\\datafiles\\countriesSheet.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        //or
        //HSSFSheet sheet = workbook.getSheetAt(0);

        //// Using FOR LOOP 3 columns, 3 rows

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r = 0; r <= rows; r++)
        {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < cols; c++)
            {
                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType())
                {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
