package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;
    protected Logger logger;

    protected BasePage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    protected void clickElement(By locator) {
        logger.debug("Clicking element with locator: " + locator.toString());
        waitForElementToBeVisibleAndClickable(locator);
        driver.findElement(locator).click();
    }

    protected void fillInInput(By locator, String input) {
        logger.debug("Filling in input of element with locator: " + locator.toString() + " with text: " + input);
        waitForElementToBeVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(input);
    }

    protected String getCSSValue(By locator, String attribute) {
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).getCssValue(attribute);
    }

    protected void waitForElementToBeVisibleAndClickable(By locator) {
        waitFor(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)));
    }

    protected void waitForElementToBeVisible(By locator) {
        waitFor(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeInvisible(By locator) {
        waitFor(DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    private FluentWait<WebDriver> waitFor(int timeoutSeconds) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
