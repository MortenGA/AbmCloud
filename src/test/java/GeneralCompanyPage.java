import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GeneralCompanyPage extends CompanyPage{
    private final SelenideElement btnDeleteCompany = $("#company_settings_delete_btn");
    public GeneralCompanyPage clickDeleteCompanyButton(){
        btnDeleteCompany.click();
        return this;
    }
    public GeneralCompanyPage deleteCompany(){
        clickAvailableTabByName("General");
        clickDeleteCompanyButton();
        handleModalDialogActions(ModalDialogActionsEnum.ACCEPT);
        return this;
    }
}
