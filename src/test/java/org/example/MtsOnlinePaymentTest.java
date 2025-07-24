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
        driver.manage().deleteAllCookies();
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
    @DisplayName("Проверка кликабельности кнопки 'Продолжить'")
    @Order(4)
    public void testContinueButton() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentFormFields();

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка пустых полей в окне 'Услуги связи'")
    @Order(5)
    public void testCommunicationServices() {
        homePage.selectCommunicationServices();

        homePage.verifyCommunicationServices();
    }

    @Test
    @DisplayName("Проверка пустых полей в окне 'Домашний интернет'")
    @Order(6)
    public void testHomeInternet() {
        homePage.selectHomeInternet();

        homePage.verifyHomeInternet();
    }

    @Test
    @DisplayName("Проверка пустых полей в окне 'Рассрочка'")
    @Order(7)
    public void testInstallmentPlan() {
        homePage.selectInstallmentPlan();

        homePage.verifyInstallmentPlan();
    }

    @Test
    @DisplayName("Проверка пустых полей в окне 'Задолженность'")
    @Order(8)
    public void testArrears() {
        homePage.selectArrears();

        homePage.verifyArrears();
    }

    @Test
    @DisplayName("Проверка полей карты в форме оплаты в фрейме")
    @Order(9)
    public void testPaymentFormFields() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentFormFields();

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка лого карт в форме оплаты в фрейме")
    @Order(10)
    public void testCardLogos() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyCardLogos();

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка цены в форме оплаты в фрейме")
    @Order(11)
    public void testPaymentButtonSum() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentButtonSum("Оплатить 100.00 BYN");
        paymentFrame.verifyPaymentSum("100.00 BYN");

        paymentFrame.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка номера телефона в форме оплаты в фрейме")
    @Order(12)
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