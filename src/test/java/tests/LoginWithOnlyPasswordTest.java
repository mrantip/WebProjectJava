package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithOnlyPasswordTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
//        loginPage.acceptCookie();
//        loginPage.acceptPrivacy();
    }

    @Test
    public void loginWithOnlyPasswordTest() {
        loginPage.loginPassword("incorrectPassword");

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке не отображается");

        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
