import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data=data;
		next=null;
	}
}

class SinglyLinkedList {
	Node head;

	SinglyLinkedList() {
		head=null;
	}

	void iterateOverList() {
		int i=0;
		Node cur=this.head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}

	void insertFront(int data) {
		Node cur;
		cur=new Node(data);
		cur.next=head;
		head=cur;
	}

	void insertAfter(Node prev, int data) {
		if(prev==null) return;
		Node cur;
		cur=new Node(data);
		cur.next=prev.next;
		prev.next=cur;
	}

	void insertEnd(int data) {
		Node cur=head;
		if(head==null) {
			head=new Node(data);
			return;
		}
		while(cur.next!=null) cur=cur.next;
		cur.next=new Node(data);
	}

	void deleteNode(int data) {
		Node cur=head.next,prev=head,succ=null;
		if(head.data==data){
			head=head.next;
			return;
		} 
		while(cur!=null && cur.data!=data) {
			prev=cur;
			cur=cur.next;
		}
		if(cur==null) return;
		prev.next=cur.next;
	}
	
	boolean hasCycle() {
     		Node slow_p = head, fast_p = head; 
        	while (slow_p != null && fast_p != null && fast_p.next != null) { 
            		slow_p = slow_p.next; 
            		fast_p = fast_p.next.next; 
            		if (slow_p == fast_p) { 
                		//System.out.println("Found loop"); 
                		return true; 
            		} 
        	} 
        	return false; 
	}

	public static void main(String args[]) {
		SinglyLinkedList SLL=new SinglyLinkedList();
		SLL.insertFront(1);
		SLL.insertFront(2);
		SLL.insertFront(3);
		SLL.insertAfter(SLL.head,4);
		SLL.insertEnd(5);

		SLL.iterateOverList();
		System.out.println("Deleting 1");
		SLL.deleteNode(1);
		SLL.iterateOverList();
		System.out.println("Deleting 3");
		SLL.deleteNode(3);
		SLL.iterateOverList();
		System.out.println("Deleting 5");
		SLL.deleteNode(5);
		SLL.iterateOverList();
	}
}
