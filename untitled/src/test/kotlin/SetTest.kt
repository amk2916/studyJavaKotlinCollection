import Set.CarHashSetImpl
import Set.CarSet
import org.junit.jupiter.api.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
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
    @Order(1)
    fun `qq`() {
        assertEquals(100, setCar.size())
    }

    @Test
    @Order(2)
    fun `qqq`() {
        val car = Car("name 1", 1)
        assertFalse(setCar.add(car))
    }

    @Test
    @Order(3)
    fun `qqqq`() {
        val car = Car("name 100", 100)
        assertTrue(setCar.add(car))
        assertEquals(101, setCar.size())
    }

    @Test
    @Order(4)
    fun `qqqqq`() {
        val car = Car("name 1", 1)
        assertTrue(setCar.remove(car))
        assertEquals(100, setCar.size())
    }

    @Test
    @Order(5)
    fun `qqqqqq`() {
        val car = Car("name 1000", 1000)
        assertFalse(setCar.remove(car))
        assertEquals(100, setCar.size())
    }

    @Test
    @Order(6)
    fun checkContains(){
        assertTrue(setCar.contains(Car("name 10", 10)))
        assertFalse(setCar.contains(Car("sfkld;jn;sdjkg", 100000)))
    }

    @Test
    @Order(7)
    fun `qqqqqqq`(){
        setCar.clear()
        assertEquals(0, setCar.size())
    }
}