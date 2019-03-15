package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
class LandingPage : Common() {
    fun getSeed(): String {
        return webElementLocatedBy(By.xpath("//pre/code/em")).text
    }

    private fun exercisesButtons(): WebElement {
        return webElementLocatedBy(By.xpath("//div[@class='four columns']"))
    }

    fun openExerciseByName(exercise: String) {
        exercisesButtons().findElement(By.xpath("//a[contains(text(),'$exercise')]")).click()
    }

    fun stf32() {
        clickBy(By.xpath("//a[contains(text(),'WebDriver')]"))
    }

    fun stf35(text: String) {
        clickBy(By.xpath("//a[contains(text(),'Find element with $text')]"))
    }

    fun stf38() {
        clickBy(By.xpath("//a[contains(text(),'alert')]"))
    }
}