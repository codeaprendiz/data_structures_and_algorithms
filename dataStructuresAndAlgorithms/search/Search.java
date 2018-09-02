import java.io.*;
import java.lang.*;

class Search {

/*********************************************************************************************
				Binary Search Recursive 
**********************************************************************************************/
	int binarySearchRecursive(int arr[],int l,int r,int el) {
		int mid=(l+r)/2;
		if(l<=r) {
			if(arr[mid]==el) return mid;
			else if(arr[mid]>el) return binarySearchRecursive(arr,l,mid-1,el);
			else return binarySearchRecursive(arr,mid+1,r,el);
		}
		return -1;
	}

/*********************************************************************************************
				Binary Search Iterative 
**********************************************************************************************/
	int binarySearchIterative(int arr[],int l,int r,int el) {
		int mid=(l+r)/2;
		while(l<=r) {
			mid=(l+r)/2;
			if(arr[mid]==el) return mid;
			else if(arr[mid]>el) r=mid-1;
			else l=mid+1;
		}
		return -1;
	}

/*********************************************************************************************
				Linear Search Iterative 
**********************************************************************************************/
	int linearSearch(int arr[],int size,int el) {
		for(int i=0;i<size;i++) 
			if(arr[i]==el) return i;
		return -1;
	}


	int jumpSearch(int arr[],int size,int el) {
		int jump=(int)Math.sqrt(size);
		int i=0,prev=0;
		while(jump<size && arr[jump]<=el) {
			prev=jump;
			jump=jump+(int)Math.sqrt(size);
		}
		if(jump<size && arr[jump]>el && arr[prev]>el) return -1;
		if(arr[prev]<=el) {
			while(prev<Math.min(jump,size)) {
				if(arr[prev]==el) {
					return prev;
				}
				prev=prev+1;
			}
			if(Math.min(jump,size) == jump && arr[jump]==el) return jump; 
		}
		return -1;
	}

	void printArray(int arr[],int s) {
		for(int i=0;i<s;i++)
			System.out.print(" " + arr[i]);
	}


	public static void main(String args[]) {
		Search search=new Search();
		int arr[]={1,2,3,4,5,6,7,8,9};
		System.out.println("Elements fo array "); search.printArray(arr,9);
		System.out.println("\nSearching for 1 using binarySearchRecursive : " + arr[search.binarySearchRecursive(arr,0,8,1)] + " at index " + search.binarySearchRecursive(arr,0,8,1) );
		System.out.println("\nSearching for 15 using binarySearchRecursive : " + search.binarySearchRecursive(arr,0,8,15));
		System.out.println("\nSearching for 5 using binarySearchRecursive : " + arr[search.binarySearchIterative(arr,0,8,5)] + " at index " + search.binarySearchIterative(arr,0,8,5));
		System.out.println("\nSearching for 15 using binarySearchRecursive : " + search.binarySearchIterative(arr,0,8,15));
		System.out.println("\nSearching for 9 using linearSearch : " + arr[search.linearSearch(arr,9,9)] + " at index " + search.linearSearch(arr,9,9));
		System.out.println("\nSearching for 4 using jumpSearch : " + arr[search.jumpSearch(arr,9,4)] + " at index " + search.jumpSearch(arr,9,4));
	}
}