import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$x

class TableSortPage {

    static void proceedLogin() {
        $("#username").sendKeys('username')
        $("#password").sendKeys('password')
        $("#log-in").click()
    }

    static void clickAmountHeader() {
        $("#amount").click()
    }

    static void verifyAmountColumnIsUnsorted() {
        assert getAmountColumnValues() != getAmountColumnValues().sort()
    }

    static void verifyAmountColumnIsSorted() {
        assert getAmountColumnValues() == getAmountColumnValues().sort()
    }

    static List<Double> getAmountColumnValues() {
        $$x("//td[@class='text-right bolder nowrap']/span")
                .texts()
                .collect {it.replaceAll('[^0-9.-]', '').toDouble()}
    }
}
