package com.qa.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.practice.base.TestBase;

public class loginPage extends TestBase {

//OR

	@FindBy(xpath = "//input[@name='email']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement loginbutton;

	@FindBy(xpath = "(//img[@alt='logo'])[1]")
	WebElement logo;

	@FindBy(xpath = "(//*[contains(@class,'icon-box icon')])[2]")
	WebElement paymentLogo;

	@FindBy(css = "[class='alert alert-danger failed']")
	WebElement invalid_Login_Message;

	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	public DashBoard dologin(String uname, String pwd) {
		userName.clear();
		userName.sendKeys(uname);
		passWord.clear();
		passWord.sendKeys(pwd);
		loginbutton.click();
		return new DashBoard();

	}

	public boolean phpLogo() {
		return logo.isDisplayed();
	}

	public boolean paymentLogo() {
		return paymentLogo.isDisplayed();
	}

	public boolean invalid_Login() {

		return invalid_Login_Message.isDisplayed();

	}

}
