import List.CarArrayListImpl
import List.CarLinkedList
import List.CarList
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertFalse

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarListTest {
    private var count = 0
    private lateinit var carList: CarList


    @BeforeAll
    fun setupCarList() {
        count++
        carList = CarLinkedList()
        for (i in 0 until 100) {
            carList.add(Car("name$i", i))
        }
    }

    @Test
    fun checkSize(){
        count++
        assertEquals(100, carList.size())
    }

    @Test
    fun addCar(){
        count++
        carList.add(Car("adfsgkljnkasdfng", 101))
        assertEquals(101, carList.size())
    }


    @Test
    fun removeForIndex(){

        carList.removeAt(4)
        val c= carList.size()
        assertEquals(100,c )
    }


    @Test
    fun removeCar(){
        count++
        val a = carList.remove(Car("asdfasf", 100101 ))
        assertFalse(a)
    }
    @Test
    fun addPoIndexInArray(){
        count++
        val newCar = Car("BMW X6", 1231)
        carList.add(newCar, 50)
        assertEquals(newCar,carList.get(50))

    }

}