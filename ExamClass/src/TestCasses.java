import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCasses {
	String SingOut = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String LogIn ="https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
	WebDriver driver = new ChromeDriver();
	String [] FirstName = {"ahmad","sarah","mohammad"};
	String [] LastName = {"omar","mahmoud","mousa"};
	String UserPassword = "Aesss123!";
	Random rand = new Random();
	int randomIndex = rand.nextInt(3);
	int randomEmailID = rand.nextInt(9999);
	String UserFirstName = 	FirstName[randomIndex]	;
	String UserLasttName =LastName[randomIndex];
	String Email_Address = UserFirstName +UserLasttName +randomEmailID+"@gmail.com";
@BeforeTest 
public void MyBeforeTest() {
	driver.get("https://magento.softwaretestingboard.com/");
	WebElement SignUpButton = driver.findElement(By.linkText("Create an Account"));
	SignUpButton.click();
}
@Test(priority = 1)
public void MySetUp() throws InterruptedException {
	WebElement FirstName = driver.findElement(By.id("firstname"));
	WebElement LastName = driver.findElement(By.id("lastname"));
	WebElement Email= driver.findElement(By.id("email_address"));
	WebElement Password = driver.findElement(By.id("password"));
	WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
	WebElement CreatAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
	FirstName.sendKeys(UserFirstName);
	LastName.sendKeys(UserLasttName);
	Email.sendKeys(Email_Address);
	Password.sendKeys(UserPassword);
	ConfirmPassword.sendKeys(UserPassword);
	CreatAccountButton.click();
     Thread.sleep(3000);
     driver.get(SingOut);
}
@Test(priority = 2)
public void LogIn() {
	driver.get(LogIn);
	WebElement EmailLogIn = driver.findElement(By.id("email"));
	WebElement PassswordLogIn = driver.findElement(By.id("pass"));
	WebElement LogInButton= driver.findElement(By.id("send2"));
	EmailLogIn.sendKeys(Email_Address);
	PassswordLogIn.sendKeys(UserPassword);
	LogInButton.click();
	
}
@AfterTest
public void MyAfterTest() {}

}
