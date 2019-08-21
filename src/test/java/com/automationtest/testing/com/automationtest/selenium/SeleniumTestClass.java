package com.automationtest.testing.com.automationtest.selenium;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automationtest.testing.com.automationtest.config.YamlTesting;

public class SeleniumTestClass {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static YamlTesting yamlTest;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		yamlTest = new YamlTesting();
	}

	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void tearDown() {
			driver.close();
	}

	@Test
	public void testCoversion() {
		driver.get("https://www.bing.com/translator");
		HashMap hm = yamlTest.readDataFromFile();
		PageObject signUpPage = new PageObject(driver, wait);
		
		ArrayList<String> inputlanguage = (ArrayList<String>) hm.get("inputlanguage");
		ArrayList<String> outputlanguage = (ArrayList<String>) hm.get("outputlanguage");
		ArrayList<String> inputtext = (ArrayList<String>) hm.get("inputtext");
		ArrayList<String> outputtext = (ArrayList<String>) hm.get("outputtext");
		for (int i=0;i<inputlanguage.size();i++)
		{
			String convertedText = signUpPage.getConvertedText(inputlanguage.get(i), 
						outputlanguage.get(i), inputtext.get(i));
			assertEquals(convertedText.toLowerCase(), outputtext.get(i));
		}
		
		
	}

}
