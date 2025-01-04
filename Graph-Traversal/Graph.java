import java.util.*;

public class Graph {

	private List<Integer>[] adj;
	private boolean[] visited;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		adj = new ArrayList[V + 1];
		for(int i = 0; i < adj.length; i ++) {
			adj[i] = new ArrayList<>();
		}
	}

	// Undirected Graph
	private void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	private void initializeVisited() {
		visited = new boolean[adj.length];
		for(int i = 0; i < visited.length; i ++) {
			visited[i] = false;
		}
	}

	// BFS
	private void BFS() {
		initializeVisited();

		Queue<Integer> queue = new LinkedList<>();
		
		visited[1] = true;
		queue.add(1);

		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");

			for(int v : adj[u]) {
				if(!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}

	// DFS
	private void DFS() {
		initializeVisited();
		DFSVisit(1);	
	}

	private void DFSVisit(int u) {
		visited[u] = true;
		System.out.print(u + " ");

		for(int v : adj[u]) {
			if(!visited[v]) {
				DFSVisit(v);
			}
		}
	}

	// Driver
	public static void main(String[] args) {
		Graph graph = new Graph(8);

		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 7);
		graph.addEdge(2, 8);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(5, 8);
		graph.addEdge(7, 8);

		System.out.print("BFS: ");

		graph.BFS();

		System.out.print("\nDFS: ");

		graph.DFS();

		System.out.println();
	}
}