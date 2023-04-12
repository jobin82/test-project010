package com.searchcar.selenium;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectCarZooSite {

	public vehicleDetails connectSite(String regNo) throws Exception, MalformedURLException {

		vehicleDetails details = null;

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cazoo.co.uk/value-my-car/");

		//Thread.sleep(10000);

		WebElement submitButton = driver.findElement(By.id("vrm"));
		Actions actions = new Actions(driver);
		actions.moveToElement(submitButton).perform();

		WebElement vrmInputField = (new WebDriverWait(driver, Duration.ofSeconds(30)))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("vrm")));
		vrmInputField.sendKeys( regNo );
		vrmInputField.submit();
		Thread.sleep(3000);

		String page = driver.getPageSource();
		//System.out.println("Page Source : Found value: " + page);

		Pattern r = Pattern.compile(".*<p>Reg:(.+?)</p>");
		// Now create matcher object.
		Matcher m = r.matcher(page);
		String str = null;
		if (m.find()) {
			details = new vehicleDetails();
			str = m.group(1);
			System.out.println("Reg : Found value: " + str);
			details.setVehicleReg( str );
			
			
			r = Pattern.compile(".*<p>Make/model:(.+?)([\\s]+)(.+?)</p>");
			m = r.matcher(page);
			if (m.find()) {
				str = m.group(1);
				System.out.println("Make : Found value: " + str);
				details.setVehicleMake( str );
				
			}
			else {
				System.out.println("Make : Not Found ");
			}
			r = Pattern.compile(".*<p>Make/model:(.+?)([\\s]+)(.+?)</p>");
			m = r.matcher(page);
			if (m.find()) {
				str = m.group(3);
				System.out.println("Model : Found value: " + str);
				details.setVehicleModel( str );
				
			}
			else {
				System.out.println("Model : Not Found ");
			}
		}
		else {
			System.out.println("Car Reg : Not Found ");
			
		}
		
		
		driver.quit();
		return details ;
	}
}
