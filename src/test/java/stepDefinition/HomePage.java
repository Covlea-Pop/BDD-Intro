package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import testRunner.Driver;

import static org.junit.Assert.assertEquals;

public class HomePage extends Driver {
    @Given("I open the browser")
    public void i_open_the_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @When("I put the URL name")
    public void i_put_the_url_name() {
        driver.get("https://demo.nopcommerce.com/");

        }

    @Then("I can access the Home Page")
    public void i_can_access_the_home_page() {
        assertEquals(driver.getTitle(), "nopCommerce demo store");
        driver.quit();

    }




}
