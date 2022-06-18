import componentes_grafo.TipoAresta
import grafo_com_lista_adjacencia.ListaAdjacencia

fun main() {
//    val graph = ListaAdjacencia<String>()
//    val singapore = graph.criarVertice("Singapore")
//    val tokyo = graph.criarVertice("Tokyo")
//    val hongKong = graph.criarVertice("Hong Kong")
//    val detroit = graph.criarVertice("Detroit")
//    val sanFrancisco = graph.criarVertice("San Francisco")
//    val washingtonDC = graph.criarVertice("Washington DC")
//    val austinTexas = graph.criarVertice("Austin Texas")
//    val seattle = graph.criarVertice("Seattle")
//
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, singapore, hongKong, 300.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, singapore, tokyo, 500.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, hongKong, tokyo, 250.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, tokyo, detroit, 450.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, tokyo, washingtonDC, 300.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, hongKong, sanFrancisco, 600.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, detroit, austinTexas, 50.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, austinTexas, washingtonDC, 292.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, sanFrancisco, washingtonDC, 337.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, washingtonDC, seattle, 277.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, sanFrancisco, seattle, 218.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, austinTexas, sanFrancisco, 297.0)
//    println(graph)


//    val graph = MatrizAdjacencia<String>()
//    val singapore = graph.criarVertice("Singapore")
//    val tokyo = graph.criarVertice("Tokyo")
//    val hongKong = graph.criarVertice("Hong Kong")
//    val detroit = graph.criarVertice("Detroit")
//    val sanFrancisco = graph.criarVertice("San Francisco")
//    val washingtonDC = graph.criarVertice("Washington DC")
//    val austinTexas = graph.criarVertice("Austin Texas")
//    val seattle = graph.criarVertice("Seattle")
//
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, singapore, hongKong, 300.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, singapore, tokyo, 500.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, hongKong, tokyo, 250.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, tokyo, detroit, 450.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, tokyo, washingtonDC, 300.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, hongKong, sanFrancisco, 600.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, detroit, austinTexas, 50.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, austinTexas, washingtonDC, 292.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, sanFrancisco, washingtonDC, 337.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, washingtonDC, seattle, 277.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, sanFrancisco, seattle, 218.0)
//    graph.adicionar(TipoAresta.NAO_DIRECIONADO, austinTexas, sanFrancisco, 297.0)
//    println(graph)

    val grafo = ListaAdjacencia<String>()
    val a = grafo.criarVertice("A")
    val b = grafo.criarVertice("B")
    val c = grafo.criarVertice("C")
    val d = grafo.criarVertice("D")
    val e = grafo.criarVertice("E")
    val f = grafo.criarVertice("F")
    val g = grafo.criarVertice("G")
    val h = grafo.criarVertice("H")

    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, a, b, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, a, c, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, a, d, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, b, e, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, c, f, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, c, g, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, e, h, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, e, f, null)
    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, f, g, null)

//    val vertices = graph.buscaEmLargura(a)
//    vertices.forEach { vertice ->
//        println(vertice.dado)
//    }

    val vertices = grafo.buscaEmProfundidade(a)
    vertices.forEach { vertice ->
        println(vertice.dado)
    }
}