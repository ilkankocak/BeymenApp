package org.example;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.appium.java_client.AppiumDriver;


import java.time.Duration;

import static org.example.BaseTest.appiumDriver;

public class StepImplementation {

    public static Logger logger = LogManager.getLogger(StepImplementation.class);
    Actions actions;

    FluentWait<AppiumDriver> wait = new FluentWait<>(appiumDriver);

    public StepImplementation() {
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(appiumDriver);
    }

    @Step("<id> li elementin oldugu kontrol edilir")
    public void checkElement(String element) {


        logger.info("Elementi gördü");
    }

    @Step("<id> id'li elemente tikla")
    public void click(String element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).click();
        logger.info(element + "tiklandi");
    }

    @Step("<element> xpath'li elemente tikla")
    public void clickXpath(String element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();
        logger.info(element + "tiklandi");
    }

    @Step("<id> id'li elemente <text> text degerini gonder")
    public void sendKeys(String id, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(text);
        logger.info(text + "degeri gonderildi");
         actions.sendKeys(Keys.ENTER).build().perform();


    }

    @Step("<id> id'li elementin geldiğini kontrol et")
    public void control(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

    }
}