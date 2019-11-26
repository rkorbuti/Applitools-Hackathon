package selenide

import com.codeborne.selenide.Configuration
import org.junit.Before
import org.junit.Test

import static com.codeborne.selenide.Selenide.open

class LoginPageTest {

    private LoginPage loginPage = new LoginPage()

    final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html'

    @Before
    void init(){
        Configuration.startMaximized = true
    }

    @Test
    void 'Login page test'() {
        open app_url_v1
        loginPage.verify()
    }
}
