package Set

import Car
import CollectionCar

interface CarSet : CollectionCar {

    override fun add(car: Car): Boolean

    override fun remove(car: Car): Boolean

    override fun size(): Int

    override fun clear()

    override fun contains(car: Car): Boolean

}