package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.MyGraph;

public class GraphTest {

	MyGraph g;
	
	@Before
	public void before() {
		g = new MyGraph();
	}
	
	@Test
	public void testIncludeOneVertex() {
		g.addVertex('A');
		assertEquals('A', g.getVertexLabel(0));
	}
	
	@Test
	public void testAutomaticMaxLength() {
		assertEquals(20, g.maxLength());
	}
	
	@Test
	public void testMaxLength() {		
		g = new MyGraph(15);		
		assertEquals(15, g.maxLength());
	}
	
	@Test
	public void testLength() {
		g.addVertex('A');
		g.addVertex('A');
		g.addVertex('A');
		g.addVertex('A');
		g.addVertex('A');
		g.addVertex('A');
		g.addVertex('A');
		g.addVertex('A');
		assertEquals(8, g.length());
	}
	
	@Test
	public void testGetNextAdjUnvisitedVertex() {
		
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		
		assertEquals(1, g.getNextAdjUnvisitedVertex(0));
		assertEquals(0, g.getNextAdjUnvisitedVertex(1));
		assertEquals(3, g.getNextAdjUnvisitedVertex(4));
	}

}
