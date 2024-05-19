package ExcelUtils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWrite {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelReadWrite(String excelPath, String sheetName){
        {
            try {
                workbook = new XSSFWorkbook(excelPath);
                sheet = workbook.getSheet(sheetName);
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
                System.out.println(exp.getCause());
                exp.printStackTrace();
            }
        }
    }

    public int getRowCount() {
                int rowCount = sheet.getPhysicalNumberOfRows();
                System.out.println("No of rows " + rowCount);
        return rowCount;
    }

    public void getCellData(int rowno, int colno){
                //Irrespective of datatype to get the cell value
                DataFormatter dataFormatter = new DataFormatter();
                Object cellData = dataFormatter.formatCellValue(sheet.getRow(rowno).getCell(colno));
                System.out.println("cellData is " + cellData);
    }

}