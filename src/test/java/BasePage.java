import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;
public class BasePage {
    private final SelenideElement msgAlertDialog = $("#alert_dialog");

    public BasePage() {

    }

    public String getAlertMessageText() {
        return msgAlertDialog.text();
    }

    public BasePage handleModalDialogActions(ModalDialogActionsEnum action) {
        $(".modal-dialog").shouldBe(Condition.visible);
        switch (action) {
            case ACCEPT:
                $(".modal-dialog [value='Ok']").click();
                break;
            case DISMISS:
                $(".modal-dialog [id='cancel_btn']").click();
                break;
            default:
                throw new IllegalArgumentException("Invalid modal dialog action");
        }
        return this;
    }
}
