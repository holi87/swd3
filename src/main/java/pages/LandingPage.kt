package pages

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class LandingPage : Common() {
    fun getSeed(): String {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre/code/em"))).text
    }

    val exerciseOneUrl = "/exercises/exercise1?seed="
    val exerciseTwoUrl = "/exercises/exercise2?seed="
    val exerciseThreeUrl = "/exercises/exercise3?seed="
}