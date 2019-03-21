package pages


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it


class AntycaptchaSpec : Spek({
    describe("Selenium WebDriver 3 - Be like a pro"){
        it("test"){
            Common().open("https://google.pl")
            Common().closeBrowser()
        }
    }

} // this spec end
) // spek end