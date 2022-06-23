import componentes_grafo.TipoGrafo
import grafo_com_lista_adjacencia.ListaAdjacencia
import grafo_com_matriz_de_adjacencia.MatrizAdjacencia
import prim.Prim

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

//
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, a, b, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, a, c, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, a, d, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, b, e, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, c, f, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, c, g, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, e, h, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, e, f, null)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, f, g, null)
//
////    val vertices = graph.buscaEmLargura(a)
////    vertices.forEach { vertice ->
////        println(vertice.dado)
////    }
//
//    val vertices = grafo.buscaEmProfundidade(a)
//    vertices.forEach { vertice ->
//        println(vertice.dado)
//    }

//    val grafo = ListaAdjacencia<String>()
//    val a = grafo.criarVertice("A")
//    val b = grafo.criarVertice("B")
//    val c = grafo.criarVertice("C")
//    val d = grafo.criarVertice("D")
//    val e = grafo.criarVertice("E")
//    val f = grafo.criarVertice("F")
//    val g = grafo.criarVertice("G")
//    val h = grafo.criarVertice("H")
//
//    grafo.adicionar(TipoAresta.DIRECIONADO, a, b, 8.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, a, f, 9.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, a, g, 1.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, b, f, 3.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, b, e, 1.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, f, a, 2.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, h, f, 2.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, h, g, 5.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, g, c, 3.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, c, e, 1.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, c, b, 3.0)
//    grafo.adicionar(TipoAresta.NAO_DIRECIONADO, e, c, 8.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, e, b, 1.0)
//    grafo.adicionar(TipoAresta.DIRECIONADO, e, d, 2.0)
//
//    val dijkstra = Dijkstra(grafo)
//    val caminhosIniciandoNoVerticeA = dijkstra.calcularCaminhoMaisCurto(g)
//    val caminho = dijkstra.calcularCaminhoMaisCurto(a, caminhosIniciandoNoVerticeA)
//    caminho.reversed().forEach { aresta ->
//        println("${aresta.origem.dado} --|${aresta.peso ?: 0.0}|--> ${aresta.destino.dado}")
//    }

    val grafo = ListaAdjacencia<Int>(TipoGrafo.NAO_DIRECIONADO)
    val zero = grafo.criarVertice(0)
    val um = grafo.criarVertice(1)
    val dois = grafo.criarVertice(2)
    val tres = grafo.criarVertice(3)
    val quatro = grafo.criarVertice(4)
    val cinco = grafo.criarVertice(5)
    grafo.adicionar(zero, dois, 1.0)
    grafo.adicionar( zero, tres, 5.0)
    grafo.adicionar( zero, um, 6.0)
    grafo.adicionar(dois, tres, 2.0)
    grafo.adicionar(dois, um, 2.0)
    grafo.adicionar(dois, quatro, 6.0)
    grafo.adicionar(dois, cinco, 4.0)
    grafo.adicionar(tres, cinco, 4.0)
    grafo.adicionar(um, quatro, 5.0)
    grafo.adicionar(quatro, cinco, 3.0)

    println(grafo)

    // Verificar a existência de uma aresta
    println(grafo.procurarAresta(um, quatro))
    println(grafo.procurarAresta(dois, zero))

    println(grafo.calcularGrau(um))
    println(grafo.recuperarAdjacencias(quatro))

    val (custo, arvoreGeradora) = Prim.produzirArvoreGeradoreMinima(grafo)
    println("Custo: $custo")
    println("Árvore Geradora: ")
    println(arvoreGeradora)
}