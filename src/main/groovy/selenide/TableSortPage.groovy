package selenide

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$x

class TableSortPage {

    static void clickAmountHeader() {
        $("#amount").click()
    }

    private static Map<Double, String> rowData = new HashMap<>()

    static void verifyAmountColumnIsUnsorted() {
        assert getAmountColumnValues() != getAmountColumnValues().sort()
        setRowData(getAmountColumnValues())
    }

    static void verifyAmountColumnIsSorted() {
        assert getAmountColumnValues() == getAmountColumnValues().sort()
    }

    static void verifyRowsData() {
        Map<Double, String> actualRowsData = getActualRowsData()
        assert rowData.keySet().every {
            rowData.get(it) == actualRowsData.get(it)
        }
    }

    static List<Double> getAmountColumnValues() {
        $$x("//td[@class='text-right bolder nowrap']/span")
                .texts()
                .collect {it.replaceAll('[^0-9.-]', '').toDouble()}
    }

    static void setRowData(List<Double> amountValues) {
        List<String> rowsData = getRowsData()
        for (int i = 0; i < amountValues.size(); i++) {
            rowData.put(amountValues[i], rowsData[i])
        }
    }

    static Map<Double, String> getActualRowsData() {
        Map<Double, String> actualRowsData = new HashMap<>()
        List<Double> actualAmountValues = getAmountColumnValues()
        List<String> rowsData = getRowsData()
        for (int i = 0; i < actualAmountValues.size(); i++) {
            actualRowsData.put(actualAmountValues[i], rowsData[i])
        }
        actualRowsData
    }

    static List<String> getRowsData() {
        $$x("//td[@class='text-right bolder nowrap']/..").texts()
    }
}
