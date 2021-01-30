package org.testing.Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogsCapture {
	
	public static void takelogs(String msg, String ClassName)
	{
		DOMConfigurator.configure("../YTFrameWork/Layout.xml");
		Logger l = Logger.getLogger(ClassName);
		l.info(msg);
	}

}
