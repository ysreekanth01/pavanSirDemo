package com.moneycontrol.genericUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	
	public WebDriver launchBrowser(String browser, String url) {
		if(browser=="chrome") {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Enter Proper Browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		Alert a=driver.switchTo().alert();
		a.dismiss();
		
		return driver;
	}

}
