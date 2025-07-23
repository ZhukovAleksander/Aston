package org.example;

import io.qameta.allure.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@Epic("Тесты для онлайн-платежей MTS")
@Feature("Проверка блока пополнения баланса")
public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private MtsHomePage homePage;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        homePage = new MtsHomePage(driver);
        homePage.closeCookie();
    }

    @Test
    @DisplayName("Проверка заголовка блока пополнения")
    @Order(1)
    public void testOnlinePaymentTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualTitle = homePage.getOnlineReplenishTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает");
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем на главном экране")
    @Order(2)
    public void testPaymentLogos() {
        homePage.verifyPaymentLogos();
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Подробнее о сервисе'")
    @Order(3)
    public void testDetailsLink() {
        homePage.clickDetailsLink();
        Assertions.assertTrue(driver.getCurrentUrl().contains("internet-platezhey"),
                "URL не соответствует странице описания сервиса");
        driver.navigate().back();
    }

    @Test
    @DisplayName("Проверка полей карты в форме оплаты в фрейме")
    @Order(4)
    public void testPaymentFormFields() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentFormFields();

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка лого карт в форме оплаты в фрейме")
    @Order(5)
    public void testCardLogos() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyCardLogos();

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка формы оплаты в фрейме")
    @Order(6)
    public void testPaymentSum() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentSum("100.00 BYN");

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка формы оплаты на кнопке в фрейме")
    @Order(7)
    public void testPaymentButtonSum() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentButtonSum("Оплатить 100.00 BYN");

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка номера телефона в форме оплаты в фрейме")
    @Order(8)
    public void testPhoneNumber() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPhoneNumber("Оплата: Услуги связи Номер:375297777777");

        paymentFrame.switchToDefaultContent();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

//mvn clean test allure:serve