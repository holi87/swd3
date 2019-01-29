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
            val exercisesNames = listOf("Three buttons", "Editbox", "Dropdown list")
            describe("Exercise 1 - ${exercisesNames[0]}") {
                beforeEachTest {
                    landingPage.open(Config.antycaptchaUrl)
                    println(landingPage.getSeed())
                    landingPage.openExerciseByName(exercisesNames[0])
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
            describe("Exercise 2 - ${exercisesNames[1]}") {
                beforeEachTest {
                    landingPage.open(Config.antycaptchaUrl)
                    println(landingPage.getSeed())
                    landingPage.openExerciseByName(exercisesNames[1])
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
            describe("Exercise 3 - ${exercisesNames[2]}") {
                beforeEachTest {
                    landingPage.open(Config.antycaptchaUrl)
                    println(landingPage.getSeed())
                    landingPage.openExerciseByName(exercisesNames[2])
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
            it("STF-3.2 positive way") {
                landingPage.stf32()
                val seed = stf.getSeedForStf()
                stf.openSolutionPage(seed)
                stf.getSolution() shouldBe goodAnswer
            }
            it("STF-3.2 negative check") {
                landingPage.stf32()
                stf.openSolutionPage("123131")
                stf.getSolution() shouldNotBe goodAnswer
            }
            it("STF-3.8 - positive way") {
                landingPage.stf38()
                stf.clickAlertButton()
                val alertText = stf.getTextFromAlert()
                stf.closeAlert()
                stf.setTextIntoTextBox(alertText)
                stf.pressCheckButton()
                stf.getSolution() shouldBe goodAnswer
            }
            it("STF-3.8 - negative way") {
                landingPage.stf38()
                stf.pressCheckButton()
                stf.getSolution() shouldNotBe goodAnswer
            }
        }
    }

    afterGroup { landingPage.close() }


} // this spec end
) // spek end