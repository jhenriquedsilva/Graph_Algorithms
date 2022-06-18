interface Pilha<T> {

    /**
     * Push of an T into the stack.Stack
     */
    fun empilhar(elemento: T)

    /**
     * Pops an element from the stack.Stack if any or returns null.
     */
    fun desempilhar(): T?

    val tamanho: Int

    fun elementoTopo(): T?

    val estaVazia: Boolean
        get() = tamanho == 0
}