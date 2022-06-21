package dijkstra

// Define 2 estados: o vértice é o de origem ou
// ou possui uma aresta associada que leva para um caminho
// que alcança o vértice inicial
enum class TipoVisita {
    // O vértice é o vértice inicial
    INICIO,
    // O vértice possui uma aresta associada que leva para o vértice inicial
    ARESTA
}