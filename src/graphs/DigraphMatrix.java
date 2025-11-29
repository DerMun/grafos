package graphs;
import java.util.ArrayList;
import java.util.List;

public class DigraphMatrix implements Graph, Digraph {

    private final int V;
    private final double[][] adj;

    public DigraphMatrix(int V) {
        this.V = V;
        adj = new double[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                adj[i][j] = Double.POSITIVE_INFINITY;
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        adj[v][w] = weight;
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        int e = 0;
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (adj[i][j] != Double.POSITIVE_INFINITY)
                    e++;
        return e;
    }

    @Override
    public List<Edge> adj(int v) {
        List<Edge> edges = new ArrayList<>();
        for (int w = 0; w < V; w++) {
            if (adj[v][w] != Double.POSITIVE_INFINITY) {
                edges.add(new Edge(v, w, adj[v][w]));
            }
        }
        return edges;
    }

    @Override
    public List<Edge> edges() {
        List<Edge> edgeList = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < V; w++) {
                if (adj[v][w] != Double.POSITIVE_INFINITY) {
                    edgeList.add(new Edge(v, w, adj[v][w]));
                }
            }
        }
        return edgeList;
    }

    @Override
    public void BFS(int s) {
        throw new UnsupportedOperationException("BFS não implementado para digrafos.");
    }

    @Override
    public void DFS() {
        throw new UnsupportedOperationException("DFS não implementado para digrafos.");
    }

    @Override
    public String StatusAtribs() {
        return "Esse digrafo não possui atributos de vértices (como cor, pred, d, f).";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (int w = 0; w < V; w++) {
                if (adj[v][w] != Double.POSITIVE_INFINITY) {
                    sb.append(String.format("(%d, peso: %.2f) ", w, adj[v][w]));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
