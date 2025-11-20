package graphs;

import java.util.List;

public interface Graph {

    //num  de vertex
    int V();

    //num de arestas
    int E();

    void addEdge(int v, int w, double weight);

    List<Edge> edges();

    Iterable<Edge> adj(int v);

    void BFS(int s);

    void DFS();

    //(cor, predecessor, d, f)
    String StatusAtribs();

    String toString();
}

