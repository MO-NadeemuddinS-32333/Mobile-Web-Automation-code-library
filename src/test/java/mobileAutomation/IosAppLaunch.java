package mobileAutomation;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import utils.Commons;

public class IosAppLaunch {

	public static void main(String[] args) throws IOException, InterruptedException {
		// launching calculator app
		// Note: An app can be launch via 2 ways Desired capablities & UIAutomator2Options
		// values are fetched from global properties file Commons class

		System.out.println("Initializing iOS Appium...");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", Commons.getGlobalPropertiesValue("iosVersion"));
		capabilities.setCapability("deviceName", Commons.getGlobalPropertiesValue("iosDevice"));
		capabilities.setCapability("udid", Commons.getGlobalPropertiesValue("iosUdid"));
		capabilities.setCapability("bundleId", Commons.getGlobalPropertiesValue("iosBundleId"));
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("noReset", true);
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
	}

}
