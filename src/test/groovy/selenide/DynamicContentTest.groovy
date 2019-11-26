package selenide

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
class DynamicContentTest {

    private LoginPage loginPage = new LoginPage()
    private DynamicContentPage dynamicContentPage = new DynamicContentPage()

    final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html?showAd=true'
    final static String app_url_v2 = 'https://demo.applitools.com/hackathonV2.html?showAd=true'

    @Before
    void init(){
        Configuration.startMaximized = true
    }

    @Test
    @UseDataProvider('data_provider_entry_points')
    void 'Dynamic content test'(String url) {
        open url
        loginPage.proceedLogin()
        dynamicContentPage.verifyAds()
    }

    @DataProvider
    static Object[][] data_provider_entry_points() {
        [
                [app_url_v1],
                [app_url_v2]
        ]
    }

    @After
    void tearDown(){
        close()
    }
}
