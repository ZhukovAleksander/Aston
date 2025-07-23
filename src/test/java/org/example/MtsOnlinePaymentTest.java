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
    @Story("Пользователь видит корректный заголовок")
    @Severity(SeverityLevel.CRITICAL)
    public void testOnlinePaymentTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualTitle = homePage.getOnlineReplenishTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает");
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем")
    @Story("Пользователь видит все логотипы платежных систем")
    public void testPaymentLogos() {
        homePage.verifyPaymentLogos();
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Подробнее о сервисе'")
    @Story("Пользователь может перейти на страницу с описанием сервиса")
    public void testDetailsLink() {
        homePage.clickDetailsLink();
        Assertions.assertTrue(driver.getCurrentUrl().contains("internet-platezhey"),
                "URL не соответствует странице описания сервиса");
        driver.navigate().back();
    }

    @Test
    @DisplayName("Проверка формы оплаты в фрейме")
    @Story("Пользователь может заполнить форму и перейти к оплате")
    @Severity(SeverityLevel.BLOCKER)
    public void testPaymentForm() {
        MtsPaymentFrame paymentFrame = homePage.fillPaymentFormAndSubmit();

        paymentFrame.verifyPaymentFormFields();
        paymentFrame.verifyPaymentSum("100");

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