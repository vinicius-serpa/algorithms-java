package run;

import core.MyGraph;

public class Bfs {

	public static void main(String[] args) {
		
		MyGraph g = new MyGraph(20);
		
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		
		System.out.print("Visits: ");
		g.bfs();
		System.out.println("");

	}

}
