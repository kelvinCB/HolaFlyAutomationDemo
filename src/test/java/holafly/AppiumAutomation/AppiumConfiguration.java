package holafly.AppiumAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumConfiguration {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void startAppium() throws URISyntaxException, MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\kelvi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		
		//Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android"); 
		options.setDeviceName("Pixel-8-Pro-API-35"); 
		options.setAutomationName("UIAutomator2"); 
		options.setAppPackage("com.holafly.holafly"); 
		options.setAppActivity("com.holafly.holafly.ui.activity.SplashActivity"); 
		options.autoGrantPermissions();
		options.noReset(); 
		
		//Initialize driver
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
	}
	
	@AfterClass
	public void stopAppiumServer() {
		driver.quit();
		service.stop();
	}

}
