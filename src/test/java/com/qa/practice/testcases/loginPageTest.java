package com.qa.practice.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.qa.practice.base.TestBase;
import com.qa.practice.pages.DashBoard;
import com.qa.practice.pages.loginPage;

public class loginPageTest extends TestBase {

	loginPage lp;
	DashBoard db;

	@BeforeMethod
	public void setUp() throws IOException {

		driver_int();
		lp = new loginPage();
		db = new DashBoard();

	}
	

	@Test(priority = 1)
	public void validLoginTest() {

		db = lp.dologin(pro.getProperty("username"), pro.getProperty("password"));
		Assert.assertTrue(db.userNameAfterLogin());
	}
	

	@Test(dataProvider = "MyData",priority = 0)
	
	public void invalidLoginTest(String uname,String pwd) throws InterruptedException {
		
		db = lp.dologin(uname, pwd);
		Thread.sleep(2000);
		Assert.assertTrue(lp.invalid_Login());		
	}
	
	
	@DataProvider(name="MyData")
	public Object[][] getData() {
		
    Object data [][] = new Object[2][2];
    data [0][0] ="user@phptravelsff.com";
    data [0][1]= "demouserff";
    data [1][0]= "user@phptravelsffff.com";
    data [1][1]= "demouser";		   
	return data;
	
	}
	
	
	
	
	
	
	
	
	@Test(priority = 2)
	public void phpLogoTest() {

		Assert.assertTrue(lp.phpLogo());
	}

	@Test(priority = 3)
	public void paymentlogoTest() {

		Assert.assertTrue(lp.paymentLogo());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
