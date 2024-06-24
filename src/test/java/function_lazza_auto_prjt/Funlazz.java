package function_lazza_auto_prjt;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Funlazz {
	WebDriver driver;
	
	By reg=By.xpath("//*[@id=\"header\"]/div/nav/div[2]/a[3]/img");	//account logo
	By reg1=By.xpath("/html/body/section/div/div/a[2]");
	By names=By.name("customerName");
	By email_id=By.name("customerEmail");
	By phonenu= By.name("customerPhone");
	By paswd= By.name("customerPassword");
	By cpaswd= By.name("confirm_customerPassword");
	By regbut=By.xpath("//*[@id=\"frmreg\"]/button");
	By lophone=By.name("login_email");
	By lopasw=By.name("login_password");
	By lobut= By.xpath("/html/body/section/div/div/form/button");
	By home=By.xpath("//*[@id=\"header\"]/div/nav/a/img");
	By searchlog=By.xpath("//*[@id=\"search\"]/img");
	By searchpr=By.id("searchall");
	By cart=By.xpath("//*[@id=\"prd\"]/div[1]/div/button");
	By close=By.xpath("/html/body/div[3]/div/div/button/span");
	By cart2=By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[3]/button");
	By clcart= By.xpath("/html/body/header/div/nav/div[2]/a[2]/img");
	By checkout=By.xpath("/html/body/section/div[1]/div/div[2]/div/a/button");
	By product=By.xpath("/html/body/header/div/nav/div[1]/ul/li[2]/a");
	By offers=By.xpath("/html/body/header/div/nav/div[1]/ul/li[3]/a");
	By abous=By.xpath("/html/body/header/div/nav/div[1]/ul/li[4]/a");
	By contact=By.xpath("/html/body/header/div/nav/div[1]/ul/li[5]/a");
	
	
	public Funlazz(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void register() throws IOException 
	{
		driver.findElement(reg).click();	//clicks account logo
		driver.findElement(reg1).click();	//clicks on register
		
		File f=new File("C:\\Users\\USER\\Desktop\\excel\\lazza_automation_project.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook w=new XSSFWorkbook(fi);
		XSSFSheet sh= w.getSheet("sheet1");
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			String name= sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(name);
			String email= sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(email);
			String phone = sh.getRow(i).getCell(2).getRawValue();
			System.out.println(phone);
			String pasw= sh.getRow(i).getCell(3).getStringCellValue();
			System.out.println(pasw);
			String cpasw= sh.getRow(i).getCell(4).getStringCellValue();
			System.out.println(cpasw);
			System.out.println();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(names).clear();
			driver.findElement(names).sendKeys(name);
			driver.findElement(email_id).clear();
			driver.findElement(email_id).sendKeys(email);
			driver.findElement(phonenu).clear();
			driver.findElement(phonenu).sendKeys(phone);
			driver.findElement(paswd).clear();
			driver.findElement(paswd).sendKeys(pasw);
			driver.findElement(cpaswd).clear();
			driver.findElement(cpaswd).sendKeys(cpasw);
			driver.findElement(regbut).click();
			if(name.equals(" "))
			{
				System.out.println("field can be left blank");
				System.out.println("invalid email_id can be entered");
			}
			
			driver.navigate().back();
			driver.navigate().back();
			driver.findElement(reg1).click();
			
			}
		
		driver.findElement(reg).click();
		for(int i=1;i<=sh.getLastRowNum();i++)		//login
		{
			
			String phone = sh.getRow(i).getCell(2).getRawValue();
			System.out.println(phone);
			String pasw= sh.getRow(i).getCell(3).getStringCellValue();
			System.out.println(pasw);
			System.out.println();
			
			
			driver.findElement(lophone).clear();
			driver.findElement(lophone).sendKeys(phone);
			driver.findElement(lopasw).clear();
			driver.findElement(lopasw).sendKeys(pasw);
			driver.findElement(lobut).click();
			
		}
		WebElement l = driver.findElement(lobut);
		boolean b=l.isSelected();
		if(b)
		{
			System.out.println("signin button working");
		}
		else
		{
			System.out.println("signin button not working");
		}
		driver.findElement(reg).click();
		driver.findElement(home).click();
	}
	
	public void logo()
	{
		WebElement g = driver.findElement(home);
		boolean bl=g.isDisplayed();
		if(bl)
		{
			System.out.println("logo is present");
		}
		else
		{
			System.out.println("logo not present");
		}
	}
	
	public void search() throws Exception 
	{
		driver.findElement(searchlog).click();
		WebElement en = driver.findElement(searchpr);
		en.sendKeys("cone");
		Actions ac=new Actions(driver);
		ac.keyDown(en,Keys.ENTER).keyUp(Keys.ENTER);
		ac.perform();
		Thread.sleep(20000);
		driver.findElement(close).click();
	}
	
	public void cart() throws Exception
	{
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("window,scrollBy(0,300)","");
		driver.findElement(cart).click();
		Thread.sleep(5000);
		driver.findElement(close).click();
		driver.findElement(cart2).click();
		driver.findElement(clcart).click();
		driver.findElement(checkout).click();
		driver.findElement(home).click();
	}
	
	public void menu()
	{
		driver.findElement(product).click();
		driver.findElement(offers).click();
		driver.findElement(abous).click();
		driver.findElement(contact).click();
		driver.findElement(home).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window,scrollBy(0,500)","");
	}
	
	public void screenshot() throws Exception 
	{
		File scs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scs,new File ("C:\\Users\\USER\\Desktop\\screen.png"));
		
	}
	
	
	

	
	
	

}
