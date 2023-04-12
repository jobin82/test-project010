package com.searchcar.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

public class seleniumTest {

@Test
public void startWebdriver() {
// TODO Auto-generated method stub

//Initiating your chromedriver
WebDriver driver=new ChromeDriver();

//maximize window
driver.manage().window().maximize();

//open browser with desried URL
driver.get("https://www.google.com");

//closing the browser
driver.close();

}

}
