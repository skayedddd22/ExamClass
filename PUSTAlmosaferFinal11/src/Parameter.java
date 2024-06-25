import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Parameter {

	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	Random rand = new Random();
	String arabicCities[] = {"دبي","جده"};
	String englishCities[] = {"dubai","jeddah","riyadh"};
	int randomArabic = rand.nextInt(arabicCities.length);
	int randomEnglish = rand.nextInt(englishCities.length);
	

public void theBeginigOfTheWebSite () {
	driver.get("https://www.almosafer.com/en");
	driver.manage().window().maximize();
	WebElement welcomeScreen = driver.findElement(By.xpath("//button[normalize-space()='Kingdom of Saudi Arabia, SAR']"));
	welcomeScreen.click();}
public void checkTheLanguage(String theLanguageINeedToCheck) {
	String actualLang =driver.findElement(By.tagName("html")).getAttribute("lang");
	String expectedLang = theLanguageINeedToCheck;
	softassert.assertEquals(actualLang, expectedLang);
}
public void checkTheCurrency(String expectedCurrency) {
	WebElement salary = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
	String expectedSal = expectedCurrency;
	String actualSal = salary.getText();
	softassert.assertEquals(expectedSal, expectedSal);
}
public void checkTheContact (String ContactNumber) {
	WebElement number = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
	String expectedNum = ContactNumber;
	String actualNum = number.getText();
	softassert.assertEquals(actualNum, expectedNum);
}
public void checkLogoQitaff (WebElement theLogo) {
	WebElement logoQitaf = theLogo;
	boolean isQitaf =logoQitaf.isDisplayed();
	boolean expectedOitaf =true;
	softassert.assertEquals(isQitaf, expectedOitaf);
}














}