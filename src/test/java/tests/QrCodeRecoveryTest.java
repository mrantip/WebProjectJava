package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryMailPage;
import core.pages.AnonymRecoveryPage;
import core.pages.AnonymRecoveryPhonePage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QrCodeRecoveryTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void checkQrCodeRecoveryTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.loginPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        assertTrue(anonymRecoveryPage.isQrCodeVisible(),"QR-code не отображается");
    }
}
