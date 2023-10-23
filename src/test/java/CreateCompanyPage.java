import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CreateCompanyPage extends BasePage{
    private final SelenideElement  txtName = $("#company_name");
    private final SelenideElement  txtSystemName = $("#company_system_name");
    private final SelenideElement  btnCreateNewCompany = $("#create_company_btn");
    public CreateCompanyPage(){

    }
    public CreateCompanyPage setCompanyName(String name){
        txtName.setValue(name);
        return this;
    }
    public CreateCompanyPage setSystemName(String name){
        txtSystemName.setValue(name);
        return this;
    }
    public CreateCompanyPage clickCreateNewCompanyButton(){
        btnCreateNewCompany.click();
        return this;
    }
    public CreateCompanyPage createNewCompany(String companyName, String systemName){
        new DashboardPage().clickAddNewCompanyButton();
        return setCompanyName(companyName)
                .setSystemName(systemName)
                .clickCreateNewCompanyButton();
    }
}
