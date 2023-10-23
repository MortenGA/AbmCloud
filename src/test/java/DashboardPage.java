import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends BasePage {
    private final SelenideElement btnAddNewCompany = $x("//*[@title='Add']");
    private final SelenideElement tblCompanies = $("#companies_table");
    public DashboardPage(){

    }
    public Boolean isAddNewCompanyButtonDisplayed(){
        return btnAddNewCompany.isDisplayed();
    }
    public DashboardPage clickAddNewCompanyButton(){
        btnAddNewCompany.click();
        return new DashboardPage();
    }
    public boolean isCompaniesTableDisplayed(){
        return tblCompanies.isDisplayed();
    }
}
