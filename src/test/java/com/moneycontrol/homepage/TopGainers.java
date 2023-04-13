package com.moneycontrol.homepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;import org.w3c.dom.html.HTMLTableRowElement;

import com.moneycontrol.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TopGainers {
	@Test
	public void dynamicXpath() {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/");
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		String partialLink = "//div[@class='PR in_tg_display_data']/child::div[@id='in_tgNifty']/child::table/child::tbody/child::tr[1]/child::td[1]/child::a[text()='%s']";
		String xpath = String.format(partialLink, "Kotak Mahindra");
		System.out.println(xpath);
		String text=driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
		driver.close();
		}
	
	@Test
	public void maxGain() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/");
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		List<WebElement> gainPer = driver.findElements(By.xpath("//div[@id='in_tgNifty']/descendant::tbody/child::tr/child::td[4]"));
		ArrayList<Double> s=new ArrayList<Double>();
		for(WebElement singleGain:gainPer) {
			double gainText = Double.parseDouble(singleGain.getText());
			s.add(gainText);
		}
		Collections.sort(s);
		for(Double db:s) {
			
		
		System.out.println(db);
		
	}

}
}