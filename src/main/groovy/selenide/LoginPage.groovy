package selenide

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class LoginPage {

    static void proceedLogin() {
        $("#username").sendKeys('username')
        $("#password").sendKeys('password')
        $("#log-in").click()
    }

    static void verify() {
        assert $(".logo-w").displayed
        assert $("#username").displayed
        assert $("#password").displayed
        assert $x("//div[@class='pre-icon os-icon os-icon-user-male-circle']").displayed
        assert $x("//div[@class='pre-icon os-icon os-icon-fingerprint']").displayed
        assert $("#log-in").displayed
        assert $(".form-check-label").displayed
        assert $(".form-check-input").displayed
        assert $x("//img[contains(@src,'social-icons/twitter')]").displayed
        assert $x("//img[contains(@src,'social-icons/facebook')]").displayed
        assert $x("//img[contains(@src,'social-icons/linkedin')]").displayed
        verifyTitle()
    }

    static void verifyTitle() {
        assert $(".auth-header").text == 'Login Form'
    }
}