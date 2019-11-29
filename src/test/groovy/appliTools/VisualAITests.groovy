package appliTools

import com.applitools.eyes.EyesRunner
import com.applitools.eyes.RectangleSize
import com.applitools.eyes.StdoutLogHandler
import com.applitools.eyes.selenium.ClassicRunner
import com.applitools.eyes.selenium.Eyes
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class VisualAITests {

    private EyesRunner runner
    private Eyes eyes
    private WebDriver driver
    private RectangleSize rectangleSize = new RectangleSize(1200, 700)
    private String appName = 'AppliTools App'
    private final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html'
    private final static String app_url_v2 = 'https://demo.applitools.com/hackathonV2.html'
    private final static String app_url_ad_v1 = 'https://demo.applitools.com/hackathon.html?showAd=true'
    private final static String app_url_ad_v2 = 'https://demo.applitools.com/hackathonV2.html?showAd=true'

    @Before
    void beforeEach() {
        runner = new ClassicRunner()
        eyes = new Eyes(runner)
        eyes.setLogHandler(new StdoutLogHandler(true))
        if (System.getenv("APPLITOOLS_API_KEY") == null) {
            println("\n\n**** Please set APPLITOOLS_API_KEY in your environment ***")
            System.exit(0)
        }
        driver = new ChromeDriver()
    }

    @Test
    void 'Login Page Test'() {
        eyes.open(driver, appName, 'Login Page Test', rectangleSize)
        driver.get(app_url_v1)
        eyes.checkWindow("Login Page")
        eyes.closeAsync()
    }

    @Test
    void 'Login Page Test Version 2'() {
        eyes.open(driver, appName, 'Login Page Test Version 2', rectangleSize)
        driver.get(app_url_v2)
        eyes.checkWindow("Login Page")
        eyes.closeAsync()
    }

    @After
    void afterEach() {
        driver.quit()
        eyes.abortIfNotClosed()
    }
}
