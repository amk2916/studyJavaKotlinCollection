import List.CarArrayListImpl

fun main(args: Array<String>) {

    var carList = CarArrayListImpl()
    for (i in 0 until 99) {
        carList.add(Car("name$i", i))
    }



}