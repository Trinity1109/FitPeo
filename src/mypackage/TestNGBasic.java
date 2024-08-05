package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGBasic {
	
	
	WebDriver driver;
	@BeforeClass
	
	public void LaunchBrowser() {
		
		System.out.println("Launch chrome browser.");
		//set the system property with chromedriver path 
		
				System.setProperty("webdriver.chrome.driver", "./Driver//chromedriver.exe");
				
				driver= new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void enterURL() {
		
		System.out.println("Enter Url");
		//Launch Fitpeo Website
		driver.get("https://www.fitpeo.com/");
		
				
		//Maximize the window
		driver.manage().window().maximize();
	}
	
		
	@Test
	
	public void FitPeo() {
	
		
		// Navigate from Home page to Revenue Calculator page
		driver.navigate().to("https://www.fitpeo.com/revenue-calculator");
		System.out.println(driver.getTitle());

		//Scroll down the webpage 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 450);");

		//Find the slider WebElement
		WebElement slider= 	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/span[1]"));
		
		// get and displayed the slider width
		int width = slider.getSize().getWidth();

		System.out.println(width);
		
		//perform scroll action 
		new Actions(driver).dragAndDropBy(slider,  -26, 0).perform();

		WebElement text = driver.findElement(By.xpath("//*[@id=\":R57alklff9da:\"]"));

		//put 560 value into text input field
		driver.findElement(By.xpath("//*[@id=\":R57alklff9da:\"]")).clear();
		js.executeScript("arguments[0].value='560'", text);

		js.executeScript("window.scrollBy(0, 350);");
		
		//put 560 value into text input field
		

		driver.findElement(By.xpath("//*[@id=\":R57alklff9da:\"]")).clear();
		js.executeScript("arguments[0].value='560'", text);
		
		//Scroll down and Select CPT check boxes
		js.executeScript("window.scrollBy(0, 400);");

		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input")).click();

		js.executeScript("window.scrollBy(0, 400);");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input")).click();

		js.executeScript("window.scrollBy(0, 800);");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input")).click();

		
		//Scroll up for checking and store the Total Recurring Reimbursement for all Patients Per Month Value
		js.executeScript("window.scrollBy(0, -1680);");

		String str = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/p[1]")).getText();
		System.out.println(str);
		String strr = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/p[2]")).getText();
		System.out.println(strr);

		//Scroll down for Highlight active Menu bar
		js.executeScript("window.scrollBy(0, 350);");
		
		//Switch  to the active highlighted menu bar
		driver.switchTo().activeElement();
		//Click the highlighted menu bar
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/header")).click();
		
		//Store the text Total Recurring Reimbursement for all Patients Per Month Value from highlighted menu bar
		String str1=	driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/p[4]")).getText();
		System.out.println(str1);
		
		//Store the Value of Total Recurring Reimbursement for all Patients Per Month Value from highlighted menu bar

		String str2 =	driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/p[4]/p")).getText();
		System.out.println(str2);
		
		
		//Validate both the value 
		if(strr.equalsIgnoreCase(str2)) {
			System.out.println("Both are same Value");
		}
		else {
			System.out.println("Both values are different");
		}
	}

			
	
	@AfterClass
	
	public void CloseBrowser() {
		
		driver.close();
		System.out.println(" close Browser. ");
	}
}
