import java.util.Stack;

class StackOperations {
	Stack<Integer> stack;


/*******************************************************************************
		Reversing a stack using recursion
********************************************************************************/
	void reverse(Stack<Integer> stack){ 
		if(!stack.isEmpty()) {
			int el=stack.peek();
			stack.pop();
			reverse(stack);

			insertAtBottom(stack,el);
		}
	}

	void insertAtBottom(Stack<Integer> stack, int el) {
		if(stack.isEmpty()) 
			stack.push(el);
		else {
			int elTop=stack.peek();
			stack.pop();
			insertAtBottom(stack,el);
			stack.push(elTop);
		}
	}

/*******************************************************************************
		Sort a stack using Recursion
********************************************************************************/
	void sortUsingRecursion(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int el=stack.peek();
			stack.pop();
			sortUsingRecursion(stack);

			sortedInsert(stack,el);
		}
	}

	void sortedInsert(Stack<Integer> stack, int el) {
		if(stack.isEmpty() || el>stack.peek())
			stack.push(el);
		else {
			int elTop=stack.peek();
			stack.pop();
			sortedInsert(stack,el);
			stack.push(elTop);
		}

	}

/*******************************************************************************
		Sorting using a temporary stack
********************************************************************************/
	void sortUsingTempStack(Stack<Integer> input) { 
		Stack<Integer> output=new Stack<Integer>();
		while(!input.isEmpty()) {
			int inputTop=input.peek();
			input.pop();
			while(!output.isEmpty() && output.peek() < inputTop) 
				input.push(output.pop());
			output.push(inputTop);
		}
		printStack(output);
	}


/*******************************************************************************
		Printing a stack
********************************************************************************/
	void printStack(Stack<Integer> stack) {
		while(!stack.isEmpty()) {
			System.out.print(" " + stack.peek());
			stack.pop();
		}
	}



	public static void main(String args[]) {
		Stack<Integer> stack=new Stack<Integer>();;
		StackOperations stackOperations=new StackOperations();

		stack.push(1);stack.push(2);stack.push(3);stack.push(4);
		System.out.println("The elements of stack before : ");
		stackOperations.printStack(stack);
		stack.push(1);stack.push(2);stack.push(3);stack.push(4);

		
		stackOperations.reverse(stack);
		System.out.println("\nThe elements of stack after reversing are : ");
		stackOperations.printStack(stack);

		stack.push(4);stack.push(3);stack.push(1);stack.push(2);
		System.out.println("\nSorting the elements of stack : ");
		stackOperations.sortUsingRecursion(stack);
		stackOperations.printStack(stack);

		stack.push(4);stack.push(3);stack.push(1);stack.push(2);
		System.out.println("\nSorting the elements of stack using temporary stack : ");
		stackOperations.sortUsingTempStack(stack);
	}
}