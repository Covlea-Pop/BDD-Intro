package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testRunner.Driver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class MenuButtons extends Driver {

    @Given("I open the homepage")
    public void i_open_the_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @When("I click on all the buttons from menu")
    public void i_click_on_all_the_buttons_from_menu()  {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        String message = driver.getTitle();
        System.out.println(message);
       driver.navigate().back();
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
       driver.getTitle();
       driver.navigate().back();
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a")).click();
       driver.getTitle();
       driver.navigate().back();
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a")).click();
       driver.getTitle();
       driver.navigate().back();
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a")).click();
       driver.getTitle();
       driver.navigate().back();
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a")).click();
       driver.getTitle();
       driver.navigate().back();
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a")).click();
       driver.getTitle();
       driver.navigate().back();

    }
    @Then("I can interact with all of them")
    public void i_can_interact_with_all_of_them() {
        System.out.println();
    }

}
