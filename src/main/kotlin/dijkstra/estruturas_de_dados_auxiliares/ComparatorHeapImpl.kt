package dijkstra.estruturas_de_dados_auxiliares

class ComparatorHeapImpl<T>(
    private val comparator: Comparator<T>
) : AbstractHeap<T>() {

    companion object {
        fun <T : Any> create(
            elements: ArrayList<T>,
            comparator: Comparator<T>
        ): Heap<T> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }

    override fun compare(a: T, b: T): Int =
        comparator.compare(a, b)
}