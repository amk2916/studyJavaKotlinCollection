import List.CarArrayListImpl
import List.CarLinkedList
import List.CarList
import org.junit.jupiter.api.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
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
    @Order(1)
    fun checkSize(){
        count++
        assertEquals(100, carList.size())
    }

    @Test
    @Order(2)
    fun addCar(){
        count++
        carList.add(Car("adfsgkljnkasdfng", 101))
        assertEquals(101, carList.size())
    }


    @Test
    @Order(3)
    fun removeForIndex(){

        carList.removeAt(4)
        val c= carList.size()
        assertEquals(100,c )
    }


    @Test
    @Order(4)
    fun removeCar(){
        count++
        val a = carList.remove(Car("asdfasf", 100101 ))
        assertFalse(a)
    }
    @Test
    @Order(5)
    fun addPoIndexInArray(){
        count++
        val newCar = Car("BMW X6", 1231)
        carList.add(newCar, 50)
        assertEquals(newCar,carList.get(50))

    }

    @Test
    @Order(6)
    fun checkContains(){
        assertTrue(carList.contains(Car("name10", 10)))
        assertFalse(carList.contains(Car("sfkld;jn;sdjkg", 100000)))
    }

}