package com.SauceLabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.*;

import java.net.URL;

/**
 * Created by llaskin on 2/23/18.
 * This is references in slides 60 and 64 of the Sauce Con "Getting Started with Sauce Labs" Presentation
 */
public class sampleSeleniumTest {
    @Test
    public void sampleSeleniumTest() throws Exception {
        final String USERNAME = System.getenv("SAUCE_USERNAME");
        final String KEY = System.getenv("SAUCE_ACCESS_KEY");
        final String URL = "https://" + USERNAME + ":" + KEY + "@ondemand.saucelabs.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 7");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "43.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("http://saucelabs.github.io/training-test-page/");
        driver.findElement(By.id("comments")).sendKeys("Nice page you got here");
        int i=0;
        while (i!=10) {
            driver.findElement(By.id("unchecked_checkbox")).click();
            driver.findElement(By.id("checked_checkbox")).click();
            i++;
        }
        driver.findElement(By.id("submit")).click();
        driver.quit();
    }


}
