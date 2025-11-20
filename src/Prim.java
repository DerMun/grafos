import java.util.PriorityQueue;
import java.util.Vector;
import graphs.*;

public class Prim {
    public static double findMST(Graph graph) {
        int V = graph.V();
        boolean[] inMST = new boolean[V];
        double[] key = new double[V];
        int[] parent = new int[V];

        //inicializar valores
        for (int i = 0; i < V; i++) {
            key[i] = Double.POSITIVE_INFINITY;
            parent[i] = -1;
        }

        //iniciar a MST pelo vértice 0
        key[0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(a.weight, b.weight));
        pq.add(new Edge(-1, 0, 0)); //vértice inicial (0) com peso 0

        double mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.w;

            //ignorar vértices já incluídos na MST
            if (inMST[u]) continue;

            //incluir o vértice na MST
            inMST[u] = true;
            mstWeight += current.weight;

            //atualizar os vértices adjacentes
            for (Edge e : graph.adj(u)) {
                int v = e.w;
                if (!inMST[v] && e.weight < key[v]) {
                    key[v] = e.weight;
                    parent[v] = u;
                    pq.add(new Edge(u, v, e.weight));
                }
            }
        }

        System.out.println("Prim's MST:");
        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i);
            }
        }

        return mstWeight;
    }
}