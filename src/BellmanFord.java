import java.util.*;
import graphs.*;

public class BellmanFord {
    private int V; // número de vértices
    private double[] dist;
    private List<Edge> arestas;

    public BellmanFord(Digraph graph) {
        this.V = graph.getV();;
        this.arestas = new ArrayList<>();
        
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.adj(u)) {
                arestas.add(edge);
            }
        }
        
        this.dist = new double[V];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
    }

    public void computeShortestPaths(int fonte) {
        dist[fonte] = 0;

        // Relaxamento (V - 1) vezes
        for (int i = 1; i < V; i++) {
            for (Edge e : arestas) {
                if (dist[e.v] + e.weight < dist[e.w]) {
                    dist[e.w] = dist[e.v] + e.weight;
                }
            }
        }

        // Detecção de ciclo negativo
        for (Edge e : arestas) {
            if (dist[e.v] + e.weight < dist[e.w]) {
                System.out.println("Grafo contém ciclo de peso negativo!");
                return;
            }
        }

	}
        // Exibe distâncias
    public void printDistances(int fonte) {
        System.out.println("Distâncias a partir do vértice " + fonte + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Para " + i + " -> " + dist[i]);
        }
	}
}
