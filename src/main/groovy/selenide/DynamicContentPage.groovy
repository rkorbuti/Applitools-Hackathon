package selenide

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import static com.codeborne.selenide.Selenide.$$x

class DynamicContentPage {

    static void verifyAds() {
        Set<WebElement> gifs = $$x("//div[contains(@id,'flashSale')]")
                .findAll {By.xpath("./img") != null}
        assert gifs.every {
            it.findElement(By.xpath("./img")).getAttribute('src').contains('.gif')
        }
        assert gifs.size() >= 2
    }
}