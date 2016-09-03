package core;

public class MyGraph {
	
	private int maxVerts;
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private int nVerts;
	private Stack stack;
	private Queue queue;
	
	// initialize the graph with 20 vertexes
	public MyGraph() {
		this(20);			
	}
	
	// initialize the graph with variable length
	public MyGraph(int length) {
		
		this.maxVerts = length;
		
		vertexList = new Vertex[this.maxVerts];
		adjMatrix = new int[this.maxVerts][this.maxVerts];
		nVerts = 0;
		stack = new Stack(this.maxVerts);
		queue = new Queue(this.maxVerts);
		
		for (int i = 0; i < this.maxVerts; i++)
			for (int j = 0; j < this.maxVerts; j++)
				adjMatrix[i][j] = 0;
	}
	
	// add a vertex in the graph
	public void addVertex(int lab) {
		if (this.nVerts < this.maxVerts) {
			vertexList[nVerts++] = new Vertex(lab);
		}
	}
	
	// set the edges of two vertex
	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}
	
	// Gets a vertex of Graph by vertexList position
	public int getVertexLabel(int v) {
		if (v < this.nVerts && v >= 0)
			return vertexList[v].getLabel();
		else
			return ' ';
	}
	
	// Print one vertex
	public void displayVertex(int v) {
		if (v < this.nVerts && v >= 0)
			System.out.print(vertexList[v].getLabel());
	}
	
	// Print all Vertex
	public void displayVertex() {
		for (int i = 0; i < this.maxVerts; i++)
			System.out.print(vertexList[i].getLabel());
	}
	
	// Get graph length
	public int length() {
		return this.nVerts;
	}
	
	// Get graph max length
	public int maxLength() {
		return this.maxVerts;
	}
	
	// return the first unvisited vertex of a vertex
	public int getNextAdjUnvisitedVertex(int v) {
		for (int i = 0; i < this.nVerts; i++)
			if (this.adjMatrix[v][i] == 1 && (!this.vertexList[i].isVisited())) 
				return i;
		
		return -1;
	}
	
	// Depth-First Search
	public void dfs() {
		
		// begin with vertex 0: mark, show, push
		this.markAndShow(0);
		stack.push(0);
		
		while (!stack.isEmpty()) {
			int v = this.getNextAdjUnvisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop();
			} else {
				this.markAndShow(v);
				stack.push(v);
			}
		}
		
		// stack empty, restart graph
		restartGraph();
		
	}
	
	// Breadth-First Search
	public void bfs() {
		
		this.markAndShow(0);
		queue.insert(0);
		
		int v2;
		
		while (!queue.isEmpty()) {
			int v1 = queue.remove();
			
			while ((v2 = this.getNextAdjUnvisitedVertex(v1)) != -1) {
				this.markAndShow(v2);
				queue.insert(v2);
			}
		}
		
		// stack empty, restart graph
		restartGraph();
	}
	
	public void bfsModified(int s, int length) {
		
		int[] vl = new int[length];
		int distance = 0;
		
		for (int i = 0; i < length; i++) {
			vl[i] = -1;
		}
		
		vertexList[s].setVisited();
		queue.insert(s);
		
		int v2;
		
		while (!queue.isEmpty()) {
			
			int v1 = queue.remove();
			distance += 6;
			
			while ((v2 = this.getNextAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].setVisited();
				vl[v2] = distance;
				queue.insert(v2);
			}
		}
		
		// stack empty, restart graph
		restartGraph();
		
		// print distances, except s
		for (int i = 0; i < length; i++)
			if (i != s)
				System.out.print(vl[i] + " ");
	}
	
	// mark, show and push a vertex
	private void markAndShow(int v) {
		vertexList[v].setVisited();
		this.displayVertex(v);		
	}
	
	// Set all elements with unvisited flag
	private void restartGraph() {
		for (int i = 0; i < this.nVerts; i++)
			this.vertexList[i].setUnvisited();
	}
}
