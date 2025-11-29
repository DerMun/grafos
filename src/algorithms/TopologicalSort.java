package utils;
import graphs.*;
import java.util.*;

public class TopologicalSort {
	List<Integer> result;
    private final Graph graph;
    private final boolean[] visited;
    private final Stack<Integer> stack;

    public TopologicalSort(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.stack = new Stack<>();
    }
    
    public List<Integer> ordenation() {
		return result;
	}

    public void sort() {
        for (int v = 0; v < graph.V(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }

        //converte a pilha para uma lista na ordem correta
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    private void dfs(int v) {
        visited[v] = true;

        for (Edge edge : graph.adj(v)) {
            if (!visited[edge.w]) {
                dfs(edge.w);
            }
        }

        stack.push(v);
    }
}
