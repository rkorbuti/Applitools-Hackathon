package selenide

import static com.codeborne.selenide.Selenide.$

class LoginPage {

    static void proceedLogin() {
        $("#username").sendKeys('username')
        $("#password").sendKeys('password')
        $("#log-in").click()
    }
}
