package org.testing.Trigger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Runner {

	public static void main(String[] args) throws BiffException, IOException {
		XmlSuite xs = new XmlSuite();
		xs.setName("Suite1");
		XmlTest xt = new XmlTest(xs);
		File f = new File("../YTFrameWork/src/org/testing/Properties/TestCases.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet(0);
		int row = s.getRows();
		List<XmlClass> xc = new ArrayList<XmlClass>();
		for (int i = 1; i < row; i++) {
			Cell c = s.getCell(4, i);
			if (c.getContents().equals("Y")) {
				Cell pck = s.getCell(2, i);
				Cell ClassName = s.getCell(3, i);
				String value = pck.getContents() + "." + ClassName.getContents();
				XmlClass xci = new XmlClass(value);
				xc.add(xci);
			}
		}
		xt.setClasses(xc);
		List<XmlTest> alxt = new ArrayList<XmlTest>();
		alxt.add(xt);
		xs.setTests(alxt);
		List<XmlSuite> alxs = new ArrayList<XmlSuite>();
		alxs.add(xs);
		TestNG t = new TestNG();
		t.setXmlSuites(alxs);
		t.run();
	}

}
