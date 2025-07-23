package org.example;

import io.qameta.allure.Epic;
import io.qameta.allure.junit5.AllureJunit5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(AllureJunit5.class)
@Epic("Тесты для авторизации")
public class MtsOnlinePaymentTest {
    public static WebDriver driver;
    private static PageObject paymentPage;
    private static final String SITE_URL = "https://www.mts.by";
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(SITE_URL);
        paymentPage = new PageObject(driver);
        paymentPage.closeCookie();
    }

    @Test
    @Order(1)
    @DisplayName("Проверка вкладки 'Услуги связи'")
    public void checkCommunicationServicesLabels() {
        paymentPage.selectCommunicationServices();
    }

    @Test
    @Order(2)
    @DisplayName("2 тест")
    public void checkHomeInternetLabels() {
        paymentPage.selectHomeInternet();
    }

    @Test
    @Order(3)
    @DisplayName("3 тест")
    public void checkInstallmentPlanLabels() {
        paymentPage.selectInstallmentPlan();
    }

    @Test
    @Order(4)
    @DisplayName("4 тест")
    public void checkDebtLabels() {
        paymentPage.selectDebt();
    }

    @Test
    @Order(5)
    @DisplayName("5 тест")
    public void testCommunicationServicesPayment() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        paymentPage.selectCommunicationServices();
        paymentPage.fillPhoneNumber();
        paymentPage.fillSum();

        paymentPage.clickContinue();

        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.xpath("//iframe[contains(@class,'bepaid-iframe')]")));

            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.paymentSum)).isDisplayed(),
                    "Не отображается сумма платежа");
            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.paymentButtonSum)).isDisplayed(),
                    "Не отображается кнопка оплаты");
            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.paymentPhoneInfo)).isDisplayed(),
                    "Не отображается номер телефона");

            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.cardNumber)).isDisplayed(),
                    "Не отображается поле 'Номер карты'");
            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.expiryDate)).isDisplayed(),
                    "Не отображается поле 'Срок действия'");
            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.cvc)).isDisplayed(),
                    "Не отображается поле 'CVC'");
            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.cardName)).isDisplayed(),
                    "Не отображается поле 'Имя и фамилия'");

            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.visaCardIcon)).isDisplayed(),
                    "Не отображается VISA");

            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.belkartIcon)).isDisplayed(),
                    "Не отображается Belkart");

            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.mastercardIcon)).isDisplayed(),
                    "Не отображается mastercard");

            assertTrue(wait.until(ExpectedConditions.visibilityOf(paymentPage.mirCard)).isDisplayed(),
                    "Не отображается MIR");

        } finally {
            driver.navigate().refresh();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}