package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final SelenideElement usernameField = $("[name='st.email']");
    private final SelenideElement passwordField = $("[name='st.password']");
    private final SelenideElement loginButton = $("[data-l='t,sign_in']");
    private final SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private final SelenideElement registrationButton = $x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");

    private final SelenideElement vkButton = $("[data-l='t,vkc']");
    private final SelenideElement yandexButton = $("[data-l='t,yandex']");
    private final SelenideElement mailRuButton = $("[data-l='t,mailru']");

    private final SelenideElement errorMessage = $("div.input-e.login_error");

    {
        verifyPageElements(); 
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и паролем")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт только с логином: {username}")
    public void loginUser(String username) {
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт только с паролем")
    public void loginPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВК")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через яндекс")
    public void loginWithYandex() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через mail.ru")
    public void loginWithMailRu() {
        mailRuButton.shouldBe(visible).click();
    }
}
