package run;

import core.MyGraph;

public class ShortestReach {

	public static void main(String[] args) {
		
		int n = 4;
		int m = 2;
		int s = 1 - 1;
		
		MyGraph g = new MyGraph(n);
		
		for (int i = 0; i < n; i++) {
			g.addVertex(i + 1);
		}
		
		g.addEdge(1 - 1, 2 - 1);
		g.addEdge(1 - 1, 3 - 1);
		
		g.bfsModified(s, n);

	}

}
