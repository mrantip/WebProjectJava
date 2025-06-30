package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPhonePage extends BasePage {
    private SelenideElement phoneField = $("[name='st.r.phone']");
    private SelenideElement countryDropdown = $x("//div[@data-l='t,country']");
    private SelenideElement codeButton = $("[data-l='t,submit']");
    private SelenideElement errorMessage = $x("//div[@class='input-e js-ph-vl-hint']");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        phoneField.shouldBe(visible);
        codeButton.shouldBe(visible);
        countryDropdown.shouldBe(visible);
      }

    @Step("Вводим номер телефона")
    public void setPhone(String phone) {
        phoneField.shouldBe(visible).setValue(phone);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click();
        SelenideElement countryItem = $(String.format("div.country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find("div.country-select_code").text();
        countryItem.click();
        return countryCode;
    }

    @Step("Нажать Получить код")
    public void clickCodeButton() {
        codeButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке ввода телефона")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получить текст ошибки ввода телефона")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}
