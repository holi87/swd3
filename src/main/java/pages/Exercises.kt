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

    fun getTextForExercise(): String {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='twelve columns']/code"))).text
    }

    fun setTextInEditBox(text: String) {
        setTextIntoInputById("t14", text)
    }

    fun selectOptionInDropdownList(text: String) {
        // bo select ma focha
        val dropdownList = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s13"))) // as Select
//        dropdownList.deselectAll()
//        dropdownList.selectByVisibleText(text)
        val elements = dropdownList.findElements(By.tagName("option"))
        elements.forEach {
            if (it.text == text) {
                it.click()
                return
            }
        }

    }

}