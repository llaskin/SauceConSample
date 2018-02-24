package com.SauceLabs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by llaskin on 2/23/18.
 * This is references in slides 60 and 64 of the Sauce Con "Getting Started with Sauce Labs" Presentation
 */
public class sampleAppiumTest {
    @Test
    public void sampleSeleniumTest() throws Exception {
        final String USERNAME = System.getenv("SAUCE_USERNAME");
        final String KEY = System.getenv("SAUCE_ACCESS_KEY");
        final String url = "https://" + USERNAME + ":" + KEY + "@ondemand.saucelabs.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "7.0");
			caps.setCapability("DeviceName", "Android Emulator");
			caps.setCapability("BrowserName", "Chrome");
			
			//create the driver
			AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL(url), caps);
			
			driver.get("http://saucelabs.github.io/training-test-page/");
			driver.findElement(By.id("comments")).sendKeys("Nice page you got here");
			int i=0;
			while (i!=10) {
				driver.findElement(By.id("unchecked_checkbox")).click();
				driver.findElement(By.id("checked_checkbox")).click();
				i++;
			}
			driver.findElement(By.id("submit")).click();
			//disconnect from Sauce Labs
			driver.quit();

    }


}
