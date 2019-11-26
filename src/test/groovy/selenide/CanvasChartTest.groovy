package selenide

import com.codeborne.selenide.Configuration
import org.junit.Before
import org.junit.Test

import static com.codeborne.selenide.Selenide.open

class CanvasChartTest {

    private CanvasChartPage canvasChartPage = new CanvasChartPage()
    private LoginPage loginPage = new LoginPage()

    final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html'

    @Before
    void init(){
        Configuration.startMaximized = true
    }

    @Test
    void 'Canvas chart test'() {
        open app_url_v1
        loginPage.proceedLogin()
        canvasChartPage.clickCompareExpenses()
        canvasChartPage.verifyChart()
        canvasChartPage.clickShowDataForNextYear()
        canvasChartPage.verifyAddedDataInChart(2019)
    }
}
