package estruturas_de_dados_auxiliares

interface Fila<T> {

    fun enfileirar(element: T): Boolean

    fun desenfileirar(): T?

    val count: Int

    val estaVazio: Boolean
        get() = count == 0

    fun recuperarElementoFrente(): T?
}