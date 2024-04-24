import java.lang.IndexOutOfBoundsException

class CarArrayListImpl : CarList {

    private var arrayCar: Array<Car?> = arrayOfNulls(10)
    private var sizeCar = 0

    override fun add(car: Car) {
        if (sizeCar >= arrayCar.size){
            arrayCar = arrayCar.copyOf(arrayCar.size + 10)
        }
        arrayCar[sizeCar] = car
        sizeCar++
    }

    override fun get(index: Int): Car {
        checkSize(index)
        // Выполнили проверку на индекс, следовательно null  по индексу не может быть
        return arrayCar[index]!!
    }

    override fun remove(car: Car): Boolean {
        for (i in arrayCar.indices){
            if(arrayCar[i] == car ){
                removeAt(i)
                return true
            }
        }
        return false
    }

    override fun removeAt(index: Int): Boolean{
        checkSize(index)
        for(i in index until arrayCar.size - 1){
            arrayCar[i] = arrayCar[i+1]
        }
        sizeCar --
        return true
    }

    override fun size(): Int = sizeCar

    override fun clear() {
        arrayCar = arrayOfNulls(10)
        sizeCar = 0
    }

    private fun checkSize(index: Int) {
        if (index >= sizeCar) {
            throw IndexOutOfBoundsException()
        }
    }
}