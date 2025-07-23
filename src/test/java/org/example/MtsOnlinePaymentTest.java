package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private static final String TEST_PHONE = "297777777";
    private static final String TEST_SUM = "100";
    private static WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Locators.siteUrl);
        new WebDriverWait(driver, Duration.ofSeconds(15));
        closeCookie();
    }

    private void closeCookie() {
        try {
            WebElement acceptCookies = driver.findElement(Locators.cookieAgree);
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found");
        }
    }

    @Test
    @Order(1)
    public void testOnlinePaymentBlock() {
        WebElement titleElement = driver.findElement(Locators.onlineReplenishTitle);
        String actualText = titleElement.getText();
        String expectedText = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(expectedText, actualText, "Текст заголовка не совпадает");
    }

    @Test
    @Order(2)
    public void testOnlinePaymentLogo() {
        Assertions.assertTrue(driver.findElement(Locators.visaLogo).isDisplayed());
        Assertions.assertTrue(driver.findElement(Locators.verifiedByVisaLogo).isDisplayed());
        Assertions.assertTrue(driver.findElement(Locators.masterCardLogo).isDisplayed());
        Assertions.assertTrue(driver.findElement(Locators.masterCardSecureCodeLogo).isDisplayed());
        Assertions.assertTrue(driver.findElement(Locators.belcardLogo).isDisplayed());
    }

    @Test
    @Order(3)
    public void testOnlinePaymentBlockTitle() {
        WebElement detailsLink = driver.findElement(Locators.detailsLink);
        detailsLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "URL после перехода не соответствует ожидаемому");
        driver.navigate().back();
    }

    @Test
    @Order(4)
    public void testPaymentFormFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement phoneInput = driver.findElement(Locators.phoneInput);
        WebElement sumInput = driver.findElement(Locators.sumInput);
        WebElement continueButton = driver.findElement(Locators.continueButton);

        phoneInput.clear();
        phoneInput.sendKeys(TEST_PHONE);
        sumInput.clear();
        sumInput.sendKeys(TEST_SUM);
        continueButton.click();

        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.xpath("//iframe[contains(@class,'bepaid-iframe')]")));

            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cardNumberLabel));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.expiryDateLabel));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cvcLabel));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cardNameLabel));

            } catch (Exception e) {
            driver.switchTo().defaultContent();
            Assertions.fail("Не удалось найти платежный фрейм. Текущий URL: " + driver.getCurrentUrl());
        } finally {
            driver.switchTo().defaultContent();
        }
    }

        @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}