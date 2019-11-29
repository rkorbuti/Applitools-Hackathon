package selenide

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class DataDrivenPage {

    static String username = ''
    static String password = ''

    static void fillLoginForm(String username, String password) {
        $("#username").sendKeys(username)
        setUsername(username)
        $("#password").sendKeys(password)
        setPassword(password)
    }

    static void clickLoginButton() {
        $("#log-in").click()
    }

    static void checkRememberMe() {
        $(".form-check-input").click()
    }

    static void checkError() {
        if (getUsername().empty && getPassword().empty) {
            assert $x("//*[@class='alert alert-warning']").getText() == 'Both Username and Password must be present'
        } else if (!getPassword().empty && getUsername().empty) {
            assert $x("//*[@class='alert alert-warning']").getText() == 'Username must be present'
        } else if (!getUsername().empty && getPassword().empty) {
            assert $x("//*[@class='alert alert-warning']").getText() == 'Password must be present'
        } else {
            checkLoginPage()
        }
    }

    static void checkLoginPage() {
        assert $(".logged-user-name").isDisplayed()
    }
}