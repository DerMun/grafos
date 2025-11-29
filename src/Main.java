import utils.*;
import graphs.*;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main() {
		int op,sample_choice,alg=0,graph_choice=0,rep;
		String sample= null;
		List<String> csvList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		
		GraphList graphList = null;
		GraphMatrix graphMatrix = null;
		DigraphList digraphList = null;
		DigraphMatrix digraphMatrix = null;

		do {
			System.out.println("\n 1) Utilizar grafos de teste");
			System.out.println(" 2) Utilizar grafos do GTgraph");
			System.out.println(" 0) Sair da aplicacao");
			System.out.print(" Escolha uma das opcoes: ");
			op = input.nextInt();

			switch(op) {
				case 1:
					System.out.println("\n 1) Grafo com Lista de Adjacência");
					System.out.println(" 2) Grafo com Matriz de Adjacência");
					System.out.println(" 3) Dígrafo com Lista de Adjacência");
					System.out.println(" 4) Dígrafo com Matriz de Adjacência");
					System.out.println(" 0) Sair da aplicação");
					System.out.print(" Escolha uma das opções: ");
					graph_choice = input.nextInt();
					
					switch(graph_choice) {
						case 1:
							graphList = new GraphList(5);
							graphList.addEdge(0, 1, 4);
							graphList.addEdge(0, 2, 1);
							graphList.addEdge(1, 3, 1);
							graphList.addEdge(2, 3, 5);
							graphList.addEdge(3, 4, 3);
							break;
						case 2:
							graphMatrix = new GraphMatrix(5);
							graphMatrix.addEdge(0, 1, 4);
							graphMatrix.addEdge(0, 2, 1);
							graphMatrix.addEdge(1, 3, 1);
							graphMatrix.addEdge(2, 3, 5);
							graphMatrix.addEdge(3, 4, 3);
							break;
						case 3:
							digraphList = new DigraphList(5);
							graphList.addEdge(0, 1, 4);
							graphList.addEdge(0, 2, 1);
							graphList.addEdge(1, 3, 1);
							graphList.addEdge(2, 3, 5);
							graphList.addEdge(3, 4, 3);
							break;
						case 4:
							digraphMatrix = new DigraphMatrix(5);
							digraphMatrix.addEdge(0, 1, 4);
							digraphMatrix.addEdge(0, 2, 1);
							digraphMatrix.addEdge(1, 3, 1);
							digraphMatrix.addEdge(2, 3, 5);
							digraphMatrix.addEdge(3, 4, 3);
							break;
					}
					break;
				case 2:
					System.out.println("\n 1) Sample 100-1980");
					System.out.println(" 2) Sample 100-3960");
					System.out.println(" 3) Sample 100-5940");
					System.out.println(" 4) Sample 100-7920");
					System.out.println(" 5) Sample 100-9900");
					System.out.println(" 6) Sample 100-7960");
					System.out.println(" 7) Sample 100-15920");
					System.out.println(" 8) Sample 100-23880");
					System.out.println(" 9) Sample 100-31840");
					System.out.println(" 10) Sample 100-39800");
					System.out.println(" 11) Sample 100-49900");
					System.out.println(" 12) Sample 100-99800");
					System.out.println(" 13) Sample 100-149700");
					System.out.println(" 14) Sample 100-199600");
					System.out.println(" 15) Sample 100-249500");
					System.out.print(" Escolha o a configuração do dígrafo: ");
					sample_choice = input.nextInt();
				
					sample = Choose.chooseSample(sample_choice);
									
					System.out.println(" 1) Dígrafo com Lista de Adjacência");
					System.out.println(" 2) Dígrafo com Matriz de Adjacência");
					System.out.println(" 0) Sair");
					System.out.print(" Escolha uma das opcões: ");
					graph_choice = input.nextInt();
					
					switch(graph_choice) {
						case 1:
							digraphList = ReadGraph.readGraphFromFile(sample);
							break;
						case 2:
							digraphList = ReadGraph.readGraphFromFile(sample);
							digraphMatrix = new DigraphMatrix(digraphList.V());
							Copy.copyGraph(digraphList, digraphMatrix);
							break;
					}
					break;
				case 0:
					System.exit(0);
			}

			do {
				System.out.println("\n MENU");
				System.out.println(" 1. Busca em Largura (BFS)");
				System.out.println(" 2. Busca em Profundidade (DFS)");
				System.out.println(" 3. Ordenação Topológica");
				System.out.println(" 4. Árvore Geradora Mínima (Kruskal)");
				System.out.println(" 5. Árvore Geradora Minima (Prim)");
				System.out.println(" 6. Caminho Mínimo de Origem Única para Todos os Vértices (Bellman-Ford)");
				System.out.println(" 7. Caminho Mínimo de Origem Única para Todos os Vértices (Dijkstra)");
				System.out.println(" 8. Caminho Mínimo entre Todos os Pares (Floyd-Warshall)");
				System.out.println(" 9. Fluxo Máximo em Redes (Ford-Fulkerson)");
				System.out.println(" 0. Sair");
				System.out.print(" Escolha uma opção: ");

				alg = input.nextInt();

				if(alg > 0 && alg <= 9) {
					System.out.print(" Escolha o número de repetições: ");
					rep = input.nextInt();
					
					switch(op) {
						case 1:
							switch(graph_choice) {
								case 1:
									Choose.chooseAlg(alg, "List", "GraphTest", graphList, rep, csvList);
									break;
								case 2:
									Choose.chooseAlg(alg, "Matrix", "GraphTest", graphMatrix, rep, csvList);
									break;
								case 3:
									Choose.chooseAlg(alg, "List", "DigraphTest", digraphList, rep, csvList);
									break;
								case 4:
									Choose.chooseAlg(alg, "Matrix", "DigraphTest", digraphMatrix, rep, csvList);
									break;
							}
							break;
						case 2:
							switch(graph_choice) {
								case 1:
									Choose.chooseAlg(alg, "List", sample, digraphList, rep, csvList);
									break;
								case 2:
									Choose.chooseAlg(alg, "Matrix", sample, digraphMatrix, rep, csvList);
									break;
							}
							break;
					}
					
					CreateCSV.generateCsv(csvList);
				}
			} while(alg != 0);
		} while(op != 0);	
	}
}
