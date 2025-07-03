package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SupportTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void supportTest() {
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();

        assertTrue(anonymRecoveryPage.supportChatOpened(), "Чат поддержки не открылся");

        anonymRecoveryPage.closeChat();
        anonymRecoveryPage.yesClose();
    }
}
