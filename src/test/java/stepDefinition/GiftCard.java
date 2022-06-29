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

public class GiftCard extends Driver{
    @Given("I chose the Gift Card option from the home page")
    public void i_chose_the_gift_card_option_from_the_home_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
       driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a")).click();


    }
    @When("I decide what Gift Card i want")
    public void i_decide_what_gift_card_i_want() {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();
    }
    @Then("I can add the Gift Card on shopping cart")
    public void i_can_add_the_gift_card_on_shopping_cart() throws InterruptedException {
        Thread.sleep(1000);
        WebElement recipientName;
        recipientName = driver.findElement(By.id("giftcard_43_RecipientName"));
        recipientName.sendKeys("cosmin");
        Thread.sleep(1000);
        WebElement recipientEmail;
        recipientEmail= driver.findElement(By.id("giftcard_43_RecipientEmail"));
        recipientEmail.sendKeys("cosmin@gmail.com");
        Thread.sleep(1000);
        WebElement name;
        name=driver.findElement(By.id("giftcard_43_SenderName"));
        name.sendKeys("cornel");
        Thread.sleep(1000);
        WebElement email;
        email= driver.findElement(By.id("giftcard_43_SenderEmail"));
        email.sendKeys("cornel@gmail.com");
        Thread.sleep(1000);
        WebElement message;
        message= driver.findElement(By.id("giftcard_43_Message"));
        message.sendKeys("Felicitari!");
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-button-43")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bar-notification\"]/div/span")));
        element.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        driver.getTitle();
        driver.quit();
    }

}
