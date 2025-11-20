package graphs;

import java.util.ArrayList;
import java.util.List;

public class DigraphMatriz implements Digraph{
    private int V;//n de vértices
    private double[][] adjMatriz;//matriz de adjacência

    public DigraphMatriz(int V){
        this.V = V;
        adjMatriz = new double[V][V];

        //inicializa a matriz com infinito (ausência de arestas)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatriz[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public void addEdge(int v, int w, double weight) {
        adjMatriz[v][w] = weight;
    }

    //peso da aresta de v para w (ou infinito se não existir)
    public double getEdgeWeight(int v, int w) {
        return adjMatriz[v][w];
    }

    //todas as arestas do grafo como uma lista
    public List<Edge> edges() {
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMatriz[i][j] != Double.POSITIVE_INFINITY) {
                    edgeList.add(new Edge(i, j, adjMatriz[i][j])); //cria e adiciona a aresta
                }
            }
        }
        return edgeList;
    }


    public List<Edge> adj(int v) {
        List<Edge> edges = new ArrayList<>();
        for (int w = 0; w < V; w++) {
            if (adjMatriz[v][w] != Double.POSITIVE_INFINITY) {
                edges.add(new Edge(v, w, adjMatriz[v][w]));
            }
        }
        return edges;
    }



    public int getV() {
        return V;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < V; j++) {
                if (adjMatriz[i][j] != Double.POSITIVE_INFINITY) {
                    sb.append(String.format("(%d, weight: %.2f) ", j, adjMatriz[i][j]));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}