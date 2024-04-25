import java.lang.IndexOutOfBoundsException

class CarLinkedList : CarList {

    private var first: Node? = null
    private var last: Node? = null
    private var size: Int = 0

    override fun add(car: Car) {
        if(size == 0 ){
            val node = Node(null, car, null)
            first = node
            last = node
        }else{
            val secondLast = last
            last = Node(secondLast, car, null)
            secondLast!!.next = last
        }
        size++
    }

    override fun add(car: Car, index: Int) {
        if(index < 0 || index > size){
            throw IndexOutOfBoundsException()
        }
        if(index == size){
            add(car)
            return
        }
        val nodeNext = getNode(index)
        val nodePrev = nodeNext!!.previous
        val newNode = Node(nodePrev, car, nodeNext)
        nodeNext.previous = newNode
        if(nodePrev!= null) {
            nodePrev.next = newNode
        }else{
            first = newNode
        }
        size++

    }

    override fun get(index: Int): Car {
        return getNode(index)?.value!!
    }

    override fun remove(car: Car): Boolean {
        var node = first
        for(i in 0 until size){
            if(node?.value == car){
                return removeAt(i)
            }
            node = node?.next
        }
        return false
    }

    override fun removeAt(index: Int): Boolean {
        val node = getNode(index)
        val next = node?.next
        val prev = node?.previous

        if(next !=null){
            next?.previous = prev
        }else{
            last = prev
        }
        if(prev != null) {
            prev.next = next
        }else{
            first =next
        }
        size--
        return true
    }

    override fun size(): Int {
        return size
    }

    override fun clear() {
        first = null
        last = null
        size = 0
    }


    private fun getNode(index: Int): Node?{
        if(index <0 || index >= size){
            throw IndexOutOfBoundsException()
        }
        var node = first
        for (i in 0 until index){
            node = node!!.next
        }
        return node
    }

    private data class Node(
        var previous: Node?,
        val value: Car,
        var next: Node?
    )
}