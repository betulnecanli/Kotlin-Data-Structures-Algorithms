package com.betulnecanli.kotlindatastructuresalgorithms.Graphs

class AdjacencyList<T> : Graph<T> {
    private val adjacencies: HashMap<Vertex<T>,
            ArrayList<Edge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination,
                weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source,
                destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> = adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.destination ==
                destination }?.weight
    }

    override fun toString(): String {
        return buildString { //You'll be assembling the result using buildString(), which places you inside the
            //scope of a StringBuilder, and returns whatever you've built.
            adjacencies.forEach { (vertex, edges) -> //You loop through every key-value pair in adjacencies
                val edgeString = edges.joinToString{ it.destination.data.toString() } //For every vertex, you create a string representation of all its outgoing edges.
               // joinToString() gives you a neat, comma-separated list of the items.
                append("${vertex.data} ---> [ $edgeString ]\n") //Finally, for every vertex, you append both the vertex itself and its outgoing edges
                //to the StringBuilder that buildString() provides you with.
            }
        }
    }
}