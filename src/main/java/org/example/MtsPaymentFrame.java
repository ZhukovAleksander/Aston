package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPaymentFrame {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//label[contains(.,'Номер карты')]")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "//label[contains(.,'Срок действия')]")
    private WebElement expiryDateLabel;

    @FindBy(xpath = "//span[contains(text(), '100')]")
    private WebElement paymentSum;

    public MtsPaymentFrame(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        switchToFrame();
    }

    private void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@class,'bepaid-iframe')]")));
    }

    public void verifyPaymentFormFields() {
        wait.until(ExpectedConditions.visibilityOf(cardNumberLabel));
        wait.until(ExpectedConditions.visibilityOf(expiryDateLabel));
    }

    public void verifyPaymentSum(String expectedSum) {
        String actualSum = paymentSum.getText();
        if (!actualSum.contains(expectedSum)) {
            throw new AssertionError("Ожидаемая сумма: " + expectedSum + ", но найдено: " + actualSum);
        }
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}