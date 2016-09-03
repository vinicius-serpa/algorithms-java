package core;

public class Queue {

	private int size;
	private int[] queueArr;
	private int front;
	private int rear;
	
	public Queue() {
		this(20);
	}
	
	public Queue(int size) {
		this.size = size;
		queueArr = new int[size];
		front = 0;
		rear = -1;
	}
	
	// insert on final
	public void insert(int v) {
				
		if (rear == this.size - 1)
			rear = -1;
		
		queueArr[++rear] = v;			
	}
	
	// remove from front
	public int remove() {
				
		int temp = queueArr[front++];
		
		if (front == this.size) 
			front = 0;
		
		return temp;			
	}
	
	public boolean isEmpty() {
		return (rear + 1 == front || (front + size - 1 == rear));
	}
	
}
