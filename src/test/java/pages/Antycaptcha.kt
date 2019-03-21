package pages


import io.kotlintest.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xit
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait


class AntycaptchaSpec : Spek({
    val common = Common()
    describe("Selenium WebDriver 3 - Be like a pro"){

        beforeEachTest {  }
        xit("test"){
            common.open("https://google.pl")

        }
        it("Nazwa strony"){
            common.open("https://amberteam.pl")
            Config.driver.title shouldBe "AmberTeam Testing | Professional Software Testing & RPA Consultants"
            common.open("https://google.pl")

            Config.driver.navigate().back()

            Config.driver.title shouldBe "AmberTeam Testing | Professional Software Testing & RPA Consultants"
            Config.driver.navigate().forward()


            /**
             *  driver.get_screenshot_as_file("sciezka do pliku . png")
             *
             *  driver.find_element_by_id("id").screenshot(url_do_pliku_jako_string)
             *
             *
             * **/

        }
        xit("antycaptcha"){
            val driver = Config.driver
            val element = driver.findElement(By.name("element-name"))
            driver.findElement(By.id("id"))
            val wait = WebDriverWait(driver, 10)
            wait.until(ExpectedConditions.elementToBeClickable(By.name("name")))
            wait.until(ExpectedConditions.elementToBeClickable(element))
            val elementTestowy = driver.findElement(By.cssSelector("[data-element_type='section']"))
            elementTestowy.getAttribute("data-id") // => ubvajtk
            element.getAttribute("value")
            elementTestowy.tagName // => section
            /**
             * zaznacz check
             * jeżeli check jest zaznaczony to nie rob nic, jezeli nie to go zaznacz
             *
             * */
            if (!element.isSelected) {
                element.click()
            }

            val elementSelect = driver.findElement(By.tagName("select")) as Select
            elementSelect.selectByIndex(1)

            val modal = driver.findElement(By.className("modal"))
            val drugiModal = modal.findElement(By.id("id"))

            val listOfWebElements =  driver.findElements(By.xpath("//div"))
            listOfWebElements.forEach {
                if (it.text.contains("dupa")){
                    it.click()
                }
            }
            val przycisk = driver.findElement(By.className("przycisk"))
            val sztuczka = driver.findElements(By.className("przycisk"))

            if (sztuczka.size == 0){

            }else{

            }

        }

        /**
         *
         * FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(5));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
         *
         * */
    }
    afterGroup {
        common.closeBrowser()
    }

} // this spec end
) // spek end