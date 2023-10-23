import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ExchangeCompanyPage extends CompanyPage {
    private final SelenideElement txtHost = $("#exchange_storage_host");
    private final SelenideElement txtPort = $("#exchange_storage_port");
    private final SelenideElement txtLogin = $("#exchange_storage_login");
    private final SelenideElement txtPassword = $("#exchange_storage_password");
    private final SelenideElement txtThreshold = $("#exchange_storage_threshold");
    private final SelenideElement btnCreateExchange = $("#exchange_settings_save_btn");

    public ExchangeCompanyPage(){

    }
    public ExchangeCompanyPage setHostText(String host){
        txtHost.setValue(host);
        return this;
    }
    public String getHostText(){
        return txtHost.getValue();
    }
    public ExchangeCompanyPage setPortText(String port){
        txtPort.setValue(port);
        return this;
    }
    public String getPortText(){
        return txtPort.getValue();
    }
    public ExchangeCompanyPage setLoginText(String login){
        txtLogin.setValue(login);
        return this;
    }
    public String getLoginText(){
        return txtLogin.getValue();
    }
    public ExchangeCompanyPage setPasswordText(String password){
        txtPassword.setValue(password);
        return this;
    }
    public String getPasswordText(){
        return txtPassword.getValue();
    }
    public ExchangeCompanyPage setThresholdText(String threshold){
        txtThreshold.setValue(threshold);
        return this;
    }
    public String getThesholdText(){
        return txtThreshold.getValue();
    }
    public ExchangeCompanyPage clickCreateExchangeButton(){
        btnCreateExchange.click();
        return this;
    }
    public ExchangeCompanyPage createExchange(String host, String port, String login, String password, String threshold){
        return setHostText(host)
                .setPortText(port)
                .setLoginText(login)
                .setPasswordText(password)
                .setThresholdText(threshold)
                .clickCreateExchangeButton();
    }
}
