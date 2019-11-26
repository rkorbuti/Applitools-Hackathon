import com.codeborne.selenide.Configuration
import org.junit.After
import org.junit.Before
import org.junit.Test

import static com.codeborne.selenide.Selenide.close
import static com.codeborne.selenide.Selenide.open

class TableSortTest {

    private TableSortPage tableSortPage = new TableSortPage()

    final static String app_url_v1 = 'https://demo.applitools.com/hackathon.html'

    @Before
    void init(){
        Configuration.startMaximized = true
    }

    @Test
    void 'Table sort test'() {
        open app_url_v1
        tableSortPage.proceedLogin()
        tableSortPage.verifyAmountColumnIsUnsorted()
        tableSortPage.clickAmountHeader()
        tableSortPage.verifyAmountColumnIsSorted()
    }

    @After
    void tearDown(){
        close()
    }
}
