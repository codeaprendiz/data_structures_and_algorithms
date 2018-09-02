import java.io.*;

class Sort {

	void swap(int arr[],int i,int j) {
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}


/******************************************************************************
		                Heap Sort
*******************************************************************************/
	void heapSort(int arr[],int size) {
		int i=0;
		for(i=0;i<size/2-1;i++)
			heapify(arr,size,i);
		for(i=size-1;i>=0;i--) {
			int smallest=arr[0];
			arr[0]=arr[i];
			arr[i]=smallest;
			heapify(arr,i,0);
		}
	}

	void heapify(int arr[],int size,int startIndex) {
		int leftChildIndex=2*startIndex+1,rightChildIndex=2*startIndex+2,largestIndex=startIndex;
		if(leftChildIndex<size && arr[leftChildIndex]>arr[largestIndex]) largestIndex=leftChildIndex;
		if(rightChildIndex<size && arr[rightChildIndex]>arr[largestIndex]) largestIndex=rightChildIndex;
		if(largestIndex!=startIndex) {
			swap(arr,largestIndex,startIndex);
			heapify(arr,size,largestIndex);
		}
	}

/******************************************************************************
		                Quick Sort
*******************************************************************************/
	void quickSort(int arr[],int l,int r) {
		int p;
		if(l<r) {
			p=partition(arr,l,r);
			quickSort(arr,l,p-1);
			quickSort(arr,p+1,r);
		}
	}

	int partition(int arr[],int l,int r) {
		int i=l-1,j=l,pivot=arr[r];
		while(j<r) {
			if(arr[j]<=pivot) {
				i=i+1;
				swap(arr,i,j);
			}
			j+=1;
		}
		swap(arr,i+1,r);
		return i+1;
	}

/******************************************************************************
		                Merge Sort
*******************************************************************************/
	void mergeSort(int arr[],int l,int r) {
		int m=(l+r)/2;
		if(l<r) {
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}

	void merge(int arr[],int l,int m,int r) {
		int tempA[]=new int[m-l+1],tempB[]=new int[r-m],i,j,k;
		for(i=0;i<m-l+1;i++)
			tempA[i]=arr[l+i];
		for(j=0;j<r-m;j++)
			tempB[j]=arr[j+m+1];

		i=0;j=0;k=l;
		while(i<m-l+1 && j<r-m) {
			if(tempA[i]<tempB[j]) {
				arr[k]=tempA[i];
				i+=1;
			}
			else {
				arr[k]=tempB[j];
				j+=1;
			}
			k+=1;
		}

		while(i<m-l+1) {
			arr[k]=tempA[i];
			k+=1;
			i+=1;
		}

		while(j<r-m) {
			arr[k]=tempB[j];
			k+=1;
			j+=1;
		}
	}

/******************************************************************************
		                Bubble Sort
*******************************************************************************/
	void bubbleSort(int arr[],int size) {
		for(int i=0;i<size;i++)
			for(int j=1;j<size-i;j++) 
				if(arr[j-1]>arr[j])
					swap(arr,j,j-1);
	}


/******************************************************************************
		                Selection Sort
*******************************************************************************/
	void selectionSort(int arr[],int size) {
		int smallest=Integer.MAX_VALUE,smallestIndex=-1;
		for(int i=0;i<size-1;i++) {
			smallest=arr[i];
			for(int j=i+1;j<size;j++)
				if(arr[j]<smallest) {
					smallest=arr[j];
					smallestIndex=j;
				}
			swap(arr,i,smallestIndex);
		}
	}

/******************************************************************************
		                Insertion Sort
*******************************************************************************/
	void insertionSort(int arr[],int size) {
		int key,i,j;
		for(i=1;i<size;i++) {
			key=arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}

	void printArray(int arr[], int size) {
		for(int i=0;i<size;i++)
			System.out.print(" " + arr[i]);
	}

	public static void main(String args[]) {
		int arr[]={9,8,7,6,5,4,3,2,1};
		Sort s=new Sort();
		System.out.println("Array before bubble sort : ");
		s.printArray(arr,9);
		s.bubbleSort(arr,9);
		System.out.println("\nArray after bubble sort : ");
		s.printArray(arr,9);

		int arr1[]={9,8,7,6,5,4,3,2,1};
		System.out.println("\nArray before insertion sort : ");
		s.printArray(arr1,9);
		s.insertionSort(arr1,9);
		System.out.println("\nArray after insertion sort : ");
		s.printArray(arr1,9);

		int arr2[]={9,8,7,6,5,4,3,2,1};
		System.out.println("\nArray before selection sort : ");
		s.printArray(arr2,9);
		s.selectionSort(arr2,9);
		System.out.println("\nArray after selection sort : ");
		s.printArray(arr2,9);

		int arr3[]={9,8,7,6,5,4,3,2,1};
		System.out.println("\nArray before quick sort : ");
		s.printArray(arr3,9);
		s.quickSort(arr3,0,8);
		System.out.println("\nArray after quick sort : ");
		s.printArray(arr3,9);

		int arr4[]={9,8,7,6,5,4,3,2,1};
		System.out.println("\nArray before merge sort : ");
		s.printArray(arr4,9);
		s.mergeSort(arr4,0,8);
		System.out.println("\nArray after merge sort : ");
		s.printArray(arr4,9);

		int arr5[]={10,9,8,7,6,5,4,3,2,1};
		System.out.println("\nArray before heap sort : ");
		s.printArray(arr5,10);
		s.heapSort(arr5,10);
		System.out.println("\nArray after heap sort : ");
		s.printArray(arr5,10);
	}
}