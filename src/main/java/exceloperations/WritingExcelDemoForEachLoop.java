package exceloperations;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WritingExcelDemoForEachLoop {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        Object empData[][] = {{"EmpID", "Name", "Job"}, {101, "David", "Engineer"}, {102, "Smith", "Manager"}, {103, "Scott", "Analyst"}};

        ArrayList<Object[]> empdata = new ArrayList<Object[]>();
        empdata.add(new Object[]{"Empid","Name","Job"});
        empdata.add(new Object[]{101,"David","Engineer"});
        empdata.add(new Object[]{102,"Smith","Manager"});
        empdata.add(new Object[]{103,"Scott","Analyst"});

        int rowNum = 0;
        int cellNum = 0;

        for (Object[] emp1:empdata) {
            XSSFRow row1 = sheet.createRow(rowNum++);
            for (Object value : emp1) {
                XSSFCell cell1 = row1.createCell(cellNum++);
                if (value instanceof String) {
                    cell1.setCellValue((String) value);
                    if (value instanceof Integer) {
                        cell1.setCellValue((Integer) value);
                        if (value instanceof Boolean) {
                            cell1.setCellValue((Boolean) value);
                        }

                    }
                }
            }
        }


        /// for each loop
        int rowCount = 0;
        int columnCount = 0;
        for (Object emp[] : empData) {
            XSSFRow row = sheet.createRow(rowCount++);
            for (Object value : emp) {
                XSSFCell cell = row.createCell(columnCount++);
                if (value instanceof String) {
                    cell.setCellValue((String) value);
                    if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                        if (value instanceof Boolean) {
                            cell.setCellValue((Boolean) value);
                        }
                    }
                }

            }
        }


        String filePath = "C:\\Users\\thech\\IdeaProjects\\deltaDentalAutomation\\src\\main\\datafiles\\Test.xlsx";
        FileOutputStream outStream = new FileOutputStream(filePath);
        workbook.write(outStream);
        outStream.close();

        System.out.println("Employee.xlsx file written successfully");
    }
}
