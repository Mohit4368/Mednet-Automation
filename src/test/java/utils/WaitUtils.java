package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForLoaderToDisappear(WebDriver driver, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id("mednetProgressBar")));
        } catch (Exception ignored) {}
    }
}
