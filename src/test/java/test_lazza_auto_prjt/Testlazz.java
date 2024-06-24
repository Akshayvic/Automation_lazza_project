package test_lazza_auto_prjt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import function_lazza_auto_prjt.Funlazz;

public class Testlazz {
	WebDriver driver;
	@BeforeTest
	public void t1()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void t2()
	{
		driver.get("https://lazza.co.in/");
	}
	@Test
	public void tlz() throws IOException
	{
		driver.manage().window().maximize();
		Funlazz fl=new Funlazz(driver);
		fl.register();
		fl.logo();
	}
	
	@Test
	public void tlz1() throws Exception
	{
		Funlazz fl=new Funlazz(driver);
		fl.search();
		fl.cart();
		fl.menu();
		fl.screenshot();
	}
	

}
