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
        val exercise = Exercises()
        describe("Exercise 1") {
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
            it("Click B1 and B2, and check answer as not good") {
                exercise.pressB1()
                exercise.pressB2()
                exercise.checkSolution() shouldNotBe goodAnswer
            }
        }
        describe("Exercise 2") {
            beforeEachTest {
                landingPage.open(Config.antycaptchaUrl)
                val seed = landingPage.getSeed()
                landingPage.open(Config.antycaptchaUrl + landingPage.exerciseTwoUrl + seed)
                println(seed)
            }
            it("Check text and put it to editbox, press B1, after that check solution") {
                exercise.setTextInEditBox(exercise.getTextForExercise())
                exercise.pressB1()
                exercise.checkSolution() shouldBe goodAnswer
            }
            it("do nothing and check solution") {
                exercise.checkSolution() shouldNotBe goodAnswer
            }
        }
        describe("Exercise 3") {
            beforeEachTest {
                landingPage.open(Config.antycaptchaUrl)
                val seed = landingPage.getSeed()
                landingPage.open(Config.antycaptchaUrl + landingPage.exerciseThreeUrl + seed)
                println(seed)
            }
            it("check name, select it from dropdown and check solution") {
                exercise.selectOptionInDropdownList(exercise.getTextForExercise())
                exercise.checkSolution() shouldBe goodAnswer
            }
            it("do nothing and check solution") {
                exercise.checkSolution() shouldNotBe goodAnswer
            }
        }
    }
    afterGroup { landingPage.close() }


} // this spec end
) // spek end