package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public Workbook wb;

	public String fetchDataFromExcel(String sheetname, int rowindex, int cellindex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/RestAssuredTestData.xlsx");
		wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowindex).getCell(cellindex).toString();
		return data;
	}

	public int getRowCountInSheet(String sheetname) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/RestAssuredTestData.xlsx");
		wb = WorkbookFactory.create(fis);
		int data = wb.getSheet(sheetname).getLastRowNum();
		return data;
	}

	public void writeBackDataToExcel(String sheetname, int rowindex, int cellindex, String data) throws Exception {

		FileInputStream fis = new FileInputStream("./src/test/resources/RestAssuredTestData.xlsx");
		wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rowindex).createCell(cellindex).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/RestAssuredTestData.xlsx");
		wb.write(fos);
	}

	public void closeExcel() throws IOException {
		wb.close();
	}

}
