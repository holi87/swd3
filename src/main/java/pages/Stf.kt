package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions


class Stf : Common() {
    fun getSeedForStf(): String {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre/code"))).text.drop(14)
    }

    fun openSolutionPage(seed: String) {
        open("https://antycaptcha.amberteam.pl:5443/stf/3-2-1/solution?seed=$seed")
    }

    fun clickAlertButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showAlert"))).click()
    }

    fun copyAlertTextToAlertBox() {
        val alertBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertText")))
        alertBox.clear()
        val textForBox = Config.driver.switchTo().alert().text
        Config.driver.switchTo().defaultContent()
        alertBox.sendKeys(textForBox)
    }

    fun closeAlert() {
        Config.driver.switchTo().alert().dismiss()
    }
}
