package graph;

import java.util.LinkedList;

class Node {
	int id;
	LinkedList<Integer> adj;

	Node(int nodeId) {
		id = nodeId;
		adj = new LinkedList<Integer>();
	}
}

class Graph {
	Node[] nodeList;
	private int nodeCnt;
	
	Graph(int n) {
		nodeCnt = n;
		nodeList = new Node[n];
		for (int i = 0; i < n ; i++) {
			nodeList[i] = new Node(i);
		}
	}
	
	// Add edge from node x to y
	void add_edge(int x, int y) {
		nodeList[x].adj.add(y);
	}
	
	// Run DFS from starting node
	void run_dfs(Node s) {
		
		// Mark all the vertices as not visited - default = false
		boolean visited[] = new boolean[nodeCnt];	
		LinkedList<Node> q = new LinkedList<Node>();
		
		// Start from the given node
		q.add(s);
					
		while (q.isEmpty() != true) {
			
			// Dequeue a vertex from queue and print it 
			Node curNode = q.poll();
			visited[curNode.id] = true;
			System.out.print(curNode.id + " ");
			
			for (Integer i : curNode.adj) {
				
				if (!visited[i]) 
				{
					visited[i] = true;
					q.push(nodeList[i]);
				}
			}
		}			
	}
	
	// Run BFS from starting node
	void run_bfs(Node s) {
		
		// Mark all the vertices as not visited - default = false
		boolean visited[] = new boolean[nodeCnt];	
		LinkedList<Node> q = new LinkedList<Node>();
		
		// Start from the given node
		q.add(s);
		
		while (q.isEmpty() != true) {
		
			// Dequeue a vertex from queue and print it 
			Node curNode = q.poll();
			visited[curNode.id] = true;
			System.out.print(curNode.id + " ");
			
			// Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it
			for (Integer i : curNode.adj) {
				
				if (!visited[i]) 
				{
					visited[i] = true;
					q.add(nodeList[i]);
				}
			}
		}	
	}
}

public class traverse {

	public static void main(String args[]) {
		
		Graph g = new Graph(4);
		g.add_edge(0, 1); 
        g.add_edge(0, 2); 
        g.add_edge(1, 2); 
        g.add_edge(2, 0); 
        g.add_edge(2, 3); 
        g.add_edge(3, 3);
        
        System.out.println("--- BFS ---");
        g.run_bfs(g.nodeList[2]);
        
        System.out.println("\n--- DFS ---");
        g.run_dfs(g.nodeList[2]);

	}
}
