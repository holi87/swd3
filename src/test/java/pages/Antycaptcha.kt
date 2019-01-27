package pages

import Config
import io.kotlintest.shouldBe

import io.kotlintest.shouldNotBe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it


class AntycaptchaSpec : Spek({
    val landingPage = LandingPage()
    describe("Starter") {

        val goodAnswer = "OK. Good answer"

        describe("Cwiczenie1") {
            val exercise = Exercises()
            beforeEachTest {
                landingPage.open(Config.antycaptchaUrl)
                val seed = landingPage.getSeed()
                landingPage.open(Config.antycaptchaUrl + landingPage.exerciseOneUrl + seed)
                println(seed)
            }
            it("Check what you have to click, then do this and check answer") {

                exercise.pressAllButtonsByGoals()

                exercise.checkSolution() shouldBe goodAnswer
            }
            it("Kliknij B1B2 a potem sprawdź (negative one)") {
                exercise.pressB1()
                exercise.pressB2()
                exercise.checkSolution() shouldNotBe goodAnswer
            }
        }

    }
    afterGroup { landingPage.close() }


} // this spec end
) // spek end