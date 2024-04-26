package List

import Car
import CollectionCar

interface CarList : CollectionCar {

    override fun add(car: Car) : Boolean

    fun add(car: Car, index: Int) : Boolean

    fun get(index: Int) : Car

    override fun remove(car: Car) : Boolean

    fun removeAt(index: Int) : Boolean

    override fun size() : Int

    override fun clear()

}