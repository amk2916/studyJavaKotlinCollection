package List

import Car

interface CarList {

    fun add(car: Car)

    fun add(car: Car, index: Int)

    fun get(index: Int) : Car

    fun remove(car: Car) : Boolean

    fun removeAt(index: Int) : Boolean

    fun size() : Int

    fun clear()

}