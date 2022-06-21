package dijkstra.estruturas_de_dados_auxiliares

class ComparatorPriorityQueueImpl<T>(
    private val comparator: Comparator<T>
) : ListaPrioridadeAbstrata<T>() {

    override val heap = ComparatorHeapImpl(comparator)
}