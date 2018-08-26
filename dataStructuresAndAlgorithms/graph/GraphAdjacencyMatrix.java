import java.io.*;
import java.util.*;

class GraphAdjacencyMatrix {
	int V;
	int graph[][];
	GraphAdjacencyMatrix() {
		this.V=9;
		this.graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };

	}


	void Dijkstra(int src) {
		int dist[]=new int[this.V];
		boolean visited[]=new boolean[this.V];
		int i,count,u,v;
		for(i=0;i<this.V;i++) {
			dist[i]=Integer.MAX_VALUE;
			visited[i]=false;
		}
		dist[src]=0;
		for(count=0;count<this.V-1;count++) {
			u=minOfRemainingVerticesNotVisited(dist,visited);
			visited[u]=true;
			for(v=0;v<this.V;v++) 
				if(dist[v]>dist[u]+this.graph[u][v] && dist[u]!=Integer.MAX_VALUE && visited[v]==false && graph[u][v]!=0)
					dist[v]=dist[u]+this.graph[u][v];
		}

		printMinDistances(dist);
	}

	void printMinDistances(int dist[]) {
		int i;
		for(i=0;i<this.V;i++) System.out.println(i + "       " + dist[i]);
	}

	int minOfRemainingVerticesNotVisited(int dist[],boolean visited[]) {
		int minIndex=-1,i,minDist=Integer.MAX_VALUE;
		for(i=0;i<this.V;i++)
			if(dist[i]<minDist && visited[i]==false) {
				minDist=dist[i];
				minIndex=i;
			}
		return minIndex;
	}

	public static void main(String args[]) {
		GraphAdjacencyMatrix G=new GraphAdjacencyMatrix();
		G.Dijkstra(0);
	}
}