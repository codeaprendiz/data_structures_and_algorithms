import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node prev;

	Node(int data) {
		this.data=data;
		next=null;
		prev=null;
	}
}

class DoublyLinkedList {
	Node head;

	DoublyLinkedList() {
		head=null;
	}

	void iterateOverList() {
		Node cur=head;
		while(cur!=null) {
			System.out.println(cur.data);
			cur=cur.next;
		}
	}

	void insertFront(int data) {
		if(head==null) {
			head=new Node(data);
			return;
		} 
		Node cur=head;
		cur=new Node(data);
		cur.next=head;
		head=cur;
		cur.next.prev=cur;
	}

	void insertAfter(Node previous, int data) {
		if(previous==null) return;
		Node cur=new Node(data),succ=previous.next;
		if(succ!=null) {
			previous.next=cur; cur.prev=previous;
			cur.next=succ;     succ.prev=cur;
		}
		else {
			previous.next=cur;
			cur.prev=previous;
		}
	}

	void insertEnd(int data) {
		if(head==null) {
			head=new Node(data);
			return;
		}
		Node cur=head;
		while(cur.next!=null) cur=cur.next;
		cur.next=new Node(data);
	}

	void deleteNode(int data) {
		if(head.data==data) {
			head=head.next;
			head.prev=null;
			return;
		}
		Node cur=head.next,prev=head;
		while(cur!=null && cur.data!=data) {
			prev=cur;
			cur=cur.next;
		}
		if(cur==null) return;
		Node succ=cur.next;
		if(succ!=null) {
			prev.next=succ;
			succ.prev=prev;
		}
		else {
			prev.next=null;
		}
	}

	public static void main(String args[]) {
		DoublyLinkedList DLL=new DoublyLinkedList();
		DLL.insertFront(1);
		DLL.insertFront(2);
		System.out.println("After inserting 1 and 2 at fronts : ");
		DLL.iterateOverList();
		System.out.println("After inserting 3 after head : ");
		DLL.insertAfter(DLL.head,3);
		DLL.iterateOverList();
		System.out.println("After inserting 9 at the end : ");
		DLL.insertEnd(9);
		DLL.iterateOverList();

		System.out.println("Deleting 2 : ");
		DLL.deleteNode(2);
		DLL.iterateOverList();
		System.out.println("Deleting 1 : ");
		DLL.deleteNode(1);
		DLL.iterateOverList();
		System.out.println("Deleting 9 : ");
		DLL.deleteNode(9);
		DLL.iterateOverList();
	}
}