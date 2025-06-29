package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vkc']");
    protected SelenideElement acceptCookieButton = $("cb_accept");
    protected SelenideElement acceptPrivacyButton = $(".cmptxt_btn_yes");

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Открываем VK Services")
    public  void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Клик на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Принимаем Куки")
    public void acceptCookie() {
        acceptCookieButton.shouldBe(visible).click();
    }

    @Step("Принимаем политику конфидицеальности")
    public void acceptPrivacy() {
        acceptPrivacyButton.shouldBe(visible).click();
    }
}
