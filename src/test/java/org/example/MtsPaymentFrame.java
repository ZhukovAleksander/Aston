package org.example;

import org.junit.jupiter.api.Assertions;
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

    // Локаторы с normalize-space в XPath
    @FindBy(xpath = "//label[normalize-space()='Номер карты']")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "//label[normalize-space()='Срок действия']")
    private WebElement expiryDateLabel;

    @FindBy(xpath = "//label[normalize-space()='Имя и фамилия на карте']")
    private WebElement nameLabel;

    @FindBy(xpath = "//label[normalize-space()='CVC']")
    private WebElement cvcLabel;

    @FindBy(xpath = "//span[contains(normalize-space(), 'BYN')]")
    private WebElement paymentSum;

    @FindBy(xpath = "//button[contains(normalize-space(), 'BYN')]")
    private WebElement paymentSumButton;

    @FindBy(xpath = "//span[contains(normalize-space(), 'Оплата: Услуги связи')]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//img[contains(@src, 'visa-system.svg')]")
    private WebElement visaIcon;

    @FindBy(xpath = "//img[contains(@src, 'mastercard-system.svg')]")
    private WebElement mastercardIcon;

    @FindBy(xpath = "//img[contains(@src, 'belkart-system.svg')]")
    private WebElement belcartIcon;

    @FindBy(xpath = "//img[contains(@src, 'maestro-system.svg')]")
    private WebElement maestroIcon;

    @FindBy(xpath = "//img[contains(@src, 'mir-system-ru.svg')]")
    private WebElement mirIcon;

    @FindBy(xpath = "//iframe[contains(@class,'bepaid-iframe')]")
    private WebElement paymentFrame;

    public MtsPaymentFrame(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        switchToFrame();
    }

    private void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
    }

    public void verifyPaymentFormFields() {
        wait.until(ExpectedConditions.visibilityOf(cardNumberLabel));
        wait.until(ExpectedConditions.visibilityOf(expiryDateLabel));
        wait.until(ExpectedConditions.visibilityOf(nameLabel));
        wait.until(ExpectedConditions.visibilityOf(cvcLabel));
    }

    public void verifyCardLogos() {
        wait.until(ExpectedConditions.visibilityOf(visaIcon));
        wait.until(ExpectedConditions.visibilityOf(mastercardIcon));
        wait.until(ExpectedConditions.visibilityOf(belcartIcon));
        wait.until(ExpectedConditions.visibilityOf(maestroIcon));
        wait.until(ExpectedConditions.visibilityOf(mirIcon));
    }

    public void verifyPaymentSum(String expectedSum) {
        wait.until(ExpectedConditions.visibilityOf(paymentSum));
        String actualSum = paymentSum.getText().trim();
        Assertions.assertEquals(expectedSum, actualSum,
                "Неверная сумма");
    }

    public void verifyPhoneNumber(String expectedPhoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));
        String actualPhone = phoneNumber.getText().trim();
        Assertions.assertEquals(expectedPhoneNumber, actualPhone,
                "Неверный номер телефона");
    }

    public void verifyPaymentButtonSum(String expectedSum) {
        wait.until(ExpectedConditions.visibilityOf(paymentSumButton));
        String buttonText = paymentSumButton.getText().trim();
        Assertions.assertEquals(expectedSum, buttonText,
                "Неверная сумма на кнопке оплаты");
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}