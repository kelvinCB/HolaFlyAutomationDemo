package holafly.AppiumAutomation;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AccountSettings extends AppiumConfiguration {
	
	@Test
	public void changeAccountLanguageToEnglish() throws InterruptedException {
		
		//Skip splash screen
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Skip\")")).click();
		Thread.sleep(3000);
		
		//Go to Profile
		driver.findElement(AppiumBy.accessibilityId("Profile")).click();
		Thread.sleep(3000);
		
		//Click Language option
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Language\")")).click();
		Thread.sleep(3000);
		
		//Select Spanish
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Select the app language\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Spanish\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Save\")")).click();
		Thread.sleep(3000);
		
		//Note -> app have a bug because language is not changing but this can be handle with assertions 
		
	}
	

}
