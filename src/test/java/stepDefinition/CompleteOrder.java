package stepDefinition;

import io.cucumber.java.en.Given;
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

public class CompleteOrder extends Driver {


    @Given("I chose a product from the product list")
    public void I_chose_a_product_from_the_product_list() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]")).click();

    }

    @When("I put the product on the shopping cart")
    public void I_put_the_product_on_the_shopping_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-button-4\"]")));
        element.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/div/span")));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bar-notification\"]/div/span"))).click();
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();


    }


    @When("I can complete the order")
    public void I_can_complete_the_order() {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("cosmin");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("cornel");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("cosmin@gmail.com");
        Select drpCountry = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        drpCountry.selectByVisibleText("Romania");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Arad");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Arad");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("123456789");
        driver.findElement(By.name("save")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")));
        element.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")));
        element1.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")));
        element2.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")));
        element3.click();
        assertEquals(driver.getTitle(), "nopCommerce demo store. Checkout");
        driver.quit();


    }
}
