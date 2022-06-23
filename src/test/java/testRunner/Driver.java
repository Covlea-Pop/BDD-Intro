package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {
    public static WebDriver driver;

    public void setUp() {
        driver = new ChromeDriver();
    }

    public void openWebsite(String urlName) {
        driver.get(urlName);
    }

    public void tearDown() {
        driver.quit();
    }
}
