package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsHomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String TEST_PHONE = "297777777";
    public static final String TEST_SUM = "100";

    @FindBy(xpath = "//button[contains(@id, 'cookie-agree')]")
    private WebElement cookieAgree;

    @FindBy(xpath = "//div[contains(@class, 'pay__wrapper')]/h2")
    private WebElement onlineReplenishTitle;

    @FindBy(xpath = "//img[contains(@alt, 'Visa')]")
    private WebElement visaLogo;

    @FindBy(xpath = "//img[contains(@alt, 'Verified By Visa')]")
    private WebElement verifiedByVisaLogo;

    @FindBy(xpath = "//img[contains(@alt, 'MasterCard')]")
    private WebElement masterCardLogo;

    @FindBy(xpath = "//img[contains(@alt, 'MasterCard Secure Code')]")
    private WebElement masterCardSecureCodeLogo;

    @FindBy(xpath = "//img[contains(@alt, 'Белкарт')]")
    private WebElement belkartLogo;

    @FindBy(xpath = "//a[contains(@href, 'internet-platezhey')]")
    private WebElement detailsLink;

    @FindBy(id = "connection-phone")
    private WebElement phoneInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(xpath = "//button[text()='Продолжить']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[contains(@class, 'select__header')]")
    private WebElement selectHeader;

    //-------------------------Услуги связи-------------------------------------

    @FindBy(xpath = "//p[text()='Услуги связи']")
    private WebElement selectCommunicationServices;

    @FindBy(xpath = "//input[contains(@id, 'connection-phone')]")
    private WebElement connectionPhone;

    @FindBy(xpath = "//input[contains(@id, 'connection-sum')]")
    private WebElement connectionSum;

    @FindBy(xpath = "//input[contains(@id, 'connection-email')]")
    private WebElement connectionEmail;

    public void selectCommunicationServices() {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectCommunicationServices)).click();
    }

    public void verifyCommunicationServices() {
        wait.until(ExpectedConditions.visibilityOf(connectionPhone)).clear();
        wait.until(ExpectedConditions.visibilityOf(connectionSum)).clear();
        wait.until(ExpectedConditions.visibilityOf(connectionEmail)).clear();

        Assertions.assertEquals(
                "Номер телефона",
                connectionPhone.getAttribute("placeholder"),
                "Неверный placeholder у поля телефона"
        );

        Assertions.assertEquals(
                "Сумма",
                connectionSum.getAttribute("placeholder"),
                "Неверный placeholder у поля суммы"
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                connectionEmail.getAttribute("placeholder"),
                "Неверный placeholder у поля email"
        );
    }

    //-------------------------Домашний интернет----------------------------------

    @FindBy(xpath = "//p[text()='Домашний интернет']")
    private WebElement selectHomeInternet;

    @FindBy(xpath = "//input[contains(@id, 'internet-phone')]")
    private WebElement internetPhone;

    @FindBy(xpath = "//input[contains(@id, 'internet-sum')]")
    private WebElement internetSum;

    @FindBy(xpath = "//input[contains(@id, 'internet-email')]")
    private WebElement internetEmail;

    public void selectHomeInternet() {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectHomeInternet)).click();
    }

    public void verifyHomeInternet() {
        wait.until(ExpectedConditions.visibilityOf(internetPhone)).clear();
        wait.until(ExpectedConditions.visibilityOf(internetSum)).clear();
        wait.until(ExpectedConditions.visibilityOf(internetEmail)).clear();

        Assertions.assertEquals(
                "Номер абонента",
                internetPhone.getAttribute("placeholder"),
                "Неверный placeholder у поля телефона (интернет)"
        );

        Assertions.assertEquals(
                "Сумма",
                internetSum.getAttribute("placeholder"),
                "Неверный placeholder у поля суммы (интернет)"
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                internetEmail.getAttribute("placeholder"),
                "Неверный placeholder у поля email (интернет)"
        );
    }

    //-------------------------Рассрочка----------------------------------

    @FindBy(xpath = "//p[text()='Рассрочка']")
    private WebElement selectInstallmentPlan;

    @FindBy(xpath = "//input[contains(@id, 'score-instalment')]")
    private WebElement installmentScore;

    @FindBy(xpath = "//input[contains(@id, 'instalment-sum')]")
    private WebElement instalmentSum;

    @FindBy(xpath = "//input[contains(@id, 'instalment-email')]")
    private WebElement installmentEmail;

    public void selectInstallmentPlan() {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectInstallmentPlan)).click();
    }

    public void verifyInstallmentPlan() {
        wait.until(ExpectedConditions.visibilityOf(installmentScore)).clear();
        wait.until(ExpectedConditions.visibilityOf(instalmentSum)).clear();
        wait.until(ExpectedConditions.visibilityOf(installmentEmail)).clear();

        Assertions.assertEquals(
                "Номер счета на 44",
                installmentScore.getAttribute("placeholder"),
                "Неверный placeholder у поля номера счета (рассрочка)"
        );

        Assertions.assertEquals(
                "Сумма",
                instalmentSum.getAttribute("placeholder"),
                "Неверный placeholder у поля суммы (рассрочка)"
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                installmentEmail.getAttribute("placeholder"),
                "Неверный placeholder у поля email (рассрочка)"
        );
    }

    //-------------------------Задолженность----------------------------------
    @FindBy(xpath = "//p[text()='Задолженность']")
    private WebElement selectArrears;

    @FindBy(xpath = "//input[contains(@id, 'score-arrears')]")
    private WebElement arrearsScore;

    @FindBy(xpath = "//input[contains(@id, 'arrears-sum')]")
    private WebElement arrearsSum;

    @FindBy(xpath = "//input[contains(@id, 'arrears-email')]")
    private WebElement arrearsEmail;

    public void selectArrears() {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectArrears)).click();
    }

    public void verifyArrears() {
        wait.until(ExpectedConditions.visibilityOf(arrearsScore)).clear();
        wait.until(ExpectedConditions.visibilityOf(arrearsSum)).clear();
        wait.until(ExpectedConditions.visibilityOf(arrearsEmail)).clear();

        Assertions.assertEquals(
                "Номер счета на 2073",
                arrearsScore.getAttribute("placeholder"),
                "Неверный placeholder у поля номера счета (задолженность)"
        );

        Assertions.assertEquals(
                "Сумма",
                arrearsSum.getAttribute("placeholder"),
                "Неверный placeholder у поля суммы (задолженность)"
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                arrearsEmail.getAttribute("placeholder"),
                "Неверный placeholder у поля email (задолженность)"
        );
    }

    //--------------------------------------------------------------------------

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void closeCookie() {
        try {
            cookieAgree.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found");
        }
    }

    public String getOnlineReplenishTitle() {
        return onlineReplenishTitle.getText();
    }

    public void verifyPaymentLogos() {
        wait.until(ExpectedConditions.visibilityOf(visaLogo));
        wait.until(ExpectedConditions.visibilityOf(verifiedByVisaLogo));
        wait.until(ExpectedConditions.visibilityOf(masterCardLogo));
        wait.until(ExpectedConditions.visibilityOf(masterCardSecureCodeLogo));
        wait.until(ExpectedConditions.visibilityOf(belkartLogo));
    }

    public void clickDetailsLink() {
        detailsLink.click();
        wait.until(ExpectedConditions.urlContains("internet-platezhey"));
    }

    public MtsPaymentFrame fillPaymentFormAndSubmit() {
        phoneInput.sendKeys(TEST_PHONE);
        sumInput.sendKeys(TEST_SUM);
        continueButton.click();
        return new MtsPaymentFrame(driver);
    }
}