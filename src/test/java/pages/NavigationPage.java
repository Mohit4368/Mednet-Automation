package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {

    WebDriver driver;
    WebDriverWait wait;

    public NavigationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToOPD() {
        driver.navigate().refresh();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("menuDept"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("RECEPTION"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cashCounterDIV"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='MAIN CASH COUNTER']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Outpatient"))).click();
    }
}
