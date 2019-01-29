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
        webDriverWait.until(ExpectedConditions.alertIsPresent())
    }

    fun getTextFromAlert(): String {
        return Config.driver.switchTo().alert().text

    }

    fun setTextIntoTextBox(text: String) {
        Config.driver.switchTo().defaultContent()
        val alertBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertText")))
        alertBox.clear()
        alertBox.sendKeys(text)
    }

    fun closeAlert() {
        Config.driver.switchTo().alert().dismiss()
    }
}
