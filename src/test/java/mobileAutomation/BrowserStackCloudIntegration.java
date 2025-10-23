package mobileAutomation;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import utils.Commons;

public class BrowserStackCloudIntegration {

	public static void main(String[] args) throws Exception {
		//child methods created for browser stack iOS and Android
		initBrowserStackIos();
		initBrowserStackandroid();
	}

	private static void initBrowserStackIos() throws Exception {
		System.out.println("Initializing BrowserStack...");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		HashMap<String, Object> bstackOptions = new HashMap<>();
		bstackOptions.put("userName", Commons.getGlobalPropertiesValue("bstackUser"));
		bstackOptions.put("accessKey", Commons.getGlobalPropertiesValue("bstackKey"));
		bstackOptions.put("appiumVersion", "2.0.1");
		bstackOptions.put("debug", "true");
		bstackOptions.put("interactiveDebugging", "true");
		// you can also add build name, project name, session name here
		// bstackOptions.put("buildName",
		// Commons.getGlobalPropertiesValue("buildName"));
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("appium:platformVersion", "17.0");
		capabilities.setCapability("appium:deviceName", "iPhone 15");
		capabilities.setCapability("appium:app", Commons.getGlobalPropertiesValue("bstackApp"));
		capabilities.setCapability("appium:automationName", "XCUITest");
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("browserstack.networkLogs", true);
		capabilities.setCapability("bstack:options", bstackOptions);

		IOSDriver driver = new IOSDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(500);
	}

	private static void initBrowserStackandroid() throws Exception {
		System.out.println("Initializing BrowserStack...");

		UiAutomator2Options capabilities = new UiAutomator2Options();

		HashMap<String, Object> bstackOptions = new HashMap<>();
		bstackOptions.put("userName", Commons.getGlobalPropertiesValue("bstackUser"));
		bstackOptions.put("accessKey", Commons.getGlobalPropertiesValue("bstackKey"));
		bstackOptions.put("appiumVersion", "2.0.1");
		bstackOptions.put("debug", "true");
		bstackOptions.put("interactiveDebugging", "true");
		// you can also add build name, project name, session name here
		// bstackOptions.put("buildName",
		// Commons.getGlobalPropertiesValue("buildName"));

		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appium:platformVersion", "14.0");
		capabilities.setCapability("appium:deviceName", "Google Pixel 8 Pro");
		capabilities.setCapability("appium:app", Commons.getGlobalPropertiesValue("bstackApp"));
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		capabilities.setCapability("browserstack.networkLogs", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("bstack:options", bstackOptions);

		AndroidDriver driver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(500);
	}

}
