package com.maven.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OpenGoogle {

	public static void main(String[] args) {
		
		ExtentSparkReporter  reporter = new ExtentSparkReporter("report.html");
		
		ExtentReports extentReports = new ExtentReports();
		
		extentReports.attachReporter(reporter);
		
		ExtentTest test = extentReports.createTest("Whatsapp Duck");
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Whatsapp Duck \n");
		
		test.pass("Test Passed");
		
		driver.quit();
		extentReports.flush();
	}

}
