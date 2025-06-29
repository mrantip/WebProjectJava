package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPhonePage extends BasePage {
    private SelenideElement phoneField = $("[name='st.r.phone']");
    private SelenideElement codeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        phoneField.shouldBe(visible);
        codeButton.shouldBe(visible);
      }

    @Step("Вводим номер телефона")
    public void setPhone(String phone) {
        phoneField.shouldBe(visible).setValue(phone);
    }

    @Step("Получить телефон")
    public String getPhone() {
        return phoneField.shouldBe(visible).getValue();
    }

    @Step("Нажать Получить код")
    public void clickCodeButton() {
        codeButton.shouldBe(visible).click();
    }
}
