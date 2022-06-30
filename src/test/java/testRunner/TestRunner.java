package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {
                "Features/HomePage.feature",
                "Features/CompleteOrder.feature",
                "Features/GiftCard.feature",
                "Features/WishList.feature"

        },
        plugin = {
                "pretty",
                "json:target/report.json",
                "html:target/report.html"
        },
        glue = "stepDefinition"


)

public class TestRunner {
}
