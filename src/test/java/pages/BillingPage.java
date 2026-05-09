package pages;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingPage extends BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BillingPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    public void addService() {

        // Expand billing panel
        By expandBtn = By.id("expand");
        wait.until(ExpectedConditions.presenceOfElementLocated(expandBtn));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expandBtn));

        WebElement expand = wait.until(ExpectedConditions.elementToBeClickable(expandBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", expand);
        // Select Service
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lineItem"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lineItemTypeSpanService"))).click();

        // Search service
        WebElement lineItemInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("lineItem")));
        lineItemInput.clear();
        lineItemInput.sendKeys("125 Hydroxy vitamin D");

        By serviceLocator = By.xpath("//div[contains(@id,'itemCategoryMainDIV_') and contains(text(),'125 Hydroxy vitamin D')]");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("itemCategoryMainDIV_125 Hydroxy vitamin D"))).click();

        // Add service
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addLineItemBtn"))).click();
    }

    public void addMultipleServices(String... services) {

        for (String serviceName : services) {

            // Select Service
            wait.until(ExpectedConditions.elementToBeClickable(By.id("lineItem"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("lineItemTypeSpanService"))).click();

            // Search service
            WebElement lineItemInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("lineItem")));
            lineItemInput.clear();
            lineItemInput.sendKeys(serviceName);

            // Select service from list
            By serviceLocator = By.xpath("//div[contains(@id,'itemCategoryMainDIV_') and contains(text(),'" + serviceName + "')]");

            wait.until(ExpectedConditions.elementToBeClickable(serviceLocator)).click();

            // Add service
            wait.until(ExpectedConditions.elementToBeClickable(By.id("addLineItemBtn"))).click();

            // 🔥 Handle duplicate alert if service already added
            handleDuplicateServiceAlert();

            waitForLoaderToDisappear();
        }
    }
}
