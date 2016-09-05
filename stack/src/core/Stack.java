package core;

public class Stack {

	private Object[] elements;
	private int qtElements = 0;
	
	public Stack(int max) {
		elements = new Object[max];
	}

	public boolean empty() {
		return qtElements == 0;
	}

	public Object size() {
		return qtElements;
	}

	public void push(Object element) {
		
		if (qtElements == elements.length)
			throw new FullStackException("stack is full!");
		
		this.elements[qtElements] = element;
		qtElements++;
	}

	public Object peek() {
		return elements[qtElements - 1];
	}

	public Object pop() {
		
		if (empty())
			throw new EmptyStackException("stack is empty!");
		
		Object top = elements[qtElements - 1];
		qtElements--;
		return top;
	}

}
