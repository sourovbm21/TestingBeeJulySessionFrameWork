package com.qa.practice.utils;

import org.openqa.selenium.WebElement;

import com.qa.practice.base.TestBase;

public class CommonUtility {
	
	
	
	public static boolean getDisplayed(WebElement element ) {
		return element.isDisplayed();
		
	}

}
