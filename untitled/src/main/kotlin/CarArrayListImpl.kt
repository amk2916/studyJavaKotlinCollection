class CarArrayListImpl : CarList {

    private var arrayCar: Array<Car?> = arrayOfNulls(10)
    private var sizeCar = 0

    override fun add(car: Car) {
        resizeArray()
        arrayCar[sizeCar] = car
        sizeCar++
    }

    override fun add(car: Car, index: Int) {
        resizeArray()
        if (index < 0 || index > sizeCar) {
            throw IndexOutOfBoundsException()
        }

//        for(i in sizeCar downTo   index + 1 ){
//            arrayCar[i] = arrayCar[i-1]
//        }

        /*
        1 - исходный массив, у которого будем перемещать элементы
        2 - исходная позиция , откуда мы будем перемещать элементы в право (хотим вставку в 5й элемент, значит с 5го элемента переместим вправо все)
        3 - складываем данные элементы в тот же массив
        4 - складываем все эти элементы на позиции +1
        5 - сколько элементов нужно переместить
         */
        System.arraycopy(arrayCar, index, arrayCar, index + 1, sizeCar - index)

        arrayCar[index] = car

        sizeCar++
    }


    override fun get(index: Int): Car {
        checkSize(index)
        // Выполнили проверку на индекс, следовательно null  по индексу не может быть
        return arrayCar[index]!!
    }

    override fun remove(car: Car): Boolean {
        for (i in arrayCar.indices) {
            if (arrayCar[i] == car) {
                removeAt(i)
                return true
            }
        }
        return false
    }

    override fun removeAt(index: Int): Boolean {
        checkSize(index)
        for (i in index until arrayCar.size - 1) {
            arrayCar[i] = arrayCar[i + 1]
        }
        sizeCar--
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

    private fun resizeArray() {
        if (sizeCar >= arrayCar.size) {
            arrayCar = arrayCar.copyOf(arrayCar.size + 10)
        }
    }
}