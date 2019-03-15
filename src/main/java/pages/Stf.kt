package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions


class Stf : Common() {
    fun getSeedForStf(): String {
        return webElementLocatedBy(By.xpath("//pre/code")).text.drop(14)
    }

    fun openSolutionPage(seed: String) {
        open("https://antycaptcha.amberteam.pl:5443/stf/3-2-1/solution?seed=$seed")
    }

    fun clickAlertButton() {
        clickBy(By.id("showAlert"))
        webDriverWait.until(ExpectedConditions.alertIsPresent())
    }

    fun getTextFromAlert(): String {
        return Config.driver.switchTo().alert().text

    }

    fun setTextIntoEditBox(text: String) {
        setTextIntoInputById("alertText", text)
    }

    fun closeAlert() {
        Config.driver.switchTo().alert().dismiss()
    }

    fun getValueOfAttribute(): String {
        var valueOfAttribute = webElementLocatedBy(By.tagName("em")).text
        if (valueOfAttribute.startsWith("<")) valueOfAttribute = valueOfAttribute.drop(1).dropLast(1)
        println(valueOfAttribute)
        return valueOfAttribute
    }

    fun getWrongTagAttribute(): String {
        var attribute = getValueOfAttribute()
        attribute = "h" + (attribute.drop(1).toInt() + 1).toString()
        if (attribute == "h7") {
            attribute = "h2"
        }
        println(attribute)
        return attribute
    }
    fun clickButtonById(id: String) {
        clickBy(By.id(id))
    }

    fun clickButtonByClassName(className: String) {
        clickBy(By.className(className))
    }

    fun clickLinkByTagName(tagName: String) {
        webElementLocatedBy(By.tagName(tagName)).findElement(By.tagName("a")).click()
    }
}
