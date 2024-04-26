import Set.CarSet
import Set.CarHashSetImpl
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    fun `qq`() {
        assertEquals(100, setCar.size())
    }

    @Test
    fun `qqq`() {
        val car = Car("name 1", 1)
        assertFalse(setCar.add(car))
    }

    @Test
    fun `qqqq`() {
        val car = Car("name 100", 100)
        assertTrue(setCar.add(car))
        assertEquals(101, setCar.size())
    }

    @Test
    fun `qqqqq`() {
        val car = Car("name 1", 1)
        assertTrue(setCar.remove(car))
        assertEquals(100, setCar.size())
    }

    @Test
    fun `qqqqqq`() {
        val car = Car("name 1000", 1000)
        assertFalse(setCar.remove(car))
        assertEquals(100, setCar.size())
    }

    @Test
    fun `qqqqqqq`(){
        setCar.clear()
        assertEquals(0, setCar.size())
    }


}