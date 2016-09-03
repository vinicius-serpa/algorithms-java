package core;

public class Vertex {
	
	private int label;
	private boolean visited;
	
	public Vertex(int label) {
		this.label = label;
		this.visited = false;
	}
	
	public int getLabel() {
		return label;
	}	
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setVisited() {
		this.visited = true;
	}
	
	public void setUnvisited() {
		this.visited = false;
	}
}
