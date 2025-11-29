package graphs;
import java.util.ArrayList;
import java.util.List;

public class DigraphList implements Graph, Digraph {
    private final int V;
    private final List<List<Edge>> adj;

    public DigraphList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        adj.get(v).add(new Edge(v, w, weight));
    }

    @Override
    public int V() { return V; }

    @Override
    public int E() { return edges().size(); }

    @Override
    public List<Edge> adj(int v) { return adj.get(v); }

    @Override
    public List<Edge> edges() {
        List<Edge> all = new ArrayList<>();
        for (List<Edge> list : adj) all.addAll(list);
        return all;
    }

    @Override
    public void BFS(int s) {
        throw new UnsupportedOperationException("Método BFS não implementado para Digraph.");
    }

    @Override
    public void DFS() {
        throw new UnsupportedOperationException("Método DFS não implementado para Digraph.");
    }

    @Override
    public String StatusAtribs() {
        return "Sem atributos de vértices neste digrafo.";
    }
    
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int v = 0; v < V; v++) {
			sb.append(v).append(": ");
			for (Edge edge : adj.get(v)) {
				sb.append(edge).append(" ");
        }
        sb.append("\n");
    }
	return sb.toString();
	}
}
