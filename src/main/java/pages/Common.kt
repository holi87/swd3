package pages

import Config
import net.bytebuddy.utility.RandomString
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class Common {
    fun open(url: String) {
        Config.driver.get(url)
    }

    fun close() {
        Config.driver.close()
        Config.driver.quit()
    }

    val webDriverWait = WebDriverWait(Config.driver, 5)

    fun pressButtonById(id: String) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click()
    }

    fun checkSolution(): String {
        pressButtonById("end")
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#trail code"))).text
    }

    fun randomStringGenerator(numberOfChars: Int): String {
        return RandomString.make(numberOfChars)
    }

    //do odkomentowania w razie potrzeb, chwilowo zbedne
//    val jsExecutorInBrowser = Config.driver as JavascriptExecutor
}