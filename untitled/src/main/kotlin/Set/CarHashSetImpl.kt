package Set

import Car
import kotlin.math.abs

class CarHashSetImpl : CarSet {


    private var size = 0

    private var array = arrayOfNulls<Entry?>(INITIAL_CAPACITY)



    override fun add(car: Car): Boolean {
        if(size >= LOAD_FACTOR * array.size){
            increaseArray()
        }
        val added = add(car, this.array)
        return if (added){
            size++
            true
        }else{
            false
        }

    }

    private fun add(car: Car, array: Array<Entry?>) : Boolean{
        val position = getElementPosition(car, array.size)
        if (array[position] == null) {
            val entry = Entry(car, null)
            array[position] = entry

            return true
        } else {
            var existedElement = array[position]
            while (true) {
                if (existedElement!!.value == car) {
                    return false
                } else if (existedElement.next == null) {
                    existedElement.next = Entry(car, null)

                    return true
                } else {
                    existedElement = existedElement.next
                }
            }
        }
    }

    override fun remove(car: Car): Boolean {
        val position = getElementPosition(car, array.size)
        if(array[position] == null){
            return false
        }else {
            var secondLast = array[position]!!
            var last = secondLast.next
            if (secondLast.value == car) {
                array[position] = last
                size--
                return true
            }
            while (last != null)
                if (last.value == car) {
                    secondLast.next = last.next
                    size--
                    return true
                } else {
                    secondLast = last
                    last = last.next
                }
        }

        return false
    }

    override fun size(): Int {
        return size
    }

    override fun clear() {
        array = arrayOfNulls<Entry?>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(car: Car): Boolean {
        if(size() == 0) return false

        val position = getElementPosition(car, array.size)
        var checkCar = array[position] ?: return false

        if(checkCar.value == car){
            return true
        } else {
            while (checkCar.next != null) {
                checkCar = checkCar.next!!
                if (checkCar.value == car) return true
            }
        }
        return false
    }

    private fun getElementPosition(car: Car, arrayLength: Int): Int {
        return abs(car.hashCode()) % arrayLength
    }

    private data class Entry(
        var value: Car?,
        var next: Entry?
    )

    private fun increaseArray(){
        val newArray = arrayOfNulls<Entry>(array.size * 2)
        array.forEach { entry ->
            var existedElement = entry
            while (existedElement != null){
                add(existedElement.value!!, newArray)
                existedElement = existedElement.next
            }
        }
        this.array = newArray
    }
    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }

}