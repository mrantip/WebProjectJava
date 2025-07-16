package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchGroupTest extends BaseTest {
    private static LoginPage loginPage;
    private String groupUrl = "https://ok.ru/groups";


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void searchGroupTest() {
        loginPage.inputSearchText("тестировщик");
        loginPage.selectSearchResult();
        loginPage.checkTransferPage(groupUrl);
    }
}
