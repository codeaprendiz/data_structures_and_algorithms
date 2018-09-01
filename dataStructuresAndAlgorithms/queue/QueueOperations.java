import java.util.LinkedList;
import java.util.Queue;

class QueueOperations {


/****************************************************************************************
				To sort queue without using extra space
*****************************************************************************************/
	void sortQueue(Queue<Integer> q) {
		int i=0,minIndex=-1;
		for(i=1;i<=q.size();i++) {
			minIndex=getMinIndex(q,q.size()-i);
			insertToRear(q,minIndex);
		}
	}

	int getMinIndex(Queue<Integer> q,int sortIndex) {
		int i=0, minIndex=-1, minValue=Integer.MAX_VALUE,current=-1;
		for(i=0;i<q.size();i++) {
			current=q.peek();
			q.poll();
			if(current<=minValue && i<=sortIndex) {
				minValue=current;
				minIndex=i;
			}
			q.add(current);
		}
		return minIndex;
	}

	void insertToRear(Queue<Integer> q,int minIndex) {
		int i=0, current=-1,minValue=Integer.MAX_VALUE,size=q.size();
		for(i=0;i<size;i++) {
			current=q.peek();
			q.poll();
			if(i!=minIndex) q.add(current);
			else minValue=current;;
		}
		q.add(minValue);
	}

	public static void main(String args[]) {
		QueueOperations queueOperations=new QueueOperations();
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(4); q.add(3);q.add(2);q.add(1);q.add(23);q.add(40);

		queueOperations.sortQueue(q);

		while(q.isEmpty()== false)
        {
            System.out.print(q.peek() + " ");
            q.poll();
        }

	}
}
