package pages

import Config
import io.kotlintest.shouldBe

import io.kotlintest.shouldNotBe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it


class AntycaptchaSpec : Spek({
    describe("Starter") {
        val goodAnswer = "OK. Good answer"
        describe("Cwiczenie1") {
            val exercise = Exercises()
            beforeEachTest { exercise.open(Config.antycaptchaUrl + exercise.url) }
            it("Kliknij B1B2B1 a potem sprawdź (positive one)") {

                exercise.checkSolution() shouldBe goodAnswer
            }
            it("Kliknij B1B2 a potem sprawdź (negative one)") {
                exercise.pressB1()
                exercise.pressB2()
                exercise.checkSolution() shouldNotBe goodAnswer
            }
        }

    }


} // this spec end
) // spek end