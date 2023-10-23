import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeafioTest extends BaseTest{
    private final static String BASE_URL = "http://feature.12413.builder.abmcloud.us/login";
    private final static String VALID_EMAIL = "zemik2004@gmail.com";
    private final static String VALID_PASS = "123456qwerty";
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ExchangeCompanyPage exchangeCompanyPage = new ExchangeCompanyPage();

    @Test
    public void Test1(){
        //Step 1
        new LoginPage(BASE_URL)
                .login(VALID_EMAIL, VALID_PASS);

        //Step 2
        String alertMessage = dashboardPage
                .getAlertMessageText();

        //Step 3
        assertAll(
            () -> assertEquals("Signed in successfully.", alertMessage,
                    "Alert message isn't correct"),
            () -> assertTrue(dashboardPage.isAddNewCompanyButtonDisplayed(),
                    "Add New Company isn't displayed, but should not")
        );
    }

    @Test
    public void Test2(){
        String unvalidEmail = "test@mail.com";
        String invalidPass = "qwerty";

        //Step 1, 2
        String loginWarningMessage = new LoginPage(BASE_URL)
                .login(unvalidEmail, invalidPass)
                .getLoginWarningMessage();

        //Step 3
        assertAll(
            () -> assertEquals("Email or password is incorrect", loginWarningMessage,
                    "Failed login message isn't correct"),
            () -> assertFalse(dashboardPage.isAddNewCompanyButtonDisplayed())
        );
    }

    @Test
    public void Test3(){
        String testEmail = "abmtestcloud@gmail.com";
        String testPass = "1q2w3e4r";
        String host = "builder.abmcloud.us";
        String port = "21";
        String login = "test";
        String password = "test";
        String threshold = "0";

        //Step 1
        new LoginPage(BASE_URL).login(testEmail, testPass);

        //Step 2
        new CreateCompanyPage().createNewCompany("NewCompany", "SystemName");

        //Step 3
        exchangeCompanyPage.clickAvailableTabByName("Exchange");

        //Step 4
        exchangeCompanyPage.createExchange(host, port, login, password, threshold);

        //Step 5
        assertAll(
                () -> assertEquals(host, exchangeCompanyPage.getHostText(),
                        "Host isn't saved correctly"),
                () -> assertEquals(port, exchangeCompanyPage.getPortText(),
                        "Port isn't saved correctly"),
                () -> assertEquals(login, exchangeCompanyPage.getLoginText(),
                        "Login isn't saved correctly"),
                () -> assertEquals(password, exchangeCompanyPage.getPasswordText(),
                        "Password isn't saved correctly"),
                () -> assertEquals(threshold, exchangeCompanyPage.getThesholdText(),
                        "Threshold isn't saved correctly")
        );
        //Step 6
        new GeneralCompanyPage().deleteCompany();

        //Step 7
        assertFalse(new DashboardPage().isCompaniesTableDisplayed(),
                "Companies Tables isn't empty, company wasn't deleted");
    }
}
