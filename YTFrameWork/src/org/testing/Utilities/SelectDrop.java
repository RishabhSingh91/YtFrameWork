package org.testing.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDrop {

	public static void ByValue(WebElement e, String value) {
		Select sel = new Select(e);
		sel.selectByValue(value);
	}

	public static void ByIndex(WebElement e, int index) {
		Select sel = new Select(e);
		sel.selectByIndex(index);
	}

	public static void ByVisibletext(WebElement e, String text) {
		Select sel = new Select(e);
		sel.selectByVisibleText(text);
	}
}
