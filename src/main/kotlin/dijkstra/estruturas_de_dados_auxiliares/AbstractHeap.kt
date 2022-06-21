package dijkstra.estruturas_de_dados_auxiliares

import java.util.Collections
import kotlin.collections.ArrayList

abstract class AbstractHeap<T> : Heap<T> {
    var elements: ArrayList<T> = ArrayList<T>()

    override val count: Int
        get() = elements.size

    override fun peek(): T? = elements.first()

    override fun insert(element: T) {
        elements.add(element) // 1
        siftUp(count - 1) // 2
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    override fun remove(): T? {
        if (isEmpty) return null // 1

        Collections.swap(elements, 0, count - 1) // 2
        val item = elements.removeAt(count - 1) // 3
        siftDown(0) // 4
        return item
    }

    private fun siftDown(index: Int) {
        var parent = index // 1
        while (true) { // 2
            val left = leftChildIndex(parent) //3
            val right = rightChildIndex(parent)
            var candidate = parent // 4
            if (left < count &&
                compare(elements[left], elements[candidate]) > 0
            ) {
                candidate = left //5
            }
            if (right < count &&
                compare(elements[right], elements[candidate]) > 0
            ) {
                candidate = right // 6
            }
            if (candidate == parent) {
                return // 7
            }
            Collections.swap(elements, parent, candidate) // 8
            parent = candidate
        }
    }

    override fun remove(index: Int): T? {
        if (index >= count) return null // 1

        return if (index == count - 1) {
            elements.removeAt(count - 1) // 2
        } else {
            Collections.swap(elements, index, count - 1) // 3
            val item = elements.removeAt(count - 1) // 4
            siftDown(index) // 5
            siftUp(index)
            item
        }
    }

    private fun index(element: T, i: Int): Int? {
        if (i >= count) {
            return null // 1
        }
        if (compare(element, elements[i]) > 0) {
            return null // 2
        }
        if (element == elements[i]) {
            return i // 3
        }
        val leftChildIndex = index(element, leftChildIndex(i))
        if (leftChildIndex != null) return leftChildIndex // 4
        val rightChildIndex = index(element, rightChildIndex(i))
        if (rightChildIndex != null) return rightChildIndex // 5
        return null // 6
    }

    protected fun heapify(values: ArrayList<T>) {
        elements = values
        if (!elements.isEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    abstract fun compare(a: T, b: T): Int
}