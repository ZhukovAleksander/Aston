package org.example;

import org.openqa.selenium.By;

public class Locators {
    public static String siteUrl = "https://www.mts.by";
    public static By cookieAgree = By.xpath("//button[contains(@id, 'cookie-agree')]");

    public static By onlineReplenish = By.xpath("//div[contains(@class, 'pay__wrapper')]");

    public static By visaLogo = By.xpath("//img[contains(@alt, 'Visa')]");
    public static By verifiedByVisaLogo = By.xpath("//img[contains(@alt, 'Verified By Visa')]");
    public static By masterCardLogo = By.xpath("//img[contains(@alt, 'MasterCard')]");
    public static By masterCardSecureCodeLogo = By.xpath("//img[contains(@alt, 'MasterCard Secure Code')]");
    public static By belcardLogo = By.xpath("//img[contains(@alt, 'Белкарт')]");

    public static By detailsLink = By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' and text()='Подробнее о сервисе']");

    public static By phoneInput = By.xpath("//input[@id='connection-phone']");
    public static By sumInput = By.xpath("//input[@id='connection-sum']");
    public static By continueButton = By.xpath("//button[text()='Продолжить']");
}