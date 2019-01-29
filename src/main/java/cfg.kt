import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

object Config {
    val driver: WebDriver by lazy {
        val options = ChromeOptions()
        options.addArguments("--start-maximized")
        val driver = ChromeDriver(options)
        driver
    }
    const val antycaptchaUrl = "https://antycaptcha.amberteam.pl:5443/"
}