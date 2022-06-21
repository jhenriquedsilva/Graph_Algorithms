package dijkstra.estruturas_de_dados_auxiliares


interface Heap<T> : Collection<T> {

    fun peek(): T?
}