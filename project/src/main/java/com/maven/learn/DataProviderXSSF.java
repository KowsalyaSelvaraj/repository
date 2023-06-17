package com.maven.learn;

import java.io.FileInputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.maven.learn.*;

import io.github.bonigarcia.wdm.WebDriverManager;

//import jxl.Cell;

public class DataProviderXSSF {

	WebDriver driver;
	static	List<String> usernameList = new ArrayList<String>();
	static	List<String> passwordList = new ArrayList<String>();
	private XSSFWorkbook workbook;
	public void readExcelByXSSF() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lap\\Desktop\\KOWSALYA\\Automation\\TestData.xlsx");

		workbook = new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator =  sheet.iterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<Cell> cellIterator =  row.iterator();
			int i=2;
			while (cellIterator.hasNext()) {
				if(i%2==0) {
					usernameList.add(cellIterator.next().getStringCellValue());
				}
				else {
					passwordList.add(cellIterator.next().toString());
				}
				i++;
			}

		}
		
	}

	public void loginTestCase(String username, String password)
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPOM.userNamElement.sendKeys(username);
		LoginPOM.passwordElement.sendKeys(password);
		LoginPOM.submitButtonElement.click();
	}


	public void execute()
	{
		DataProviderXSSF dataProviderXSSF = new DataProviderXSSF();
		PageFactory.initElements(driver, LoginPOM.class);
		dataProviderXSSF.openBrowser();
		for(int i=0;i<usernameList.size();i++)
		{
			loginTestCase(usernameList.get(i), passwordList.get(i));
		}
		//dataProviderXSSF.closeBrowser();
	}


	public  void closeBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions  options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public static void main(String[] args) throws IOException {

		DataProviderXSSF dataProviderXSSF = new DataProviderXSSF();
		dataProviderXSSF.readExcelByXSSF();
		System.out.println(usernameList+"\n");
		System.out.println(passwordList+"\n");
		dataProviderXSSF.execute();
	}



}
