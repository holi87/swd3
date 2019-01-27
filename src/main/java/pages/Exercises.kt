package pages

class Exercises : Common() {
    val url = "exercises/exercise1"

    fun pressB1() {
        pressButtonById("btnButton1")
    }

    fun pressB2() {
        pressButtonById("btnButton2")
    }


}