package myStepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class steps {
    WebDriver driver;
    //  This works for the first part very well --> Basketball Feature

    @io.cucumber.java.en.Given("I use {string} as a browser")
    public void iUseAsABrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @io.cucumber.java.en.And("I navigate to basketball website {string}")
    public void iNavigateToBasketballWebsite(String arg0) {
        //Wait method - Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }

    @io.cucumber.java.en.When("I enter my date of birth {string}")
    public void iEnterMyDateOfBirth(String dateOfBirth) {
        //Wait for the logo - Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/BE-LOGO-BE-INSPIRED.svg']")));
        System.out.println("The Logo is found and shown. We continue testing");
        driver.findElement(By.cssSelector("input[name='DateOfBirth']")).sendKeys(dateOfBirth);
    }

    @io.cucumber.java.en.And("I enter my first name {string}")
    public void iEnterMyFirstName(String firstName) {
        driver.findElement(By.cssSelector("input[name='Forename']")).sendKeys(firstName);
    }

    @io.cucumber.java.en.And("I enter my last name {string}")
    public void iEnterMyLastName(String lastName) {
        driver.findElement(By.cssSelector("input[name='Surname']")).sendKeys(lastName);
    }

    @io.cucumber.java.en.And("I enter my email address {string}")
    public void iEnterMyEmailAddress(String email) {
        driver.findElement(By.cssSelector("input[id='member_emailaddress']")).sendKeys(email);
    }

    @io.cucumber.java.en.And("I confirm my email address {string}")
    public void iConfirmMyEmailAddress(String confirmEmail) {
        driver.findElement(By.cssSelector("input[name='ConfirmEmailAddress']")).sendKeys(confirmEmail);
    }

    @io.cucumber.java.en.And("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        driver.findElement(By.cssSelector("input[name='Password']")).sendKeys(password);
    }

    @io.cucumber.java.en.And("I confirm my password {string}")
    public void iConfirmMyPassword(String confirmPassword) {
        driver.findElement(By.cssSelector("input[name='ConfirmPassword']")).sendKeys(confirmPassword);
    }

    @io.cucumber.java.en.And("I {string} Terms and Conditions")
    public void iTermsAndConditions(String tickSelector) {
        if (tickSelector.equalsIgnoreCase("tick")) {
            driver.findElement(By.xpath("//label[@for='sign_up_25']")).click();
        } else {
            System.out.println("Terms and Condition must be checked");
        }
    }
//    This works for Terms and Conditions
//    @io.cucumber.java.en.And("I tick Terms and Conditions")
//    public void iTickTermsAndConditions() {
//
//        driver.findElement(By.xpath("//label[@for='sign_up_25']")).click();
//    }

    @io.cucumber.java.en.And("I tick I am adult")
    public void iTickIAmAdult() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
    }

    @io.cucumber.java.en.And("I tick code of ethics")
    public void iTickCodeOfEthics() {
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();
    }

    @io.cucumber.java.en.When("I press submission button")
    public void iPressSubmissionButton() throws InterruptedException {
        driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']")).click();
        Thread.sleep(2000);
    }

    @io.cucumber.java.en.Then("Registration is complete")
    public void registrationIsComplete() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND']"));
        assertTrue(confirmationMessage.isDisplayed());
        driver.quit();
    }
}