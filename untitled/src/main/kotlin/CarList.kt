interface CarList {

    fun add(car: Car)

    fun get(index: Int) : Car

    fun remove(car: Car) : Boolean

    fun removeAt(index: Int) : Boolean

    fun size() : Int

    fun clear()

}