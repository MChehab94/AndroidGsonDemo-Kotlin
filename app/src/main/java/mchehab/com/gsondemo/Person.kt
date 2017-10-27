package mchehab.com.gsondemo

/**
 * Created by muhammadchehab on 10/27/17.
 */
data class Person(var firstName: String, var lastName: String, var age: Int){
    override fun toString(): String {
        return "$firstName $lastName is $age years old"
    }
}