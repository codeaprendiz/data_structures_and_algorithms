import java.io.*;
import java.util.*;

class MinHeap {
	int curHeapSize,capacity,heap[];

	MinHeap(int capacity) {
		curHeapSize=-1;
		this.capacity=capacity;
		heap=new int[this.capacity];
	}

	int getParentIndex(int i) { return (i-1)/2;}

	int getLeftChildIndex(int i) { return 2*i+1;}

	int getRightChildIndex(int i) { return 2*i+2;}

	void insertKey(int key) {
		if(this.curHeapSize==this.capacity-1) {
			System.out.println("Overflow.");
			return;
		}
		this.curHeapSize=this.curHeapSize+1;
		this.heap[this.curHeapSize]=key;
		int i=this.curHeapSize;
		while(i!=0 && this.heap[i]<this.heap[getParentIndex(i)]) {
			swap(this.heap,i,getParentIndex(i));
			i=getParentIndex(i);
		}
	}

	void decreaseKey(int index,int val) {
		this.heap[index]=val;
		int i=index;
		while(i!=0 && this.heap[i]<this.heap[getParentIndex(i)]) {
			swap(this.heap,i,getParentIndex(i));
			i=getParentIndex(i);
		}
	}

	int extractMin() {
		int min=this.heap[0];
		heap[0]=heap[curHeapSize];
		curHeapSize=curHeapSize-1;
		Heapify(0);
		return min;
	}

	void deleteKey(int index) {
		decreaseKey(index,Integer.MIN_VALUE);
		extractMin();
	}

	void Heapify(int index) {
		int leftChildIndex=getLeftChildIndex(index),rightChildIndex=getRightChildIndex(index),indexOfMinValue=index;
		if(leftChildIndex<=curHeapSize && this.heap[index]>this.heap[leftChildIndex]) indexOfMinValue=leftChildIndex;
		else if(rightChildIndex<=curHeapSize && this.heap[indexOfMinValue]>this.heap[rightChildIndex]) indexOfMinValue=rightChildIndex;
		if(indexOfMinValue!=index) {
			swap(this.heap,indexOfMinValue,index);
			Heapify(indexOfMinValue);
		}
	}

	void swap(int arr[],int i,int j) {
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	void printHeap() {
		int i=0;
		System.out.println("The heap is : ");
		for(i=0;i<=curHeapSize;i++) 
			System.out.print("  " + this.heap[i]);
	}

	public static void main(String args[]) {
		MinHeap minHeap=new MinHeap(11);
		minHeap.insertKey(3);
    	minHeap.insertKey(2);
    	minHeap.insertKey(15);
    	minHeap.insertKey(5);
    	minHeap.insertKey(4);
    	minHeap.insertKey(45);

   		minHeap.printHeap();
   		System.out.println("\nExtracting min : " + minHeap.extractMin());
   		minHeap.printHeap();
   		System.out.println("\nExtracting min : " + minHeap.extractMin());
   		minHeap.printHeap();
   		System.out.println("\nExtracting min : " + minHeap.extractMin());
   		minHeap.printHeap();
   		System.out.println("\nExtracting min : " + minHeap.extractMin());
   		minHeap.printHeap();
   		System.out.println("\nExtracting min : " + minHeap.extractMin());
   		minHeap.printHeap();
   		System.out.println("\nExtracting min : " + minHeap.extractMin());
   		minHeap.printHeap();

   		System.out.println("Inserting values again : ");
   		minHeap.insertKey(3);
    	minHeap.insertKey(2);
    	minHeap.insertKey(15);
    	minHeap.insertKey(5);
    	minHeap.insertKey(43);
    	minHeap.insertKey(45);

    	minHeap.printHeap();
    	System.out.println("\nDeleting key at index 1");
    	minHeap.deleteKey(1);
    	minHeap.printHeap();
    	System.out.println("\nReducing the key at index 1 to value 1");
    	minHeap.decreaseKey(1,1);
    	minHeap.printHeap();
	}
}