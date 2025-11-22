import java.io.File;
import java.util.Scanner;
import graphs.*;

public class Main {
    public static void main(String[] args) {

        int numVertices = 5;

        Graph graphList = new GraphList(numVertices);
        Graph graphMatriz = new GraphMatriz(numVertices);
        addEdgesLG(graphList);
        addEdgesMG(graphMatriz);

        Digraph digraphList = new DigraphList(numVertices);
        Digraph digraphMatrix = new DigraphMatrix(numVertices);
        addEdgesLD(digraphList);
        addEdgesMD(digraphMatrix);

        // Menu de opções
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Busca em Largura (BFS)");
            System.out.println("2. Busca em Profundidade (DFS)");
            System.out.println("3. Ordenação Topológica");
            System.out.println("4. Árvore Geradora Mínima (Kruskal)");
            System.out.println("5. Árvore Geradora Mínima (Prim)");
            System.out.println("6. Caminho Mínimo entre Todos os Pares (Floyd-Warshall)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            if (option == 0) break;

            long startTime, endTime;
            int exe = 1;
            switch (option) {

                case 1: // Busca em Largura (BFS)
                System.out.println("\nGrafo com Lista de Adjacências:");
                System.out.println(graphList);//toString
                System.out.println("Grafo com Matriz de Adjacências:");
                System.out.println(graphMatriz);//toString

                System.out.println("Algoritmo: Busca em Largura (BFS)");
                int source = 0;

                System.out.println("\nGrafo com Lista de Adjacências exe");
                for(int i = 0; i < exe; i++){
                    startTime = System.nanoTime();
                    graphList.BFS(source);
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                }
                System.out.println(graphList.StatusAtribs());

                System.out.println("\nGrafo com Matriz de Adjacências exe");
                for(int i = 0; i < exe; i++) {
                    startTime = System.nanoTime();
                    graphMatriz.BFS(source);
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                }
                System.out.println(graphMatriz.StatusAtribs());
                break;


                case 2: // Busca em Profundidade (DFS)
                System.out.println("\nGrafo com Lista de Adjacências:");
                System.out.println(graphList);//toString
                System.out.println("Grafo com Matriz de Adjacências:");
                System.out.println(graphMatriz);//toString

                System.out.println("Algoritmo: Busca em Profundidade (DFS)");

                System.out.println("\nGrafo com Lista de Adjacências exe");
                for(int i = 0; i < exe; i++) {
                    startTime = System.nanoTime();
                    graphList.DFS();
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                }
                System.out.println(graphList.StatusAtribs());

                System.out.println("\nGrafo com Matriz de Adjacências exe");
                for(int i = 0; i < exe; i++) {
                    startTime = System.nanoTime();
                    graphMatriz.DFS();
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                }
                System.out.println(graphMatriz.StatusAtribs());
                break;


                case 3:
                System.out.println("...");
                break;


                case 4: // Árvore Geradora Mínima (Kruskal)
                System.out.println("\nGrafo com Lista de Adjacências:");
                System.out.println(graphList);//toString
                System.out.println("Grafo com Matriz de Adjacências:");
                System.out.println(graphMatriz);//toString

                System.out.println("Algoritmo: Árvore Geradora Mínima (Kruskal)");

                System.out.println("\nGrafo com Lista de Adjacências exe");
                for(int i = 0; i < exe; i++) {
                    startTime = System.nanoTime();
                    System.out.println("Peso da MST: " + Kruskal.findMST(graphList));
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                }

                System.out.println("\nGrafo com Matriz de Adjacências exe");
                for(int i = 0; i < exe; i++) {
                    startTime = System.nanoTime();
                    System.out.println("Peso da MST: " + Kruskal.findMST(graphMatriz));
                    endTime = System.nanoTime();
                    System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                }
                break;


                case 5: // Árvore Geradora Mínima (Prim)
                    System.out.println("\nGrafo com Lista de Adjacências:");
                    System.out.println(graphList);//toString
                    System.out.println("Grafo com Matriz de Adjacências:");
                    System.out.println(graphMatriz);//toString

                    System.out.println("Algoritmo: Árvore Geradora Mínima (Prim)");

                    System.out.println("\nGrafo com Lista de Adjacências exe");
                    for(int i = 0; i < exe; i++) {
                        startTime = System.nanoTime();
                        System.out.println("Peso da MST: " + Prim.findMST(graphList));
                        endTime = System.nanoTime();
                        System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                    }

                    System.out.println("\nGrafo com Matriz de Adjacências exe");
                    for(int i = 0; i < exe; i++) {
                        startTime = System.nanoTime();
                        System.out.println("Peso da MST: " + Prim.findMST(graphMatriz));
                        endTime = System.nanoTime();
                        System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                    }
                    break;

                case 6: // Caminho Mínimo entre Todos os Pares (Floyd-Warshall)
                    System.out.println("\nDigrafo com Lista de Adjacências:");
                    System.out.println(digraphList);//toString
                    System.out.println("Digrafo com Matriz de Adjacências:");
                    System.out.println(digraphMatrix);//toString

                    System.out.println("Algoritmo: Caminho Mínimo (Floyd-Warshall)");

                    System.out.println("\nDigrafo com Lista de Adjacências exe");
                    FloydWarshall fwList = new FloydWarshall(digraphList);
                    for(int i = 0; i < exe; i++) {
                        startTime = System.nanoTime();
                        fwList.computeShortestPaths();
                        endTime = System.nanoTime();
                        System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                    }

                    System.out.println("Distâncias mínimas:");
                    fwList.printDistances();

                    System.out.println("\nDigrafo com Matriz de Adjacências exe");
                    FloydWarshall fwMatrix = new FloydWarshall(digraphMatrix);
                    for(int i = 0; i < exe; i++) {
                        startTime = System.nanoTime();
                        fwMatrix.computeShortestPaths();
                        endTime = System.nanoTime();
                        System.out.println("Tempo de execução: " + (endTime - startTime) + " ns");
                    }

                    System.out.println("Distâncias mínimas:");
                    fwMatrix.printDistances();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }


    //testes
    private static void addEdgesLG(Graph graph) {
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
    }

    private static void addEdgesMG(Graph graph) {
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
    }

    private static void addEdgesLD(Digraph graph) {
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
    }

    private static void addEdgesMD(Digraph graph) {
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
    }

}
