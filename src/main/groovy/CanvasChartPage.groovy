import static com.codeborne.selenide.Selenide.$

class CanvasChartPage {

    static void clickCompareExpenses() {
        $("#showExpensesChart").click()
    }

    static void clickShowDataForNextYear() {
        $("#addDataset").click()
    }

    static void verifyChart() {

    }

    static void verifyAddedDataInChart(int year) {

    }
}
