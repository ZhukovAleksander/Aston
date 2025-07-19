package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MtsOnlinePaymentTest {
    public static WebDriver driver;
    public static String TestPhone = "297777777";
    public static String TestSum = "100";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Locators.siteUrl);
        closeCookie();
    }

    public static void closeCookie() {
        try {
            WebElement acceptCookies = driver.findElement(Locators.cookieAgree);
            acceptCookies.click();
        } catch(Exception e) {
            System.out.println("Cookie banner not found");
        }
    }

    @Test
    @Order(1)
    public void testOnlinePaymentBlock() {
        WebElement blockTitle = driver.findElement(Locators.onlineReplenish);
        Assertions.assertTrue(blockTitle.isDisplayed());
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
        driver.navigate().back();
    }

    @Test
    @Order(4)
    public void testLogin() {
        WebElement phoneInput = driver.findElement(Locators.phoneInput);
        WebElement sumInput = driver.findElement(Locators.sumInput);
        WebElement continueButton = driver.findElement(Locators.continueButton);
        phoneInput.click();
        phoneInput.sendKeys(TestPhone);
        sumInput.click();
        sumInput.sendKeys(TestSum);
        continueButton.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}