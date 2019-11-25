import com.codeborne.selenide.Configuration
import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static com.codeborne.selenide.Selenide.close
import static com.codeborne.selenide.Selenide.open

@RunWith(DataProviderRunner.class)
class DataDrivenTest {

    private DataDrivenPage dataDrivenPage = new DataDrivenPage()

    final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html'

    @Before
    void init(){
        Configuration.startMaximized = true
    }

    @Test
    @UseDataProvider("data_provider_login_form")
    void "DDT test"(String username, String password){
        open app_url_v1
        dataDrivenPage.fillLoginForm(username, password)
        dataDrivenPage.checkRememberMe()
        dataDrivenPage.clickLoginButton()
    }

    @DataProvider
    static Object[][] data_provider_login_form() {
        [
                ['Username1', "pass1"],
                ['Username2', "pass2"],
                ['Username3', "pass3"],
                ['Username4', "pass4"],
        ]
    }

    @After
    void tearDown(){
        close()
    }
}
