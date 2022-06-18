package componentes_grafo

import FilaPilha
import PilhaImpl

interface Grafo<T> {
    val todosVertices: ArrayList<Vertice<T>>
    // Cria um vértice e adiciona no grafo
    fun criarVertice(dado: T): Vertice<T>

    // Adiciona vértice direcionado
    fun adicionarArestaDirecionada(
        origem: Vertice<T>,
        destino: Vertice<T>,
        peso: Double?
    )

    // Adiciona vértie não direcionado
    fun adicionarArestaNaoDirecionada(origem: Vertice<T>, destino: Vertice<T>, peso: Double?)

    // Adiciona uma aresta entre dois vértices
    fun adicionar(aresta: TipoAresta, origem: Vertice<T>, destino: Vertice<T>, peso: Double?)

    // Retorna uma lista com as arestas que saem do vértice
    fun arestas(origem: Vertice<T>): ArrayList<Aresta<T>>

    // Retorna o peso da aresta entre dois vértices
    fun peso(origem: Vertice<T>, destino: Vertice<T>): Double?

    // Métodos irrelevantes por enquanto

//    fun numeroDeCaminhos(origem: Vertice<T>, destino: Vertice<T>): Int {
//        val numeroDeCaminhos = Ref(0) // 1
//        val visitados: ArrayList<Vertice<T>> = arrayListOf() // 2
//        caminhos(origem, destino, visitados, numeroDeCaminhos) // 3
//        return numeroDeCaminhos.valor
//    }

//    fun caminhos(origem: Vertice<T>, destino: Vertice<T>, visitado: ArrayList<Vertice<T>>, contadorCaminho: Ref<Int>) {
//        visitado.add(origem) // 1
//        if (origem == destino) { // 2
//            contadorCaminho.valor += 1
//        } else {
//            val vizinhos = arestas(origem) // 3
//            vizinhos.forEach { aresta ->
//                // 4
//                if (!visitado.contains(aresta.destino)) {
//                    caminhos(aresta.destino, destino, visitado, contadorCaminho)
//                }
//            }
//        }
//        // 5
//        visitado.remove(origem)
//    }

    // Retorna uma lista de vértices na ordem em que foram visitados
    fun buscaEmProfundidade(origem: Vertice<T>): ArrayList<Vertice<T>> {
        // Guarda o caminho que se está percorredno
        val pilha = PilhaImpl<Vertice<T>>()
        // Lembra a ordem em que os vértices foram visitados
        val ordemVisitados = arrayListOf<Vertice<T>>()
        // Lembra quais vértices já foram empilhados
        // para não empilhar novamente
        val empilhados = mutableSetOf<Vertice<T>>()

        // O primeiro vértice é inserido em todas as estruturas de daods inicialmente
        pilha.empilhar(origem)
        empilhados.add(origem)
        ordemVisitados.add(origem)

        // Enquanto a pilha naão estiver vazia, contuniar verificando seu topo
        outer@ while (true) {
            if (pilha.estaVazia) break
            val vertice = pilha.elementoTopo()!!
            val arestas = arestas(vertice)
            // Se não houver arestas para o vértice atual
            // este vértice é desempilhado e se vai para o
            // próximo vértice da pilha
            if (arestas.isEmpty()) {
                pilha.desempilhar()
                continue
            }

            // Verifica se os vértices vizinhos já foram visitados
            // Adiciona na pilha e lista de visitados
            for (index in 0 until arestas.size) {
                val destino = arestas[index].destino
                if (destino !in empilhados) {
                    pilha.empilhar(destino)
                    empilhados.add(destino)
                    ordemVisitados.add(destino)
                    // Depois que um novo vértice foi adicionado na pilha,
                    // agora deve-se continuar o while de fora (outer) para
                    // visitá-lo
                    continue@outer
                }
            }
            // Se todos os vizinhos do vértice atual
            // já foram visitados, então desempilha-o
            pilha.desempilhar()
        }

        // Esta seção só é alcançada quando a pilha está vazia
        return ordemVisitados
    }

    fun buscaEmLargura(origem: Vertice<T>): ArrayList<Vertice<T>> {
        // Ficam armazenados os próximos vértices que serão visitados
        val fila = FilaPilha<Vertice<T>>()
        // Armazena os vértices que já foram enfileirados. Para não enfileirá-los novamente
        val enfileirados = ArrayList<Vertice<T>>()
        // Armazena a ordem na qual os vértices foram explorados
        val visitados = ArrayList<Vertice<T>>()

        // O algoritmo inicia enfileirando o vértice de origem
        fila.enfileirar(origem)
        enfileirados.add(origem)

        while (true) {
            // Enquanto a fila estiver ocupada, continuar desenfileirando
            val vertice = fila.desenfileirar() ?: break

            // Se o vértice já foi visitado, adicionar na lista de visitados
            visitados.add(vertice)

            val arestas = arestas(vertice) // 4
            arestas.forEach { aresta ->
                if (!visitados.contains(aresta.destino)) { // 5
                    fila.enfileirar(aresta.destino)
                    enfileirados.add(aresta.destino)
                }
            }

        }

        return visitados
    }

    fun eDesconexo(): Boolean {
        val primeiroVertice = todosVertices.firstOrNull() ?: return false

        val visitados = buscaEmLargura(primeiroVertice)
        todosVertices.forEach { vertice ->
            // Se um dos vértices não foi visitado,
            // então o grafo é desconexo
            if (!visitados.contains(vertice)) return true
        }

        return false
    }
}