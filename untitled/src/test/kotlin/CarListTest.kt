import List.CarLinkedList
import List.CarList
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertFalse

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarListTest {

    private lateinit var carList: CarList


    @BeforeAll
    fun setupCarList() {
        carList = CarLinkedList()
        for (i in 0 until 100) {
            carList.add(Car("name$i", i))
        }
    }

    @Test
    fun checkSize(){
        assertEquals(100, carList.size())
    }

    @Test
    fun removeForIndex(){
        carList.removeAt(4)
        val a= carList.size()
        assertEquals(99,a )
    }

    @Test
    fun addCar(){
        carList.add(Car("adfsgkljnkasdfng", 101))
        assertEquals(101, carList.size())
    }

    @Test
    fun removeCar(){
        val a = carList.remove(Car("asdfasf", 100101 ))
        assertFalse(a)
    }
    @Test
    fun addPoIndexInArray(){
        val newCar = Car("BMW X6", 1231)
        carList.add(newCar, 99)
        assertEquals(newCar,carList.get(99))

    }




//    fun add(car: Car)
//
//    fun get(index: Int) : Car
//
//    fun remove(car: Car) : Boolean
//
//    fun removeAt(index: Int) : Boolean
}