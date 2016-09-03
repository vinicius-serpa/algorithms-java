package core;

public class Stack {

	private int[] st;
	private int top;
	
	public Stack() {
		this(20);
	}
	
	public Stack(int size) {
		st = new int[size];
		top = -1;
	}
	
	// include in stack
	public void push(int e) {
		st[++top] = e;
	}
	
	// remove from stack
	public int pop() {
		return st[top--];		
	}
	
	// see the top
	public int peek() {
		return st[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
}
