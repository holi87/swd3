package pages

import Config
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it


class AntycaptchaSpec : Spek({
    val landingPage = LandingPage()
    describe("Antycaptcha by AmberTeam") {
        val goodAnswer = "OK. Good answer"
        val exercise = Exercises()
        describe("Exercises") {
            describe("Exercise 1") {
                beforeEachTest {
                    landingPage.open(Config.antycaptchaUrl)
                    val seed = landingPage.getSeed()
                    landingPage.open(Config.antycaptchaUrl + landingPage.exerciseOneUrl + seed)
                    println(seed)
                }
                it("Check what you have to click, then do this and check answer") {
                    exercise.pressAllButtonsByGoals()
                    exercise.pressCheckButton()
                    exercise.getSolution() shouldBe goodAnswer
                }
                it("Click B1 and B2, and check answer as not good") {
                    exercise.pressB1()
                    exercise.pressB2()
                    exercise.pressCheckButton()
                    exercise.getSolution() shouldNotBe goodAnswer
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
                    exercise.pressCheckButton()
                    exercise.getSolution() shouldBe goodAnswer
                }
                it("do nothing and check solution") {
                    exercise.pressCheckButton()
                    exercise.getSolution() shouldNotBe goodAnswer
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
                    exercise.pressCheckButton()
                    exercise.getSolution() shouldBe goodAnswer
                }
                it("do nothing and check solution") {
                    exercise.pressCheckButton()
                    exercise.getSolution() shouldNotBe goodAnswer
                }
            }
        }
        describe("Certified Selenium Tester Foundation Level") {
            val stf = Stf()
            beforeEachTest { landingPage.open(Config.antycaptchaUrl) }
            it("STF-3.2") {
                landingPage.stf32()
                val seed = stf.getSeedForStf()
                stf.openSolutionPage(seed)
                stf.getSolution() shouldBe goodAnswer
            }
        }
    }

    afterGroup { landingPage.close() }


} // this spec end
) // spek end