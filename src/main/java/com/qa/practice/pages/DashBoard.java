package com.qa.practice.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.practice.base.TestBase;
import com.qa.practice.utils.CommonUtility;

public class DashBoard  extends TestBase{

	
	
	
	
	//span[text()='Welcome Back']
	
	
	@FindBy(xpath="//span[text()='Welcome Back']")
	WebElement userNameLogo;
	
	@FindBy(xpath="//div[contains(@class,'col-lg-3 responsive-column-m user_wallet')]")
	public WebElement wallet;
	
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
	
	public DashBoard() {
		PageFactory.initElements(driver, this);
	}
	
	
//	public boolean  deshboardWallet() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOf(wallet));
//		return wallet.isDisplayed();
//	}
	
	public boolean  userNameAfterLogin() {
		wait.until(ExpectedConditions.visibilityOf(userNameLogo));
		return userNameLogo.isDisplayed();
	}
        CommonUtility cm = new CommonUtility();
        
	
}
