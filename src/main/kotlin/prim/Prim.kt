package prim

import componentes_grafo.Aresta
import componentes_grafo.Grafo
import componentes_grafo.TipoGrafo
import componentes_grafo.Vertice
import dijkstra.estruturas_de_dados_auxiliares.ComparatorPriorityQueueImpl
import dijkstra.estruturas_de_dados_auxiliares.ListaPrioridadeAbstrata
import grafo_com_lista_adjacencia.ListaAdjacencia
import kotlin.math.roundToInt

object Prim {
    // Encontra e guarda as arestas dos vértices explorados
    // Recebe o vértice atual
    // O grafo onde o vértice está guardado
    // Os vértices que já foram visitados
    // Uma lista de prioridade para adicionar os vértices
    private fun <T> adicionarArestasDisponíveis(
        vertice: Vertice<T>,
        grafo: Grafo<T>,
        verticesVisitados: Set<Vertice<T>>,
        listaPrioridade: ListaPrioridadeAbstrata<Aresta<T>>
    ) {
        grafo.arestas(vertice).forEach { aresta ->
            if (aresta.destino !in verticesVisitados) {
                listaPrioridade.enfileirar(aresta)
            }
        }
    }

    //  O método recebe um grafo não direcionado
    // e retorna uma árvore geradora mínima e seu custo
    fun <T> produzirArvoreGeradoreMinima(
        grafo: ListaAdjacencia<T>
    ): Pair<Double, ListaAdjacencia<T>> {
        var custo = 0.0
        // Este grafo será a árvore geradora mínima
        val arvoreGeradora = ListaAdjacencia<T>(TipoGrafo.NAO_DIRECIONADO)
        // Todos os vértices que já foram visitados
        val visitados = mutableSetOf<Vertice<T>>()
        // O comparador é sempre usado para a fila de prioridade
        val comparador = Comparator<Aresta<T>> { primeiro, segundo ->
            val primeiroPeso = primeiro.peso ?: 0.0
            val segundoPeso = segundo.peso ?: 0.0
            (segundoPeso - primeiroPeso).roundToInt()
        }
        val filaPrioridade = ComparatorPriorityQueueImpl(comparador)

        // Todos os vértices do grafo original são copiados para a árvore geradora
        // mínima
        arvoreGeradora.copiarVertices(grafo)

        // Pega o primeiro vértice do grafo
        val primeiroVertice = grafo.vertices.firstOrNull() ?: return Pair(custo, arvoreGeradora)
        // Marca o primeiro vértice como visitado
        visitados.add(primeiroVertice)
        // Adiciona todos os vértices potenciais do vértice inicial à fila de prioridade
        adicionarArestasDisponíveis(primeiroVertice, grafo, visitados, filaPrioridade)

        while (true) {
            // Continuar o algoritmo até a fila de arestas estar vazia
            val arestaDeMenorPeso = filaPrioridade.desenfileirar() ?: break // 1
            // Pegar o vértice de destino
            val vertice = arestaDeMenorPeso.destino
            // Se o vérticw já foi visitado, reiniciar o loop
            // e pegar a próxima aresta de menos peso
            if (visitados.contains(vertice)) continue
            // Marcar o vértice como visitado
            visitados.add(vertice)
            // Adiciona o peso daresta ao custo total
            custo += arestaDeMenorPeso.peso ?: 0.0
            // Adicionar a aresta de menor peso a árvore geradora
            arvoreGeradora.adicionar(arestaDeMenorPeso.origem,
                arestaDeMenorPeso.destino, arestaDeMenorPeso.peso
            )
            // Adicionar as arestas disponíveis do vértice atual
            adicionarArestasDisponíveis(vertice, grafo, visitados, filaPrioridade)
        }

        return Pair(custo, arvoreGeradora)
    }
}