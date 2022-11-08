package com.qa.practice.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties pro;
	public static FileInputStream fis;
	public static WebDriver driver;

	public void driver_int() throws IOException {

		pro = new Properties();
		fis = new FileInputStream("/Users/tohidur/eclipse-workspace/JulySessonFrameWork/src/main/java/com/"
				+ "qa/practice/config/configeration.properties");

		pro.load(fis);
		String browser_Name	= System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("Browser");
	//	String browser_Name = pro.getProperty("Browser");
		//mvn test -Dbrowser=chrome

		if (browser_Name.equalsIgnoreCase("chrome")) {
//			ChromeOptions cop = new ChromeOptions();
//			cop.addArguments("--headless");
			
			
			//WebDriverManager.chromedriver().setup();
			String path = SeleniumManager.getInstance().getDriverPath("chromedriver");
			System.out.println(path);
			driver = new ChromeDriver();

		} else if (browser_Name.equalsIgnoreCase("firefox")) {
			
			FirefoxBinary fb = new FirefoxBinary();
			fb.addCommandLineOptions("--headless");
			FirefoxOptions foption = new FirefoxOptions();
			foption.setBinary(fb);
			String path = SeleniumManager.getInstance().getDriverPath("geckodriver");
			System.out.println(path);
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser_Name.equalsIgnoreCase("edge")) {
			//

		} else if (browser_Name.equalsIgnoreCase("safari")) {
			//

		} else if (browser_Name.equalsIgnoreCase("opera")) {
			//
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(3000));
		driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(3000));
		driver.get("https://www.phptravels.net/login");

	}


}
