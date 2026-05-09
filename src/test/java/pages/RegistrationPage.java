package pages;

import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Random random = new Random();

    public RegistrationPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    public void registerNewPatient() {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("mrnSearch"))).click();

        String randomName = "TestPatient" + random.nextInt(1000);
        WebElement patientName = wait.until(ExpectedConditions.elementToBeClickable(By.id("patientName")));
        patientName.clear();
        patientName.sendKeys(randomName);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@onclick, 'searchPatientByClick')])[2]"))).click();
        int randomAge = 18 + random.nextInt(43);
        By newRegBtn = By.id("btnNewReg_0");
        wait.until(ExpectedConditions.elementToBeClickable(newRegBtn)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("regnNBillNameTitle"))).sendKeys("Mr.");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("regnGender"))).sendKeys("Male");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ageRegnNBill")))
                .sendKeys(String.valueOf(20 + random.nextInt(40)));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("patientCategoryRegnNBill")))
                .sendKeys("PAYING", Keys.TAB);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("departmentRegnNBill")))
                .sendKeys("AUDIOLOGY");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='AUDIOLOGY']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("doctorRegnNBill")))
                .sendKeys("%");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("doctorCOdeListDIV_S16230"))).click();

        actions.sendKeys(Keys.TAB).perform();

//        wait.until(ExpectedConditions.elementToBeClickable(By.id("healthPackageBtn"))).click();
        WebElement pkgBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("healthPackageBtn")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pkgBtn);

    }
}
