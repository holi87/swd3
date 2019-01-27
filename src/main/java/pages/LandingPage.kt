package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

class LandingPage : Common() {
    fun getSeed(): String {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre/code/em"))).text
    }

    fun exercisesButtons(): WebElement {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='four columns']")))
    }

    fun openExerciseByName(exercise: String) {
        exercisesButtons().findElement(By.xpath("//a[contains(text(),'$exercise')]")).click()
    }
    val exerciseOneUrl = "/exercises/exercise1?seed="
    val exerciseTwoUrl = "/exercises/exercise2?seed="
    val exerciseThreeUrl = "/exercises/exercise3?seed="

    fun stf32() {
        Config.driver.findElement(By.xpath("//a[contains(text(),'WebDriver')]")).click()
    }
}