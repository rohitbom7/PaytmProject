package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureSnapshot(WebDriver driver, int testID) throws IOException {
		String timestamp=new SimpleDateFormat("dd-MM-YYYY hh mm ss").format(new Date());
		TakesScreenshot t=(TakesScreenshot)driver;
		File snap=t.getScreenshotAs(OutputType.FILE);
		File loca=new File("test-output\\Screenshot\\Test-"+testID+" "+timestamp+".jpg");
		FileHandler.copy(snap,loca);}
	    
	public static String fetchExcelSheetData(String sheet, int row, int column) throws EncryptedDocumentException, IOException {
		String data;
		String a="src\\main\\resources\\testData\\Ecxcel Selenium.xlsx";
		FileInputStream file= new FileInputStream(a);
		Workbook book=WorkbookFactory.create(file);
		try{
			data=book.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();}
		catch(IllegalStateException e) {
			double value=book.getSheet(sheet).getRow(row).getCell(column).getNumericCellValue();
			data=Double.toString(value);}
		return data;
		}

	
	
}
