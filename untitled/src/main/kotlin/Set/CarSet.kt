package Set

import Car

interface CarSet {

    fun add(car: Car) : Boolean

    fun remove(car: Car) : Boolean

    fun size(): Int

    fun clear()
}