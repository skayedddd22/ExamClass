package mybakage;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class mytestcasses {
	DesiredCapabilities caps = new DesiredCapabilities();
AndroidDriver driver;
@BeforeTest
public void myTestcases() {
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "PSUT");

	File myapplication = new File("src/myapplication/calculator.apk");
	caps.setCapability(MobileCapabilityType.APP, myapplication.getAbsolutePath());
}

@Test()
public void mybeforeTest() throws MalformedURLException {
	driver = new AndroidDriver(new URL("http://172.0.0.1:4723/wd/hub"),caps);
}
@AfterTest
public void mypostTest() {}
}