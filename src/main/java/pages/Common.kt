package pages

import Config
import net.bytebuddy.utility.RandomString
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait

open class Common {
    fun open(url: String) {
        Config.driver.get(url)
    }

    fun close() {
        Config.driver.close()
        Config.driver.quit()
    }

    private val webDriverWait = WebDriverWait(Config.driver, 5)

    fun pressButtonById(id: String) {
        webDriverWait.until(elementToBeClickable(By.id(id))).click()
    }

    fun pressButtonByText(text: String) {
        webDriverWait.until(elementToBeClickable(By.xpath("//button[contains(text(),$text)]")))
    }

    fun checkSolution(): String {
        pressButtonById("end")
        return webDriverWait.until(visibilityOfElementLocated(By.cssSelector("#trail code"))).text
    }

    fun randomStringGenerator(numberOfChars: Int): String {
        return RandomString.make(numberOfChars)
    }

    //do odkomentowania w razie potrzeb, chwilowo zbedne
//    val jsExecutorInBrowser = Config.driver as JavascriptExecutor
}