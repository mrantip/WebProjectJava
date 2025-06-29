package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryMailPage extends BasePage {
    private SelenideElement emailField = $("[name='email']");
    private SelenideElement codeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        emailField.shouldBe(visible);
        codeButton.shouldBe(visible);
    }

    @Step("Вводим номер телефона")
    public void setEmail(String phone) {
        emailField.shouldBe(visible).setValue(phone);
    }


    @Step("Нажать Получить код")
    public void clickCodeButton() {
        codeButton.shouldBe(visible).click();
    }
}
