interface CollectionCar {

    fun add(car: Car): Boolean

    fun remove(car: Car) : Boolean

    fun size(): Int

    fun clear()

    fun contains(car: Car): Boolean

}