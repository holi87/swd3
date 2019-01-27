package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

class Exercises : Common() {

    fun pressB1() {
        pressButtonById("btnButton1")
    }

    fun pressB2() {
        pressButtonById("btnButton2")
    }

    private fun getListOfGoals(): List<WebElement> =
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.row > code")))

    fun pressAllButtonsByGoals() {
        getListOfGoals().forEach {
            when (it.text) {
                "B1" -> pressB1()
                "B2" -> pressB2()
            }
        }
    }

    fun getTextForEditBox(): String {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='twelve columns']/code"))).text
    }

    fun setTextInEditBox(text: String) {
        val editbox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("t14")))
        editbox.clear()
        editbox.sendKeys(text)
    }


}