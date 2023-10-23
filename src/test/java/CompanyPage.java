import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CompanyPage extends BasePage{
    private final ElementsCollection lstAvailableTabs = $$x("//*[contains(@class, 'dropdown-menu-right')]//li");
    private final SelenideElement btnAvailableTabs = $x("//*[contains(@class, 'btn-primary')]");

    public void clickButtonAvailableTabs(){
        btnAvailableTabs.click();
    }
    public void clickAvailableTabByName(String tabName) {
        if (btnAvailableTabs.isDisplayed()) {
            clickButtonAvailableTabs();
        }
        lstAvailableTabs.filterBy(Condition.text(tabName)).first().click();
    }
}
