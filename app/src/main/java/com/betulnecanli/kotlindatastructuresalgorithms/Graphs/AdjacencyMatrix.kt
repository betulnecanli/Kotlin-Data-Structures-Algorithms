package com.betulnecanli.kotlindatastructuresalgorithms.Graphs

class AdjacencyMatrix<T> : Graph<T> {
    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()


    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex) //Add a new vertex to the array.
        weights.forEach {
            it.add(null) //Append a null weight to every row in the matrix, as none of the current vertices
            //have an edge to the new vertex.
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(null)
        }
        weights.add(row) //Add a new row to the matrix. This row holds the outgoing edges for the new
        //vertex. You put a null value in this row for each vertex that your graph stores.
        return vertex
        }


    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        weights[source.index][destination.index] = weight
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

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        //You first create a list of the vertices.
        val verticesDescription = vertices.joinToString("\n") { "${it.index}: ${it.data}" }
            //Then, you build up a grid of weights, row by row
            val grid = arrayListOf<String>()
            weights.forEach {
                var row = ""
                (0 until weights.size).forEach { columnIndex ->
                    if (columnIndex >= it.size) {
                        row += "ø\t\t"
                    } else {
                        row += it[columnIndex]?.let { "$it\t" } ?: "ø\t\t"
                    }
                }
                grid.add(row)
            }

            val edgesDescription = grid.joinToString("\n")
            //Finally, you join both descriptions together and return them
            return "$verticesDescription\n\n$edgesDescription"
        }

}