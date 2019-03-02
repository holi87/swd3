package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait

open class Common {
    fun open(url: String) {
        Config.driver.get(url)
    }

    fun close() = Config.driver.quit()

    val webDriverWait = WebDriverWait(Config.driver, 5)

    fun pressButtonById(id: String) {
        webDriverWait.until(elementToBeClickable(By.id(id))).click()
    }

    fun setTextIntoInputById(id: String, text: String) {
        val textBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)))
        textBox.clear()
        textBox.sendKeys(text)
    }
    fun pressCheckButton() {
        pressButtonById("solution")

    }

    fun getSolution(): String {
        val answerBox = webDriverWait.until(visibilityOfElementLocated(By.cssSelector("#trail code")))
        webDriverWait.until {
            answerBox.text != "Trail..."
        }
        return answerBox.text
    }

}