import java.util.*;
import java.io.*;

class Edge {
	int src,dest,weight;
	Edge() {
		this.src=this.dest=this.weight=0;
	}
}
class GraphBellmanFord {
	int V;
	int E;
	Edge edge[];
	GraphBellmanFord(int V,int E) {
		this.V=V;
		this.E=E;
		int i=0;
		edge=new Edge[this.E];
		for(i=0;i<E;i++) {
			edge[i]=new Edge();
		}
	}

	void BellmanFord(int src) {
		int dist[]=new int[this.V];
		int i,j,u,v,weight;
		for(i=0;i<this.V;i++) 
			dist[i]=Integer.MAX_VALUE;
		dist[src]=0;
		for(i=1;i<this.V;i++) {
			for(j=0;j<this.E;j++) {
				u=this.edge[j].src;
				v=this.edge[j].dest;
				weight=this.edge[j].weight;
				if(dist[v]>dist[u]+weight && dist[u]!=Integer.MAX_VALUE)
					dist[v]=dist[u]+weight;
			}
		}


		for(j=0;j<this.E;j++) {
			u=this.edge[j].src;
			v=this.edge[j].dest;
			weight=this.edge[j].weight;
			if(dist[v]>dist[u]+weight && dist[v]!=Integer.MAX_VALUE)
				System.out.println("The graph has negative cycle");
		}

		printMinDistances(dist);
	}

	void printMinDistances(int dist[]) {
		int i;
		for(i=0;i<this.V;i++) System.out.println(i + "       " + dist[i]);
	}


	public static void main(String args[]) {
		GraphBellmanFord graph=new GraphBellmanFord(5,8);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
 
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
 
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        graph.BellmanFord(0);
	}
}