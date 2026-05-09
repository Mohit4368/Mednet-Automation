package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class ReceiptPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ReceiptPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    public void makeReceiptAndLock() {

        WaitUtils.waitForLoaderToDisappear(driver, wait);

        By receiptBtn = By.xpath("//div[@id='patientBillReceiptBtnDIV']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(receiptBtn));

        WebElement receipt = driver.findElement(receiptBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", receipt);
        WaitUtils.waitForLoaderToDisappear(driver, wait);

        By saveBtn = By.id("paymentSaveBtnDIV");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        WebElement save = driver.findElement(saveBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
        WaitUtils.waitForLoaderToDisappear(driver, wait);

        By lockBtn = By.id("unlockBtn");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lockBtn));
        WebElement lock = driver.findElement(lockBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lock);
        WaitUtils.waitForLoaderToDisappear(driver, wait);
    }
}
