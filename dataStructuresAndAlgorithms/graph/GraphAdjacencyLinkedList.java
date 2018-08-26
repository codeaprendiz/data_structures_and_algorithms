import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


class GraphAdjacencyLinkedList {
	int V;
	LinkedList<Integer> adjacencyLinkedList[];

	GraphAdjacencyLinkedList(int vertices) {
		this.V=vertices;
		int i;
		adjacencyLinkedList=new LinkedList[this.V];
		for(i=0;i<V;i++) {
			adjacencyLinkedList[i]=new LinkedList<Integer>();
		}
	}

/*********************************************************
Adding Edge for a directed graph
**********************************************************/
	void addEdge(int src,int destination) {
		this.adjacencyLinkedList[src].add(destination);
	}

	void printGraph() {
		int i,j;
		System.out.println("The Graph has " + this.V + " vertices");
		for(i=0;i<this.V;i++) {
			System.out.println("\nDirect Neighbours of Vertex " + i +"  ");
			for(Integer neighbourVert : this.adjacencyLinkedList[i])
				System.out.print("--> "+ neighbourVert);
		}
	}

/*********************************************************
Bread First Search or BFS Traversal
**********************************************************/	

	void BFS(int src) {
		System.out.println("BFS traversal starting from source vertex " + src);
		Queue<Integer> q=new LinkedList<Integer>();
		boolean visited[]=new boolean[this.V];
		visited[src]=true;
		q.add(src);
		int curVertex=-1;
		while(!q.isEmpty()) {
			curVertex=q.peek();
			System.out.println(curVertex);
			q.remove();
			Iterator<Integer> listIterator=this.adjacencyLinkedList[curVertex].listIterator();
			while(listIterator.hasNext()) {
				int nexVertex=listIterator.next();
				if(visited[nexVertex]==false){
					visited[nexVertex]=true;
					q.add(nexVertex);
				}
			}
		}
	}

/*********************************************************
Deapth First Search or DFS Traversal
**********************************************************/	

	void DFS() {
		boolean visited[]=new boolean[this.V];
		int i=0;
		for(i=0;i<this.V;i++) {
			if(visited[i]==false)
				DFSUtil(i,visited);
		}
	}

	void DFSUtil(int vertex,boolean visited[]) {
		Iterator<Integer> listIterator=this.adjacencyLinkedList[vertex].listIterator();
		System.out.println(vertex);
		visited[vertex]=true;
		while(listIterator.hasNext()) {
			int nexVertex=listIterator.next();
			if(visited[nexVertex]==false) {
				DFSUtil(nexVertex,visited);
			}
		}
	}

	public static void main(String args[]) {
		GraphAdjacencyLinkedList G=new GraphAdjacencyLinkedList(4);
		G.addEdge(0,1);G.addEdge(0,2);G.addEdge(1,2);G.addEdge(2,0);G.addEdge(2,3);G.addEdge(3,3);
		G.printGraph();
		System.out.println("Printing the Breadth First Traversal of the graph : ");
		G.BFS(2);
		System.out.println("Printing the Deapth First Traversal of the graph : ");
		G.DFS();
	}
}