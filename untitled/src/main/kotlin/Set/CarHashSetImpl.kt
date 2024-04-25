package Set

import Car
import kotlin.math.abs

class CarHashSetImpl : CarSet {


    private var size = 0

    private var array = arrayOfNulls<Entry?>(INITIAL_CAPACITY)

    override fun add(car: Car): Boolean {
        val position = getElementPosition(car, array.size)
        if (array[position] == null) {
            val entry = Entry(car, null)
            array[position] = entry
            size++
            return true
        } else {
            var existedElement = array[position]
            while (true) {
                if (existedElement!!.value == car) {
                    return false
                } else if (existedElement.next == null) {
                    existedElement.next = Entry(car, null)
                    size++
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
        }else{
            var secondLast = array[position]!!
            var last = secondLast.next
            if(secondLast.value == car){

            }

            var existedElement = array[position]
            if(existedElement!!.value == car){
                if (existedElement.next != null){
                    array[position] = existedElement.next
                    size--
                    return true
                }else{
                    array[position] = null
                    size--
                    return true
                }
            }else {
                if(existedElement!!.next == null){
                    return false
                }else{
                    if()
                }
            }
        }
    }

    override fun size(): Int {
        return size
    }

    override fun clear() {
        array = arrayOfNulls<Entry?>(INITIAL_CAPACITY)
        size = 0
    }

    private fun getElementPosition(car: Car, arrayLength: Int): Int {
        return abs(car.hashCode()) % arrayLength
    }

    private data class Entry(
        var value: Car?,
        var next: Entry?
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
    }

}