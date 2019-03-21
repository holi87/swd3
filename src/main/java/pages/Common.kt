package pages


/**
 * val => value -> raz przypisane, nie zmiennne
 *
 * var => variable -> można zmieniać przypisanie w obrębie danego typu
 * */

open class Common {

    fun open(url: String){
        Config.driver.get(url)
        // url musi być stringiem z początkiem http/https
    }

    fun closeBrowser(){
        Config.driver.quit()
    }
}
