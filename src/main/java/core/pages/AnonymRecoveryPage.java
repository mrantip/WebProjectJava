package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {
    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement goToSupportButton = $("[data-l='t,support']");
    private SelenideElement qrCodeContainer = $("div.qr_code");
    private SelenideElement qrCodeImg = $("img.qr_code_image");

    private SelenideElement SuppurtChatWindow = $("div.support-chat__kmsu6");
    private SelenideElement closeChatButton = $("button[title='Закрыть чат со службой поддержки']");
    private SelenideElement yesClose = $x("//button[.//span[contains(@class, 'content__0ej09') and text()='Да']]");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
        qrCodeContainer.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }

    @Step("Проверяем что есть QR-code")
    public boolean isQrCodeVisible() {
        return qrCodeImg.shouldBe(visible).shouldHave(attribute("src")).exists();
    }

    @Step("Проверяем что чат поддержки открылся")
    public boolean supportChatOpened() {
        return SuppurtChatWindow.shouldBe(visible).exists();
    }

    @Step("Нажимаем кнопку закрыть чат поддержки")
    public void closeChat() {
        closeChatButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Да при закрытии чат поддержки")
    public void yesClose() {
        yesClose.shouldBe(visible).click();
    }
}
