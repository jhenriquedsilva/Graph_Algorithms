class PilhaImpl<T> : Pilha<T> {

    private val vertices = arrayListOf<T>()

    companion object {
        fun <T> criar(items: Iterable<T>): Pilha<T> {
            val pilha = PilhaImpl<T>()
            for (item in items) {
                pilha.empilhar(item)
            }
            return pilha
        }
    }

    override fun empilhar(elemento: T) {
        vertices.add(elemento)
    }

    override fun desempilhar(): T? {
        if (estaVazia) {
            return null
        }
        return vertices.removeAt(tamanho - 1)
    }

    override fun elementoTopo(): T? {
        return vertices.lastOrNull()
    }

    override val tamanho: Int
        get() = vertices.size

    override fun toString() = buildString {
        appendLine("----top----")
        vertices.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }
}

fun <T> pilhaAPartir(vararg elementos: T): Pilha<T> {
    return PilhaImpl.criar(elementos.asList())
}