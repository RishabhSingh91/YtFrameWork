package org.testing.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelRead {
	
	public static String Read(int row, int col, int sheetindex) throws BiffException, IOException
	{
		File f = new File("../YTFrameWork/src/org/testing/Properties");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(sheetindex);
		Cell c = s.getCell(col, row);
		String value = c.getContents();
		return value;
	}
	
	public static void Write(int row, int col, int sheetindex, String status) throws BiffException, IOException, WriteException
	{
		String Path ="../YTFrameWork/src/org/testing/Properties/test.xls";
		File f = new File(Path);
		Workbook wb = Workbook.getWorkbook(f);
		WritableWorkbook wwb = Workbook.createWorkbook(new File(Path), wb);
		WritableSheet ws = wwb.getSheet(sheetindex);
		WritableCell cell = ws.getWritableCell(col, row);
		Label l = (Label) cell;
		l.setString(status);
		wwb.write();
		wwb.close();
		wb.close();
	}
	
	public static String ReadEx(int row, int col, int sheetindex) throws IOException
	{
		String path="";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(sheetindex);
		XSSFRow rw = ws.getRow(row);
		XSSFCell cell = rw.getCell(col);
		String value = cell.getStringCellValue();
		return value;
	}
	
	public static void WriteEx(int row, int col, int Sheetindex, String value) throws IOException
	{
		String path="";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(Sheetindex);
		XSSFRow rw = ws.getRow(row);
		XSSFCell cell = rw.createCell(col);
		cell.setCellValue(value);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		fo.close();
	}

}
