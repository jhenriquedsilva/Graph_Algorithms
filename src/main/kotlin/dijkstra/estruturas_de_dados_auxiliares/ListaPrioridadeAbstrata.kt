package dijkstra.estruturas_de_dados_auxiliares

import estruturas_de_dados_auxiliares.Fila

abstract class ListaPrioridadeAbstrata<T> : Fila<T> {

    abstract val heap: Heap<T>

    override val count: Int
        get() = heap.count

    override fun enfileirar(element: T): Boolean {
        heap.insert(element)
        return true
    }

    override fun desenfileirar() = heap.remove()

    override fun recuperarElementoFrente() = heap.peek()
}