package com.cmccarthy.ui.utils;

import com.cmccarthy.ui.utils.expectedConditions.*;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.NoSuchElementException;


@Component
public class DriverWait {

    private final Logger logger = LoggerFactory.getLogger(DriverWait.class);

    private final DriverManager driverManager;

    @Autowired
    public DriverWait(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void waitForAngular() {
        waitUntilAngularReady();
    }

    public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {

        waitForElementVisible(element);
        waitForElementClickable(element);
    }

    public void waitForElementToLoad(By locator) throws NoSuchFieldException {

        waitForElementVisible(locator);
        waitForElementClickable(locator);
    }

    /**
     * Wait for Angular loads using Ng Driver
     */
    private void ngDriverWait() {
        final NgWebDriver ngWebDriver = new NgWebDriver(driverManager.getDriver());
        try {
            ngWebDriver.waitForAngularRequestsToFinish();
        } catch (ScriptTimeoutException exception) {
            logger.info("Problems waiting for Angular to load with NgWeb Driver");
            logger.debug("Problems waiting for Angular to load with NgWeb Driver");
        }
    }

    /**
     * wait for element visible by element
     */
    private void waitForElementVisible(WebElement element) {
        try {
            waitLong().until(new VisibilityOfElement(element));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element visible by locator
     */
    private void waitForElementVisible(By locator) {
        try {
            waitLong().until(new VisibilityOfElementByLocator(locator));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    private void waitForElementInVisible(By locator) {
        try {
            new InvisibilityOfElementByLocator(locator);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    private void waitForElementInVisible(WebElement element) {
        try {
            new InvisibilityOfElement(element);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element clickable by element
     */
    private void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            new ClickabilityOfElement(element);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element " + element);
        }
    }

    /**
     * wait for element clickable by locator
     */
    private void waitForElementClickable(By locator) throws NoSuchFieldException {
        try {
            new ClickabilityOfElementByLocator(locator);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element by locator " + locator);
        }
    }

    public Wait<ChromeDriver> waitLong() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutLong))
                .pollingEvery(Duration.ofMillis(Constants.pollingLong))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public Wait<ChromeDriver> waitShort() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofMillis(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    private void waitUntilAngularReady() {

        final Boolean angularUnDefined = (Boolean) driverManager.getDriver()
                .executeScript("return window.angular === undefined");

        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) driverManager.getDriver()
                    .executeScript("return angular.element(document).injector() === undefined");
            if (!angularInjectorUnDefined) {
                waitForAngularLoad();
                waitUntilJSReady();
                waitForJQueryLoad();
                ngDriverWait();
            }
        }
    }

    private void waitForAngularLoad() {

        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        final ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(
                (driverManager.getDriver()).executeScript(angularReadyScript).toString());

        boolean angularReady = Boolean
                .parseBoolean(driverManager.getDriver().executeScript(angularReadyScript).toString());

        if (!angularReady) {
            waitLong().until(angularLoad);
        }
    }

    private void waitUntilJSReady() {
        final ExpectedCondition<Boolean> jsLoad = driver -> (driverManager.getDriver())
                .executeScript("return document.readyState")
                .toString()
                .equals("complete");

        boolean jsReady = driverManager.getDriver().executeScript("return document.readyState")
                .toString().equals("complete");

        if (!jsReady) {
            waitLong().until(jsLoad);
        }
    }

    private void waitForJQueryLoad() {
        final ExpectedCondition<Boolean> jQueryLoad = driver -> (
                (Long) (driverManager.getDriver()).executeScript("return jQuery.active") == 0);

        boolean jqueryReady = (Boolean) driverManager.getDriver()
                .executeScript("return jQuery.active==0");

        if (!jqueryReady) {
            waitLong().until(jQueryLoad);
        }
    }
}
