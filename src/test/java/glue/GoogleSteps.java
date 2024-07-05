package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GoogleSteps {
	
	

    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }

    private static void acceptCookiesIfWarned() {
        try {
            W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
        } catch (NoSuchElementException ignored) {
        }
    }

    @When("About page is shown")
    public void clickOnAboutClick() throws InterruptedException {
    	W.get().driver.findElement(By.linkText("About")).click();
    	 Thread.sleep(1000);
    }

    @Then("page displays {string}")
    public void page_displays(String headerTxt) {
    	String heading = W.get().driver.findElement(By.xpath("//h1")).getText();
    	assertTrue(heading.equalsIgnoreCase(headerTxt));
    }

    @When("searching for {string}")
    public void searchingTxt(String searchText) {
    	 WebElement searchBox =  W.get().driver.findElement(By.name("q"));
         searchBox.sendKeys(searchText);
         searchBox.submit();

    }

    @Then("results contain {string}")
    public void verifyResults(String title) {
    	WebElement pTitle = W.get().driver.findElement(By.xpath("//h3[text()='"+title+"']"));
    	assertTrue(pTitle.isDisplayed());
    }

    @Then("result stats are displayed")
    public void resultstatsDisplayed() {
    	WebElement resultStats = W.get().driver.findElement(By.id("result-stats"));
        assertTrue(resultStats!=null);
    }

    @Then("number of {string} is more than {int}")
    public void numberOfIsMoreThan(String text, Integer value) throws InterruptedException {
    	
    	if(text.equalsIgnoreCase("seconds")) {
        	Instant start = Instant.now();
            Thread.sleep(1000); 
            Instant end = Instant.now();
            long elapsedTimeSeconds = Duration.between(start, end).getSeconds();
            assertTrue(elapsedTimeSeconds > value);
        }else {
        	int resultsCount = W.get().driver.findElements(By.xpath("//div[@id='rso']/div")).size();
            assertTrue(resultsCount>value);
        }
    }
}
