package componentes_grafo

data class Aresta<T>(
    val origem: Vertice<T>,
    val destino: Vertice<T>,
    val peso: Double? = null
)