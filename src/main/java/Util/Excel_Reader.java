package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class Excel_Reader {

	public static List<String> readExcel() throws IOException {

		File file = new File("D:\\Java_Workspace\\IndianRailwayProject\\src\\main\\resources\\data\\Assertion.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		List <String> cityList = new ArrayList();
		
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cityList.add(row.getCell(j).getStringCellValue());
			}
		}
		return cityList;
	}
}
