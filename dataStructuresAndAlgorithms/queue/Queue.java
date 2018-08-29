import java.io.*;
import java.util.*;

class Queue {
	int front,rear,size,capacity,arr[];

	Queue(int capacity) {
		front=rear=-1;
		size=0;
		this.capacity=capacity;
		arr=new int[this.capacity];
	}

	int peekNextFront() {
		return arr[(front+1)%capacity];
	}

	boolean isFull() {
		return this.size==this.capacity;
	}

	boolean isEmpty() {
		return size==0;
	}

	void enqueue(int el) {
		if(!isFull()) {
			rear=(rear+1)%capacity;
			arr[rear]=el;
			size=size+1;
		}
	}

	void deque() {
		if(!isEmpty()) {
			front=(front+1)%capacity;
			size=size-1;
		}
	}

	void printQueue() {
		int i=front+1;
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		if(front+1<=rear)
			for(i=front+1;i<=rear;i++) 
				System.out.print("  " + arr[i]);
		else {
			while(i<capacity) {
				System.out.print("  " + arr[i]);
				i++;
			}
			i=i%capacity;
			while(i<=rear) {
				System.out.print("  " + arr[i]);
				i++;	
			}
		}
		System.out.println();
	}


/**************************************************************
					Reversing a Queue Using Recursion
***************************************************************/

	void reverse() {
		if(isEmpty()) return;
		int el=peekNextFront();
		deque();
		reverse();
		enqueue(el);
	}


/**************************************************************
					Reversing a Queue Using Stack
***************************************************************/

	void reverseUsingStack() {
		Stack<Integer> s=new Stack<Integer>();
		while(!isEmpty()) {
			s.add(peekNextFront());
			deque();
		}
		while(!s.isEmpty()) {
			enqueue(s.peek());
			s.pop();
		}
	}






	public static void main(String args[]) {
		Queue q=new Queue(10);
		System.out.println("Adding 1,2,3,4,5,6,7,8,9 ");
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(6);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(5);
		q.enqueue(3);
		q.enqueue(4);

		System.out.println("Printing Queue ");
		q.printQueue();
		System.out.println("Dequeing ");
		q.deque();
		System.out.println("Printing Queue ");
		q.printQueue();
		System.out.println("Reversing Queue using recursion");
		q.reverse();
		q.printQueue();
		System.out.println("Reversing Queue using stack");
		q.reverseUsingStack();
		q.printQueue();
	}
}