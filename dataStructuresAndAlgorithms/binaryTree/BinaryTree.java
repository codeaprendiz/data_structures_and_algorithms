
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
		int val;
		Node left;
		Node right;

		Node(int value) {
			val=value;
			left=null;
			right=null;
		}
}

class BinaryTree {
	Node root;

	BinaryTree(Node node) {
		root=node;
	}

/******************************************************
			Inorder Traversal With Recursion
*******************************************************/


	void printInorder(Node root) {
		if(root==null) return;
		printInorder(root.left);
		System.out.println(root.val);
		printInorder(root.right);
	}

/******************************************************
			PreOrder Traversal With Recursion
*******************************************************/
	void printPreorder(Node root) {
		if(root==null) return;
		System.out.println(root.val);
		printPreorder(root.left);
		printPreorder(root.right);
	}

/******************************************************
			PostOrder Traversal With Recursion
*******************************************************/

	void printPostorder(Node root) {
		if(root==null) return;
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.println(root.val);
	}

/******************************************************
			Inorder Traversal - Iterative
*******************************************************/

	void printInorderIterative(Node root) {
		if(root==null) return;
		Stack<Node> s=new Stack<Node>();
		Node cur=root;
		while(cur!=null || s.size()>0) {
			while(cur!=null) {
				s.push(cur);
				cur=cur.left;
			}
			cur=s.pop();
			System.out.println(cur.val);
			cur=cur.right;
		}
	}


/******************************************************
			Preorder Traversal - Iterative
*******************************************************/

	void printPreorderIterative(Node root) {
		if(root==null) return;
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		Node cur=null;
		while(s.size()>0) {
			cur=s.pop();
			System.out.println(cur.val);
			if(cur.right!=null) s.push(cur.right);
			if(cur.left!=null) s.push(cur.left);
		}
	}



/******************************************************
			Level Traversal 
*******************************************************/
	void printLevelOrderTraversal(Node root) {
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node cur;
		while(!q.isEmpty()) {
			cur=q.peek();
			System.out.println(cur.val);
			q.remove();
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null) 
				q.add(cur.right);
		}
	}
/******************************************************
			Spiral Traversal 
*******************************************************/

	void printSpiral(Node root) {
		int h=height(root);
		int i=1;
		boolean leftToRight=false;
		for(i=1;i<=h;i++) {
			printLevel(root,i,leftToRight);
			leftToRight= !leftToRight;
		}
	}



	void printLevel(Node root,int level,boolean leftToRight) {
		if(root==null) return;
		if(level==1) {
			System.out.println(root.val);
			return;
		}
		if(leftToRight) {
			printLevel(root.left,level-1,leftToRight);
			printLevel(root.right,level-1,leftToRight);
		}
		else {
			printLevel(root.right,level-1,leftToRight);
			printLevel(root.left,level-1,leftToRight);
		}

	}



/******************************************************
					Insertion
Inserting a node in a binary tree at the first position 
available in level order traversal
*******************************************************/

	void insertUsingLevelOrder(Node root,int val) {
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node cur;
		while(!q.isEmpty()) {
			cur=q.peek();
			q.remove();
			if(cur.left != null)
				q.add(cur.left);
			else {
				cur.left=new Node(val);
				break;
			}
			if(cur.right != null) 
				q.add(cur.right);
			else {
				cur.right=new Node(val);
				break;
			}
		}
	}

/******************************************************
					Deletion
*******************************************************/	

	void deleteDeepestNode(Node root,Node delNode) {
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node cur;
		while(!q.isEmpty()) {
			cur=q.peek();
			q.remove();
			if(cur.right != null)
				if(cur.right == delNode) 
					cur.right=null;
				else
					q.add(cur.right);
			if(cur.left != null)
				if(cur.left==delNode)
					cur.left=null;
				else
					q.add(cur.left);

		}
	}

/******************************************************
					Deletion
*******************************************************/

	void deletionByCopying(Node root,int delKey) {
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node cur=null,delNode=null;
		while(!q.isEmpty()) {
			cur=q.peek();
			q.remove();
			if(cur.val==delKey) {
				delNode=cur;
			}
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null) 
				q.add(cur.right);
		}
		int x=cur.val; // cur is now the deepest node
		deleteDeepestNode(root,cur);
		delNode.val=x;
	}

/******************************************************
					Height of Binary Tree
*******************************************************/

	int height(Node node) {
		if(node==null) return 0;
		int lheight=height(node.left);
		int rheight=height(node.right);
		if(lheight>rheight) return lheight+1;
		else
			return rheight+1;
	}


	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(new Node(1));
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);

		System.out.println("Preorder Traversal initially with 1,2,3: ");
		bt.printPreorder(bt.root);

		System.out.println("Preorder Traversal finally with 1-6: ");
		bt.insertUsingLevelOrder(bt.root,4);
		bt.insertUsingLevelOrder(bt.root,5);
		bt.insertUsingLevelOrder(bt.root,6);

		bt.printPreorder(bt.root);

		System.out.println("Now going to delete node with value 2 : ");
		bt.deletionByCopying(bt.root,2);
		System.out.println("Preorder Traversal after deletion of 2 : ");
		bt.printPreorder(bt.root);
		System.out.println("Inorder Traversal after deletion of 2 : ");
		bt.printInorder(bt.root);		
		System.out.println("Postorder Traversal after deletion of 2 : ");
		bt.printPostorder(bt.root);

		System.out.println("Inorder Traversal Iterative : ");
		bt.printInorderIterative(bt.root);	

		System.out.println("Level Order Traversal : ");
		bt.printLevelOrderTraversal(bt.root);

		bt.insertUsingLevelOrder(bt.root,7);
		bt.insertUsingLevelOrder(bt.root,8);
		System.out.println("Spiral Traversal after inserting 7,8 : ");
		bt.printSpiral(bt.root);

		System.out.println("Preorder Traversal Iterative : ");
		bt.printPreorderIterative(bt.root);		
	}
}

