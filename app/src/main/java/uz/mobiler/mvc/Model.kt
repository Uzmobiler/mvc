package uz.mobiler.mvc

import java.util.*

class Model : Observable() {

    val list: MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(the_index: Int): Int {
        return list[the_index]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(the_index: Int) {
        list[the_index] += 1
        setChanged()
        notifyObservers()
    }
}