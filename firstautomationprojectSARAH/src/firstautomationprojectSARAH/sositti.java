package firstautomationprojectSARAH;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class sositti {
WebDriver driver = new ChromeDriver();
@BeforeTest
public void setUp() {
	driver.get("http://127.0.0.1:5500/undex.html");
	driver.manage().window().maximize();
	}
@Test(invocationCount =10)
public void myfirstpro() throws InterruptedException{
	//driver.findElement(By.name("namee")).sendKeys("ahmad");
	//driver.findElement(By.name("paswordd")).sendKeys("12345");
	//driver.findElement(By.name("emaill")).sendKeys("soso@icloud.com");
	//Thread.sleep(3000);
	//driver.findElement(By.id("soso")).click();
	//driver.findElement(By.id("insta")).click();
	

	WebElement colorInput =driver.findElement(By.name("usecolor"));
	WebElement dateInput =driver.findElement(By.name("usedate"));
	WebElement monthInput =driver.findElement(By.name("usemonth"));
	
	Random rand =new Random();
	String [] randomcolor= {"#AC60ff","#00ced1","#8a2be2","#ff8100"};
	String [] randommonth= {"july","november","october","februray"};
	String [] randomdate= {"1/1/2000","2/2/2233","1/2/4554","4/5/2001"};
	
	int randomIndexColor =rand.nextInt(randomcolor.length);
	int randomIndexMonth =rand.nextInt(randommonth.length);
	int randomIndexdate =rand.nextInt(randomdate.length);
	
	colorInput.sendKeys(randomcolor[randomIndexColor]);
	dateInput.sendKeys(randomdate[randomIndexMonth]);
	monthInput.sendKeys(randommonth[randomIndexdate]);
	
	WebElement UsernameInput = driver.findElement(By.cssSelector("input[name='namee']"));
	WebElement passwordInput = driver.findElement(By.cssSelector("input[name='paswordd']"));
	String []username = {"ahmad","mohammad","soso","sositii"};
	String []passwords = {"1234555","sosooeee","weeewwe","qoqoo11"};
	int randomindexforname =rand.nextInt(username.length);
	int randomindexforpassword =rand.nextInt(passwords.length);
	
	
	Thread.sleep(2000);
}
@AfterTest 
public void post(){
	
}
}









