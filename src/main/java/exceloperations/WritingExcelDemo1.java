package exceloperations;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WritingExcelDemo1 {
    public static void main(String[] args) throws IOException {
        //workbook-->Sheet-->Rows-->cells

        XSSFWorkbook workbook = new XSSFWorkbook(); //created an empty workbook
        XSSFSheet sheet = workbook.createSheet("Emp Info");//created an empty sheet

        Object empData[][]= {   {"EmpID","Name","Job"},   //created the data
                                {101,"David","Engineer"},
                                {102,"Sam","Engineer"},
                                {103,"Smith","Engineer"}
                            };





        int rows = empData.length;
        int cols = empData[0].length;

        System.out.println(rows);//4
        System.out.println(cols);//3

        for (int r = 0; r <rows; r++){
            XSSFRow row=sheet.createRow(r);

            for (int c = 0; c<cols; c++){
                XSSFCell cell=row.createCell(c);
                Object value = empData[r][c];

                if (value instanceof String){
                    cell.setCellValue((String)value);
                    if (value instanceof Integer){
                        cell.setCellValue((Integer)value);
                        if (value instanceof Boolean){
                            cell.setCellValue((Boolean)value);
                        }
                    }
                }

            }

        }
        String filePath = "C:\\Users\\thech\\IdeaProjects\\deltaDentalAutomation\\src\\main\\datafiles\\Test1.xlsx";
        FileOutputStream outStream = new FileOutputStream(filePath);
        workbook.write(outStream);
        outStream.close();

        System.out.println("Employee.xlsx file written successfully");
    }



}
