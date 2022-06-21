package dijkstra.estruturas_de_dados_auxiliares

class ComparableHeapImpl<T : Comparable<T>> : AbstractHeap<T>() {

    companion object {
        fun <T : Comparable<T>> create(
            elements: ArrayList<T>
        ): Heap<T> {
            val heap = ComparableHeapImpl<T>()
            heap.heapify(elements)
            return heap
        }
    }

    override fun compare(a: T, b: T): Int = a.compareTo(b)
}