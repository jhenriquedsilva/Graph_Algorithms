package componentes_grafo

interface Grafo<T> {
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
}