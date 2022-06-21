package dijkstra.estruturas_de_dados_auxiliares

class ComparablePriorityQueueImpl<T : Comparable<T>> :
    ListaPrioridadeAbstrata<T>() {

    override val heap = ComparableHeapImpl<T>()
}