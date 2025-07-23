package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private static final String TEST_PHONE = "297777777";
    private static final String TEST_SUM = "100";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Locators.siteUrl);
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
        phoneInput.sendKeys(TEST_PHONE);
        sumInput.click();
        sumInput.sendKeys(TEST_SUM);
        continueButton.click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}