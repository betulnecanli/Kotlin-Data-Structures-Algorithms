package com.betulnecanli.kotlindatastructuresalgorithms.Graphs

fun main(){
    //val graph = AdjacencyList<String>()
    val graph = AdjacencyMatrix<String>()
    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")
    graph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC,
        337.0)
    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)
    println(graph)
    //Output for AdjacencyList<String>()
    //Detroit ---> [ Tokyo, Austin Texas ]
    //Hong Kong ---> [ Singapore, Tokyo, San Francisco ]
    //Singapore ---> [ Hong Kong, Tokyo ]
    //Washington DC ---> [ Tokyo, Austin Texas, San Francisco, Seattle ]
    //Tokyo ---> [ Singapore, Hong Kong, Detroit, Washington DC ]
    //Austin Texas ---> [ Detroit, Washington DC, San Francisco ]
    //San Francisco ---> [ Hong Kong, Washington DC, Seattle, Austin Texas ]
    //Seattle ---> [ Washington DC, San Francisco ]

    //Output for AdjacencyMatrix<String>()
    //0: Singapore
    //1: Tokyo
    //2: Hong Kong
    //3: Detroit
    //4: San Francisco
    //5: Washington DC
    //6: Austin Texas
    //7: Seattle
    //
    //ø		500.0	300.0	ø		ø		ø		ø		ø
    //500.0	ø		250.0	450.0	ø		300.0	ø		ø
    //300.0	250.0	ø		ø		600.0	ø		ø		ø
    //ø		450.0	ø		ø		ø		ø		50.0	ø
    //ø		ø		600.0	ø		ø		337.0	297.0	218.0
    //ø		300.0	ø		ø		337.0	ø		292.0	277.0
    //ø		ø		ø		50.0	297.0	292.0	ø		ø
    //ø		ø		ø		ø		218.0	277.0	ø		ø
    //
    //Process finished with exit code 0
}