package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class SignupSteps {
    WebDriver driver;

    @Given("I am on the signup page")
    public void i_am_on_the_signup_page() {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://example.com/signup");
    }

    @When("I enter a valid email and password")
    public void i_enter_a_valid_email_and_password() {
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
    }

    @When("I confirm the password correctly")
    public void i_confirm_the_password_correctly() {
        driver.findElement(By.id("confirm_password")).sendKeys("Password123");
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        WebElement message = driver.findElement(By.id("success_message"));
        assert message.getText().equals("Account created successfully!");
        driver.quit();
    }

    @When("I enter an email that is already registered")
    public void i_enter_an_email_that_is_already_registered() {
        driver.findElement(By.id("email")).sendKeys("existing@example.com");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        WebElement message = driver.findElement(By.id("error_message"));
        assert message.getText().equals(expectedMessage);
        driver.quit();
    }
}
