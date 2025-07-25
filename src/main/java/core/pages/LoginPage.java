package core.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import core.base.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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
    private SelenideElement goToRecoveryButton = $("[value='st.go_to_recovery']");

    private SelenideElement searchField = $("input[data-uikit-old='Input']");

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
        searchField.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
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

    @Step("Входим на сайт только с {password}")
    public void loginPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
        //loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickLogin() {
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

    @Step("Нажимаем Восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Вводим текст в поле поиска")
    public void inputSearchText(String searchText) {
        searchField.shouldBe(visible).sendKeys(searchText);
    }

    @Step("Выбираем один из результатов поиска")
    public void selectSearchResult() {
        //inputSearchText(searchText);
        SelenideElement result = $("a.suggest-item__zd7xg").shouldBe(visible);
        $$("a.suggest-item__zd7xg").get(0).click();
    }

    @Step("Проверяем что выполнен переход на нужную страницу")
    public void checkTransferPage(String page) {
        Selenide.webdriver().shouldHave(WebDriverConditions.url(page));
    }
}
