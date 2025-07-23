package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    private WebDriver driver;
    private static final String SITE_URL = "https://www.mts.by";
    public static String testPhone = "297777777";
    public static String testSum = "100";

    @FindBy(xpath = "//button[@id='cookie-agree']")
    public WebElement cookieAgree;

    @FindBy(xpath = "//button[contains((@class), 'select__header')]")
    public WebElement communicationServicesBanner;

    @FindBy(xpath = "//p[contains(@class, 'select__option') and text()='Услуги связи']")
    public WebElement communicationServices;

    @FindBy(xpath = "//p[contains(@class, 'select__option') and text()='Домашний интернет']")
    public WebElement homeInternet;

    @FindBy(xpath = "//p[contains(@class, 'select__option') and text()='Рассрочка']")
    public WebElement installmentPlan;

    @FindBy(xpath = "//p[contains(@class, 'select__option') and text()='Задолженность']")
    public WebElement debt;

    @FindBy(id = "connection-phone")
    public WebElement phoneInput;

    @FindBy(id = "connection-sum")
    public WebElement sumInput;

    @FindBy(xpath = "//button[contains(.,'Продолжить')]")
    public WebElement continueButton;

    @FindBy(xpath = "//span[contains(text(), '100')]")
    public WebElement paymentSum;

    @FindBy(xpath = "//button[normalize-space()='Оплатить 100.00 BYN']")
    public WebElement paymentButtonSum;

    @FindBy(xpath = "//span[contains(text(), '375297777777')]")
    public WebElement paymentPhoneInfo;

    @FindBy(xpath = "//label[contains(.,'Номер карты')]")
    public WebElement cardNumber;

    @FindBy(xpath = "//label[contains(.,'Срок действия')]")
    public WebElement expiryDate;

    @FindBy(xpath = "//label[contains(.,'CVC')]")
    public WebElement cvc;

    @FindBy(xpath = "//label[contains(.,'Имя и фамилия')]")
    public WebElement cardName;

    @FindBy(xpath = "//img[contains(@src, 'visa-system.svg')]")
    public WebElement visaCardIcon;

    @FindBy(xpath = "//img[contains(@src, 'mastercard-system.svg')]")
    public WebElement mastercardIcon;

    @FindBy(xpath = "//img[contains(@src, 'belkart-system.svg')]")
    public WebElement belkartIcon;

    @FindBy(xpath = "//img[contains(@src, 'mir-system-ru.svg')]")
    public WebElement mirCard;



    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get(SITE_URL);
    }

    public void closeCookie() {
        try {
            cookieAgree.click();
        } catch(Exception e) {
            System.out.println("Cookie banner not found");
        }
    }

    public void selectCommunicationServices() {
        communicationServicesBanner.click();
        communicationServices.click();
    }

    public void selectHomeInternet() {
        communicationServicesBanner.click();
        homeInternet.click();
    }

    public void selectInstallmentPlan() {
        communicationServicesBanner.click();
        installmentPlan.click();
    }

    public void selectDebt() {
        communicationServicesBanner.click();
        debt.click();
    }

    public void fillPhoneNumber() {
        try {
            Thread.sleep(500); // небольшая задержка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phoneInput.click();
        phoneInput.sendKeys(testPhone);
    }

    public void fillSum() {
        try {
            Thread.sleep(500); // небольшая задержка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sumInput.click();
        sumInput.sendKeys(testSum);
    }

    public void clickContinue() {
        continueButton.click();
    }
}