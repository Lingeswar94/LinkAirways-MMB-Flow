package UltityFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	XSSFWorkbook workbook;

	public ExcelData() {
		FileInputStream fileInputStream = null;
		try {

			fileInputStream = new FileInputStream("./src/test/resources/TestData/Data.xlsx");
		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated catch block e.printStackTrace(); }

	}

	public String getStringBiilingdata(String Sheetname, int row, int column) {

		XSSFCell cell = workbook.getSheet(Sheetname).getRow(row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}

	/*
	 * public ExcelData() {
	 * 
	 * properties =new Properties(); FileInputStream fileInputStream=null; try {
	 * fileInputStream = new FileInputStream(properties.getProperty("ExcelPath"));
	 * 
	 * } catch (IOException e) { throw new
	 * RuntimeException("Failed to load Excel file: " + e); } try { workbook = new
	 * XSSFWorkbook(fileInputStream); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public String getMMBData(String sheetName, int row, int column) { if
	 * (workbook == null) { throw new
	 * IllegalStateException("Workbook not initialized."); }
	 * 
	 * XSSFSheet sheet = workbook.getSheet(sheetName); if (sheet == null) return
	 * " Sheet is not initialized";
	 * 
	 * XSSFRow rowData = sheet.getRow(row); if (rowData == null) return
	 * "ROW is not initialized";
	 * 
	 * XSSFCell cell = rowData.getCell(column); if (cell == null) return
	 * "Column is not initialized";
	 * 
	 * return new DataFormatter().formatCellValue(cell); }
	 */
}
