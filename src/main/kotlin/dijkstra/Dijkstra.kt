package dijkstra

import componentes_grafo.Aresta
import componentes_grafo.Vertice
import dijkstra.estruturas_de_dados_auxiliares.ComparatorPriorityQueueImpl
import grafo_com_lista_adjacencia.ListaAdjacencia

class Dijkstra<T>(private val grafo: ListaAdjacencia<T>) {

    // É nencessário saber o peso total do vértice atual
    // até o vértice inicial
    // Recebe o vértice de destino e um mapa com os caminhos existentes
    // Sendo assim, ele constrói um caminho que leva até o vértice de destino
    private fun rota(
        destino: Vertice<T>, caminhos:
        HashMap<Vertice<T>, Visita<T>>
    ): ArrayList<Aresta<T>> {
        // O mapa 'caminhos' guarda uma estado de visita
        // para cada vértice

        // Inicia no vértice de destino
        var vertice = destino
        // Guarda o caminho percorrido
        val caminho = arrayListOf<Aresta<T>>()

        loop@ while (true) {
            val visita = caminhos[vertice] ?: break
            when (visita.tipo) {
                // Enquanto o início não for encontrado, continuar
                // extraindo as próximas arestas
                TipoVisita.ARESTA -> visita.aresta?.let { aresta ->
                    // Adiciona aresta ao caminho
                    caminho.add(aresta)
                    // O vértica atual passa a ser a origem da aresta
                    // Isso me aproxima do vértice inicial
                    vertice = aresta.origem
                }
                // Quando o vértice de início for encontrado,
                // significa que o caminho foi encontrado.
                TipoVisita.INICIO -> break@loop
            }
        }
        return caminho
    }

    private fun distancia(destino: Vertice<T>, caminhos: HashMap<Vertice<T>, Visita<T>>): Double {
        // Constrói o caminho para o vértice de destino
        val caminho = rota(destino, caminhos)
        // O spesos dos vértices são somados
        return caminho.sumOf { aresta ->
            aresta.peso ?: 0.0
        }
    }

    // Recebe um vértice de origem e retorna um dicionário com todos
    // os caminhos
    fun calcularCaminhoMaisCurto(origem: Vertice<T>): HashMap<Vertice<T>, Visita<T>> {
        // Cria os caminhos
        val caminhos: HashMap<Vertice<T>, Visita<T>> = HashMap()
        // Inicializa os caminhos os caminhos com ovértice origem
        caminhos[origem] = Visita(TipoVisita.INICIO)

        val comparadorDistancia = Comparator<Vertice<T>> { primeiro, segundo ->
            (distancia(segundo, caminhos) - distancia(primeiro, caminhos)).toInt()
        }

        // Serão armazenados os vértices que deverão ser visitados
        val filaPrioridade =
            ComparatorPriorityQueueImpl(comparadorDistancia)

        // O primeiro vértice é enfileriado para ser visitado
        filaPrioridade.enfileirar(origem)

        while (true) {
            // Todos os vértices são visitados
            // Quando todos forem visitados, A lista de prioridade ficará vazia
            val vertice = filaPrioridade.desenfileirar() ?: break
            // Para o vértice atual, passar por todas as suas arestas
            val arestas = grafo.arestas(vertice)

            arestas.forEach { aresta ->
                // Verificar se a aresta possui um peso. Se não, mover
                // para a próxima iteração
                val peso = aresta.peso ?: return@forEach
                // Se o vértice de destino não foi visitado antes
                // ou um caminho mais curto é encontrado, o caminho é
                // atualizado e o vértice de destino é edicionado à lista de
                // prioridade
                if (caminhos[aresta.destino] == null
                    || (distancia(vertice, caminhos) + peso <
                    distancia(aresta.destino, caminhos))
                ) {
                    caminhos[aresta.destino] = Visita(TipoVisita.ARESTA, aresta)
                    filaPrioridade.enfileirar(aresta.destino)
                }
            }
        }
        // Quando todos os vértices foram visitados,
        // um mapa com todos os caminhos mais curtos
        // para o vértice de origem é retornado
        return caminhos
    }

    // Recebe um vértice de destino e um mapa com os caminhos
    // mais curtos e retorn um caminho para o vértice de destino
    fun calcularCaminhoMaisCurto(destino: Vertice<T>, caminhos: HashMap<Vertice<T>, Visita<T>>): ArrayList<Aresta<T>> {
        return rota(destino, caminhos)
    }
}