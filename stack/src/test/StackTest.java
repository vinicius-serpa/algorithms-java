package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.EmptyStackException;
import core.FullStackException;
import core.Stack;

public class StackTest {

	Stack s;
	
	@Before
	public void initStack() {
		s = new Stack(10);
	}
	
	@Test
	public void testEmptyStack() {		
		assertTrue(s.empty());
		assertEquals(0, s.size());
	}
	
	@Test
	public void testPush() {		
		s.push("element");
		assertFalse(s.empty());
		assertEquals(1, s.size());
		assertEquals("element", s.peek());
	}
	
	@Test
	public void testPushAndPop() {		
		s.push("element1");
		s.push("element2");
		assertFalse(s.empty());
		assertEquals(2, s.size());
		assertEquals("element2", s.peek());
		Object element = s.pop();
		assertEquals(1, s.size());
		assertEquals("element1", s.peek());
		assertEquals("element2", element);
	}
	
	@Test(expected = EmptyStackException.class)
	public void popFromEmptyStack() {
		s.pop();
	}
	
	@Test
	public void pushFromFullStack() {
		
		for (int i = 0; i < 10; i++)
			s.push("element" + 1);
		
		try {
			s.push("boom");
			fail();
		} catch (FullStackException e) {
			
		}
	}

}
