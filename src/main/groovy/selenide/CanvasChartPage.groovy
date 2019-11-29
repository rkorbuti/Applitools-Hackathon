package selenide

import static com.codeborne.selenide.Selenide.$

class CanvasChartPage {

    static void clickCompareExpenses() {
        $("#showExpensesChart").click()
    }

    static void clickShowDataForNextYear() {
        $("#addDataset").click()
    }

    static void verifyChart() {
        println 'not implemented'
    }

    static void verifyAddedDataInChart(int year) {
        println 'not implemented'
    }
}