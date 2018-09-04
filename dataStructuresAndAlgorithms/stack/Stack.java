

class Stack {
	static final int MAX=10;
	int stack[]=new int[MAX];
	int top=-1;

	boolean isFull() { return top==MAX-1; }
	
	boolean isEmpty() { return top==-1; }

	int peek() { 
		if(!isEmpty())
			return stack[top];
		return -1;
	}
	
	void push(int el) {
		if(!isFull()) {
			top=top+1;
			stack[top]=el;
		}
	}

	void pop() {
		if(!isEmpty()) 
			top=top-1;
	}

	public static void main(String args[]) {
		Stack s=new Stack();
		s.push(1);
		s.push(2);
		System.out.println("Top element " + s.peek());
		s.pop();
		System.out.println("Top element after pop operation " + s.peek());
		s.pop();
		System.out.println("Top element after pop operation " + s.peek());
	}
}