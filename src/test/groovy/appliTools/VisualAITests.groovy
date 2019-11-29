package appliTools

import com.applitools.eyes.BatchInfo
import com.applitools.eyes.EyesRunner
import com.applitools.eyes.RectangleSize
import com.applitools.eyes.StdoutLogHandler
import com.applitools.eyes.selenium.ClassicRunner
import com.applitools.eyes.selenium.Eyes
import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(DataProviderRunner.class)
class VisualAITests {

    private EyesRunner runner
    private Eyes eyes
    private WebDriver driver
    static final String date = new Date().getTime().toString()
    private BatchInfo batchInfo_DDT_test = new BatchInfo('DDT login form test ' + date)
    private BatchInfo batchInfo_Login_test = new BatchInfo('Login page test ' + date)
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
        if (System.getProperty('APPLITOOLS_API_KEY') == null) {
            println("\n\n**** Please set APPLITOOLS_API_KEY in your environment ***")
            System.exit(0)
        } else {
            eyes.setApiKey(System.getProperty('APPLITOOLS_API_KEY'))
        }
        driver = new ChromeDriver()
    }

    @Test
    void 'Login Page Test for app version 1'() {
        batchInfo_Login_test.setId(date)
        eyes.setBatch(batchInfo_Login_test)
        eyes.open(driver, appName, 'Login Page Test for app version 1', rectangleSize)
        driver.get app_url_v1
        eyes.checkWindow 'Login Page'
        eyes.closeAsync()
    }

    @Test
    void 'Login Page Test for app version 2'() {
        batchInfo_Login_test.setId(date)
        eyes.setBatch(batchInfo_Login_test)
        eyes.open(driver, appName, 'Login Page Test version 2', rectangleSize)
        driver.get app_url_v2
        eyes.checkWindow 'Login Page'
        eyes.closeAsync()
    }

    @Test
    @UseDataProvider('data_provider_login_form')
    void 'DDT login form test'(String username, String password) {
        batchInfo_DDT_test.setId(date)
        eyes.setBatch(batchInfo_DDT_test)
        String test_name = 'DDT login form test ' + getTestNameDDT(username, password)
        eyes.open driver, appName, test_name, rectangleSize
        driver.get app_url_v1
        driver.findElement(By.id('username')).sendKeys(username)
        driver.findElement(By.id('password')).sendKeys(password)
        driver.findElement(By.id('log-in')).click()
        eyes.checkWindow test_name
        eyes.closeAsync()
    }

    @DataProvider
    static Object[][] data_provider_login_form() {
        [
                ['', ''],
                ['username', ''],
                ['', 'password'],
                ['username', 'password'],
        ]
    }

    @After
    void afterEach() {
        driver.quit()
        eyes.abortIfNotClosed()
    }

    private static String getTestNameDDT(String username, String password) {
        String testName = 'correct'
        if (username.empty && password.empty) {
            testName = 'empty username and password'
        } else if (username.empty && !password.empty) {
            testName = 'empty username'
        } else if (!username.empty && password.empty) {
            testName = 'empty password'
        }
        testName
    }
}
