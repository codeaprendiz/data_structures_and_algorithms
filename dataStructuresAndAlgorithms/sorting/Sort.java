import java.io.*;

class Sort {

	void swap(int arr[],int i,int j) {
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
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
		s.insertionSort(arr2,9);
		System.out.println("\nArray after selection sort : ");
		s.printArray(arr2,9);
	}
}