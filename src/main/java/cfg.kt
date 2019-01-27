import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Config {
    val driver: WebDriver by lazy {
        val driver = ChromeDriver()
        driver
    }
    const val antycaptchaUrl = "https://antycaptcha.amberteam.pl:5443/"
}