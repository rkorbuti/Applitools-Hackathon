import com.codeborne.selenide.Configuration
import org.junit.Before
import org.junit.Test

import static com.codeborne.selenide.Selenide.open
import static com.codeborne.selenide.Selenide.title

class BaseTest {

    final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html'

    @Before
    void init(){
        Configuration.browser = "chrome"
        Configuration.browserVersion = '78'
    }

   @Test
    void "Login Test"(){
       open app_url_v1
       assert title() == 'ACME demo app'
   }
}
