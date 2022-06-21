package dijkstra.estruturas_de_dados_auxiliares

interface Collection<T> {
    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: T)

    fun remove(): T?

    fun remove(index: Int): T?
}