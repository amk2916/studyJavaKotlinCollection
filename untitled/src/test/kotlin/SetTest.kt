import Set.CarSet
import Set.CarHashSetImpl
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SetTest {

    private lateinit var setCar: CarSet


    @BeforeAll
    fun setup() {
        setCar = CarHashSetImpl()
        for (i in 0 until 100) {
            setCar.add(Car("name $i", i))
        }
    }

    @Test
    fun `проверка количества`() {
        assertEquals(100, setCar.size())
    }

    @Test
    fun `существующий элемент`() {
        val car = Car("name 1", 1)
        assertFalse(setCar.add(car))
    }

    @Test
    fun `новый элемент`() {
        val car = Car("name 100", 100)
        assertTrue(setCar.add(car))
        assertEquals(101, setCar.size())
    }

    @Test
    fun `удаление существующего`() {
        val car = Car("name 1", 1)
        assertTrue(setCar.remove(car))
        assertEquals(100, setCar.size())
    }

    @Test
    fun `удаление не существующего`() {
        val car = Car("name 1000", 1000)
        assertFalse(setCar.remove(car))
        assertEquals(100, setCar.size())
    }

    @Test
    fun `очищение списка`(){
        setCar.clear()
        assertEquals(0, setCar.size())
    }


//    fun add(car: Car) : Boolean
//
//    fun remove(car: Car)
//
//    fun size(): Int
//
//    fun clear()
}