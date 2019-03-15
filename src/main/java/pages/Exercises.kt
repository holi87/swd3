package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Exercises : Common() {

    fun pressB1() {
        clickBy(By.id("btnButton1"))
    }

    fun pressB2() {
        clickBy(By.id("btnButton2"))
    }

    private fun getListOfGoals(): List<WebElement> =
            webElementsLocatedBy(By.xpath("//td[2]/code"))

    fun pressAllButtonsByGoals() {
        getListOfGoals().forEach {
            when (it.text) {
                "B1" -> pressB1()
                "B2" -> pressB2()
            }
        }
    }

    fun getTextForExercise(): String {
        return webElementLocatedBy(By.xpath("//tr[2]//code")).text
    }

    fun setTextInEditBox(text: String) {
        setTextIntoInputById("t14", text)
    }

    fun selectOptionInDropdownList(text: String) {
        val dropdownList = webElementLocatedBy(By.id("s13"))
        val elements = dropdownList.findElements(By.tagName("option"))
        elements.forEach {
            if (it.text == text) {
                it.click()
                return
            }
        }

    }

    private fun getRadioNames(): List<String> {
        val listOfRadioNames: ArrayList<String> = arrayListOf()
        webElementsLocatedBy((By.xpath("//td[2]/code"))).forEach {
            listOfRadioNames.add(it.text)
        }
        return listOfRadioNames

    }


    fun setRadioButtonsByNames() {
        val radioNames = getRadioNames()
        for (i in 0..3) {
            clickBy(By.xpath("((//div[./h5[text() = 'Group $i:']]//text())[.='${radioNames[i]}']/preceding-sibling::*)[last()]"))
        }
    }
}