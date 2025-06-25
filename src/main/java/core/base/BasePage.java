package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t.vk_ecosystem']");

    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    public  void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
}
