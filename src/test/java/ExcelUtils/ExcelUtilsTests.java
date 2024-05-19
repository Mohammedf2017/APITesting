package ExcelUtils;

public class ExcelUtilsTests {
    public static void main(String[] args) {

        String homeDir = System.getProperty("user.dir" );
        System.out.println(homeDir);
        ExcelReadWrite excel = new ExcelReadWrite(homeDir+ "\\test_data\\testdata.xlsx", "Sheet1");
        int rowcount = excel.getRowCount();
        for(int rowNum =0 ; rowNum < rowcount ; rowNum++ ) {
            for(int colNum=0;colNum<=1;colNum++) {
                excel.getCellData(rowNum, colNum);
            }
        }
    }
}
