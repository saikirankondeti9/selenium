package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BasePage;

public class UtilKit extends BasePage{
	static FileInputStream fIS2;
	public static HashMap<String, String> getTestCase(String testCase) throws IOException{
		fIS2=new FileInputStream("src\\test\\resources\\testdata\\excels2\\adactin data.xlsx");//("src\\test\\resources\\testdata\\excels\\adactin data.xlsx");
		XSSFWorkbook wB=new XSSFWorkbook(fIS2);
		XSSFSheet wS=wB.getSheet("Sheet1");
		ArrayList<Row> testCaseRows=getTestCaseRows(wS,testCase);
		HashMap<String, String> hMap=new HashMap<String, String>();
		for(int i=0;i<testCaseRows.size();i++) {
			for(int j=1;j<testCaseRows.get(0).getPhysicalNumberOfCells();i++) {
				hMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(),testCaseRows.get(1).getCell(j).getStringCellValue());
			}
		}
		return hMap;
		
	}

	private static ArrayList<Row> getTestCaseRows(XSSFSheet wS, String testCase) {
		ArrayList<Row> listOfAllRows= new ArrayList<Row>();
		for(int i=0;i<wS.getLastRowNum();i++) {
			if(!(wS.getRow(i)==null)) {
				listOfAllRows.add(wS.getRow(i));
			}
			
		}
		ArrayList<Row> testCaseRows =new ArrayList<Row>();
		for(int i=0;i<listOfAllRows.size();i++) {
			if(listOfAllRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCase)) {
				testCaseRows.add(listOfAllRows.get(i));
			}
		}
		return testCaseRows;
		
		
		
		
		
		
	}

}
