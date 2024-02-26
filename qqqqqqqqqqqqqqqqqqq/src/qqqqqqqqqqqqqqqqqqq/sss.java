package qqqqqqqqqqqqqqqqqqq;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class sss {
WebDriver driver = new ChromeDriver();
@BeforeTest 
public void setUp() {
driver.get("http://127.0.0.1:5500/index.html");
driver.manage().window().maximize();

}
@Test
public void myFirstTest() {
	driver.findElement(By.name("inputForTheName")).sendKeys("ahmed");
	driver.findElement(By.name("inputForThePassword")).sendKeys("1234565");
	driver.findElement(By.name("inputForTheEmail")).sendKeys("ss@gmail.com");
	driver.findElement(By.id("submitButtonsos")).click();
}	
@AfterTest
public void postTestingsos() {
	
}

}
