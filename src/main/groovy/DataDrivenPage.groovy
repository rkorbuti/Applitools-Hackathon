import static com.codeborne.selenide.Selenide.$

class DataDrivenPage {

    static void fillLoginForm(String username, String password) {
        $("#username").sendKeys(username)
        $("#password").sendKeys(password)
    }

    static void clickLoginButton() {
        $("#log-in").click()
    }

    static void checkRememberMe() {
        $(".form-check-input").click()
    }
}
