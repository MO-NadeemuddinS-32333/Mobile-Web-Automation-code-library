package mobileAutomation;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import utils.Commons;

public class AndroidAppLaunch {
	// launching calculator app
	// Note: An app can be launch via 2 ways Desired capablities & UIAutomator2Options
	// values are fetched from global properties file Commons class

	public static void main(String[] args) throws InterruptedException, IOException {

		System.out.println("Initializing Android Appium....");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", Commons.getGlobalPropertiesValue("androidVersion"));
		capabilities.setCapability("deviceName", Commons.getGlobalPropertiesValue("androidDevice"));
		capabilities.setCapability("udid", Commons.getGlobalPropertiesValue("androidUdid"));
		capabilities.setCapability("appPackage", Commons.getGlobalPropertiesValue("app_package"));
		capabilities.setCapability("appActivity", Commons.getGlobalPropertiesValue("app_activity"));
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("noReset", true);

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		System.out.println("Calculator App Launched Successfully...");
	}
}
