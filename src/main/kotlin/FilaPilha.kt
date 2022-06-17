class FilaPilha<T> : Fila<T> {

    private var pilhaEsquerda = arrayListOf<T>()
    private var pilhaDireita = arrayListOf<T>()

    override fun enfileirar(elemento: T): Boolean {
        pilhaDireita.add(elemento)
        return true
    }

    override fun desenfileirar(): T? {
        if (pilhaDireita.isEmpty()) return null

        if (pilhaEsquerda.isEmpty()) {
            pilhaEsquerda = ArrayList(pilhaDireita.asReversed())
            pilhaDireita = arrayListOf()
        }

        return pilhaEsquerda.removeAt(pilhaEsquerda.size - 1)
    }

    override val count = pilhaEsquerda.size + pilhaDireita.size

    // Retorna o elemento da frente da pilha, mas não o elimina
    override fun recuperarElementoFrente(): T? {
        return if (!pilhaEsquerda.isEmpty()) pilhaEsquerda.lastOrNull() else pilhaDireita.firstOrNull()
    }
}