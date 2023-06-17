package com.maven.learn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM {

	@FindBy(name="username")
	public static WebElement userNamElement;
	
	@FindBy(name="password")
	public static WebElement passwordElement;
	
	@FindBy(xpath = "//button[contains(@class,'button')]")
	public static WebElement submitButtonElement;
	
}
