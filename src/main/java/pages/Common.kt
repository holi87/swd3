package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class Common {
    fun open(url: String) {
        Config.driver.get(url)
    }

    fun close() = Config.driver.quit()

    val webDriverWait = WebDriverWait(Config.driver, 5)

    fun webElementsLocatedBy(by: By): List<WebElement> {
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by))
    }

    fun webElementLocatedBy(by: By): WebElement {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by))
    }

    fun clickBy(by: By) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click()
    }
    fun setTextIntoInputById(id: String, text: String) {
        val textBox = webElementLocatedBy(By.id(id))
        textBox.clear()
        textBox.sendKeys(text)
    }
    fun pressCheckButton() {
        clickBy(By.id("solution"))

    }

    fun getSolution(): String {
        val answerBox = webElementLocatedBy(By.cssSelector("#trail code"))
        webDriverWait.until {
            answerBox.text == "NOT OK." || answerBox.text == "OK. Good answer"
        }
        return answerBox.text
    }

}