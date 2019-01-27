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
            val exercise1 = Exercises()
            beforeEachTest { exercise1.open(Config.antycaptchaUrl + exercise1.url) }
            it("Kliknij B1B2B1 a potem sprawdź (positive one)") {
                exercise1.pressB1()
                exercise1.pressB2()
                exercise1.pressB1()
                exercise1.checkSolution() shouldBe goodAnswer
            }
            it("Kliknij B1B2 a potem sprawdź (negative one)") {
                exercise1.pressB1()
                exercise1.pressB2()
                exercise1.checkSolution() shouldNotBe goodAnswer
            }
        }

    }


} // this spec end
) // spek end