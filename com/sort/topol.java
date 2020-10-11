package sort;

import java.util.*;


public class topol {
	
	static class Graph_t { 

	    private int V; 
	    private ArrayList<ArrayList<Integer> > adj; 
	  
	    Graph_t(int v) 
	    { 
	        V = v; 
	        adj = new ArrayList<ArrayList<Integer> >(v); 
	        for (int i = 0; i < v; ++i) 
	            adj.add(new ArrayList<Integer>()); 
	    } 
	  
	    void add_edge(int v, int w) { 
	    	adj.get(v).add(w); 
	    } 
	  
	    void topological_sort(int v, boolean visited[], Stack<Integer> stack) 
	    { 
	        visited[v] = true; 
	        Integer i; 
	  
	        Iterator<Integer> it = adj.get(v).iterator(); 
	        while (it.hasNext()) { 
	            i = it.next(); 
	            if (!visited[i]) 
	                topological_sort(i, visited, stack); 
	        } 
	  
	        stack.push(new Integer(v)); 
	    } 
	  
	    void driver_sort() 
	    { 
	        Stack<Integer> stack = new Stack<Integer>(); 
	  
	        boolean visited[] = new boolean[V]; 
	        for (int i = 0; i < V; i++) 
	            visited[i] = false; 

	        for (int i = 0; i < V; i++) 
	            if (visited[i] == false) 
	                topological_sort(i, visited, stack); 
	  
	        while (stack.empty() == false) 
	            System.out.print(stack.pop() + " "); 
	    } 
	}
	
    public static void main(String args[]) 
    { 
        Graph_t graph = new Graph_t(6); 
        
        graph.add_edge(5, 2); 
        graph.add_edge(5, 0); 
        graph.add_edge(4, 0); 
        graph.add_edge(4, 1); 
        graph.add_edge(2, 3); 
        graph.add_edge(3, 1); 
  
 
        graph.driver_sort(); 
    } 

}
