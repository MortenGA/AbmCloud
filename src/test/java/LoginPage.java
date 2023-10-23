import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement txtEmail = $("#user_email");
    private final SelenideElement txtPassword = $("#user_password");
    private final SelenideElement btnLogin = $x("//input[@type = 'submit']");
    private final SelenideElement msgLoginWarning = $x("//*[@class = 'text-danger']");

    public LoginPage(){

    }
    public LoginPage(String url){
        Selenide.open(url);
    }
    public LoginPage setEmail(String email){
        txtEmail.setValue(email);
        return new LoginPage();
    }
    public LoginPage setPassword(String password){
        txtPassword.setValue(password);
        return new LoginPage();
    }
    public LoginPage clickLoginButton(){
        btnLogin.click();
        return new LoginPage();
    }
    public LoginPage login(String email, String password){
        setEmail(email).
            setPassword(password).
            clickLoginButton();
        return new LoginPage();

    }
    public String getLoginWarningMessage(){
        return msgLoginWarning.getText();
    }
}
