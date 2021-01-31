package com.testpractice.reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	
	String filePath;
	Workbook wb;
	Sheet sh;
	
	public ExcelOperations(String sheetName) {
		filePath = System.getProperty("user.dir")+PropertiesOperations.getProperties("testData");
		//Create a File Object because Workbook Factory takes File
		File file = new File(filePath);
		//get ExcelWb using poi
		try {
			wb = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get to the Sheet
		sh = wb.getSheet(sheetName);
	}

	public HashMap<String,String> getTestDatainMap(int rowNum) throws EncryptedDocumentException, IOException{
		
		//getnumCols
		int num_Col = sh.getRow(0).getLastCellNum();
		//Declare HashMap
		HashMap<String,String> map = new HashMap<String,String>();
		//Iterate over Cols and put to HashMap
		for(int i=0;i<=num_Col-1;i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			String key = sh.getRow(0).getCell(i).toString();
			String value = sh.getRow(rowNum).getCell(i).toString();
			map.put(key, value);
		}
		//return HashMap
		return map;
	}
	
	public int getNumRows() {
		return sh.getLastRowNum();
	}
}
