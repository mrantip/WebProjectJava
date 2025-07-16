package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryMailPage;
import core.pages.AnonymRecoveryPage;
import core.pages.AnonymRecoveryPhonePage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static AnonymRecoveryPhonePage anonymRecoveryPhonePage;
    private static AnonymRecoveryMailPage anonymRecoveryMailPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.loginPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPhonePage = new AnonymRecoveryPhonePage();
        anonymRecoveryPhonePage.setPhone("6787655");
        String countryCode = anonymRecoveryPhonePage.selectCountryByName("Перу");
        anonymRecoveryPhonePage.clickCodeButton();
        assertEquals("+51", countryCode, "Код страны не совпадает с ожидаемым");
    }

    @Test
    public void anonymRecoveryByWrongPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.loginPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPhonePage = new AnonymRecoveryPhonePage();
        anonymRecoveryPhonePage.clickCodeButton();
        anonymRecoveryPhonePage.isErrorMessageVisible();
        String errorMessagetext = anonymRecoveryPhonePage.getErrorMessageText();
        assertEquals("Неправильный номер телефона.", errorMessagetext);
    }

    @Test
    public void anonymRecoveryByEmailTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.loginPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();
        anonymRecoveryMailPage = new AnonymRecoveryMailPage();
        anonymRecoveryMailPage.setEmail("incorrectUser@incorrectPassword");
        anonymRecoveryMailPage.clickCodeButton();
    }

}
