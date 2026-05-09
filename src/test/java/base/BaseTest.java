package base;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Random random = new Random();

    @BeforeClass
    public void launchApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);

        driver.manage().window().maximize();
        driver.get("https://stage.mednetlabs.com/");
    }

    protected void handleDuplicateServiceAlert() {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            Alert alert = alertWait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Duplicate service alert shown");
            alert.accept();
        } catch (Exception e) {
            // No alert → service added successfully
        }
    }

    public void waitForLoaderToDisappear() {
        try {
            WebDriverWait loaderWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            loaderWait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id("mednetProgressBar")
            ));
        } catch (Exception e) {
            // ignore
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
