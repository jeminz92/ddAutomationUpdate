package exceloperations;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class readingExcelWithIterator {
    public static void main(String[] args) throws IOException {
        String xls = ".\\src\\main\\datafiles\\countriesSheet.xlsx";
        FileInputStream fi = new FileInputStream(xls);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        ////// Iterator Method //////

        Iterator iterator = sheet.iterator();

        while(iterator.hasNext())
        {
          XSSFRow row = (XSSFRow) iterator.next();

          Iterator cellIterator = row.cellIterator();

          while(cellIterator.hasNext()){
               XSSFCell cell = (XSSFCell) cellIterator.next();

               switch(cell.getCellType()){
                   case STRING : System.out.print(cell.getStringCellValue()); break;
                   case BOOLEAN :System.out.print(cell.getBooleanCellValue()); break;
                   case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
               }
              System.out.print("|");
          }
            System.out.println();
        }

    }
}
