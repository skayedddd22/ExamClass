import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TEStFinal extends Parameter {
	
	
@BeforeTest
public void setUp () {
	theBeginigOfTheWebSite ();
}
@Test(priority = 1)
public void theLang() {
	checkTheLanguage("en");
	softassert.assertAll();
}
@Test(priority = 2)
public void chrckTheSalary ( ) {
	checkTheCurrency("SAR");
	softassert.assertAll();
}
@Test(priority = 3)
public void checkTheNumber() {
	checkTheContact("+966554400000");
	softassert.assertAll();
}
@Test(priority = 3)
public void checkLogo() {
	checkLogoQitaff(driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']")));
    softassert.assertAll();
}

@Test(enabled = false)//3ade ba7aleh hek
public void checkHotelTotNotSelector() {
	WebElement hotelTob = driver.findElement(By.className("sc-hcmgZB"));
	String expectedHotelTob = "false";
	String actual=hotelTob.getText();
	softassert.assertEquals(actual, expectedHotelTob);
}
@Test(enabled = false)
public void checkTheDepenture() {
	WebElement actualDepentureDate = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"));
	WebElement actualReturnDate = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"));
	int actualDepenturDateValue = Integer.parseInt(actualDepentureDate.getText());
	int actualReturnDateValue = Integer.parseInt(actualReturnDate.getText());
	LocalDate today = LocalDate.now();
	int expectedDepentureDateValue = today.plusDays(1).getDayOfMonth();
	int expectedReturnDateValue = today.plusDays(2).getDayOfMonth();
	Assert.assertEquals(actualDepenturDateValue, expectedDepentureDateValue);
	Assert.assertEquals(actualReturnDateValue, expectedReturnDateValue);
	String dayElementOnTheWebsite = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-hvvHee cuAEQj']")).getText().toUpperCase();
     Assert.assertEquals(dayElementOnTheWebsite, today.plusDays(1).getDayOfWeek().toString());
}
@Test()
 public void changeTheLanguageOfTheWebsiteRandomly() throws InterruptedException{
	Random rand = new Random();
	String [] myUrls = {"https://www.almosafer.com/ar?ncr=1","https://www.almosafer.com/en"};
	int randomIndex =rand.nextInt(myUrls.length);
	driver.get(myUrls[randomIndex]);
	WebElement hotelTob = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	hotelTob.click();
	Thread.sleep(4000);
	WebElement searchHotelTob = driver.findElement(By.className("sc-phbroq-2"));
	String actualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
	if(driver.getCurrentUrl().contains("ar")) {
		Assert.assertEquals(actualLanguage, "ar");
		searchHotelTob.sendKeys(arabicCities[randomArabic]);
		Thread.sleep(4000);
		WebElement cityList = driver.findElement(By.className("sc-phbroq-4"));
		List<WebElement> myItems = driver.findElements(By.tagName("li"));
		myItems.get(1).click();
	}
	else {
		Assert.assertEquals(actualLanguage, "en");
		searchHotelTob.sendKeys(englishCities[randomEnglish]);
		Thread.sleep(4000);
		WebElement cityList = driver.findElement(By.className("sc-phbroq-4"));
		List<WebElement> myItems = driver.findElements(By.tagName("li"));
		myItems.get(1).click();
		
	}
	WebElement visitorInput = driver.findElement(By.className("sc-tln3e3-1"));
	Select mySelector = new Select(visitorInput);
	int randomIndexForVisitor = rand.nextInt(2);
	mySelector.selectByIndex(randomIndexForVisitor);
	WebElement searchBujtton = driver.findElement(By.className("sc-1vkdpp9-6"));
	searchBujtton.click();
	Thread.sleep(30000);
	String hotalSearchResult = driver.findElement(By.className("sc-ctwKVn")).getText();
	if(driver.getCurrentUrl().contains("ar")){
		boolean actualResult =hotalSearchResult.contains("وجدنا");
		boolean expectedResult = true ;
		Assert.assertEquals(actualResult, expectedResult);
		WebElement lowestResult = driver.findElement(By.className("sc-kRCAcj"));
		lowestResult.click();
	} else {
		boolean actualResult =hotalSearchResult.contains("found");
		boolean expectedResult = true ;
		Assert.assertEquals(actualResult, expectedResult);
		WebElement lowestResult = driver.findElement(By.className("sc-kRCAcj"));
		lowestResult.click();
	}
	Thread.sleep(28000);
	WebElement priceSection = driver.findElement(By.cssSelector("div[data-testid='HotelSearchResult__ResultsList']"));
	List<WebElement> myPrice = driver.findElements(By.className("Price__Value"));
	int lowestPrice = Integer.parseInt(myPrice.get(0).getText());
	int highestPrice = Integer.parseInt(myPrice.get(myPrice.size()-1).getText());
	System.out.println(lowestPrice);
	System.out.println(highestPrice);
	Assert.assertEquals(highestPrice>lowestPrice, true);
}
@AfterTest
public void thefinal() {

}}

