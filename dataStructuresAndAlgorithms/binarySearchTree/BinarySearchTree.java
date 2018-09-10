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

class BinarySearchTree {
	Node root;

	BinarySearchTree(Node node) {
		root=node;
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
				Search - Recursive
*******************************************************/

	Node search(Node root, int key) {
		if(root==null || root.val==key) return root;
		if(key<root.val) return search(root.left,key);
		else return search(root.right,key);
	}

/******************************************************
				Insert - Recursive
*******************************************************/

	Node insert(Node root, int key) {
		if(root==null) { return new Node(key);}
		if(key>root.val) root.right=insert(root.right,key);
		else root.left=insert(root.left,key);
		return root;
	}

/******************************************************
				Deletion - Recursive
*******************************************************/	
	
	Node delete(Node root, int key) {
		if(root==null) return root;
		if(key>root.val) root.right=delete(root.right,key);
		else if(key<root.val) root.left=delete(root.left,key);
		else {
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else {
				root.val=keyOfInorderSuccessor(root.right);
				root.right=delete(root.right,root.val);
			}
		}
		return root;
	}

	int keyOfInorderSuccessor(Node root) {
		Node prev=null;
		while(root!=null) {
			prev=root;
			root=root.left;
		}
		return prev.val;
	}
	
/************************************************************************ 
Function to find Lowest Common Ancestor(LCA) of n1 and n2. The function 
assumes that both n1 and n2 are present in BST 
 *************************************************************************/
    	Node lca(Node node, int n1, int n2) 
    	{
        	if (node == null)
           		return null;
  
        	// If both n1 and n2 are smaller than root, then LCA lies in left
        	if (node.val > n1 && node.val > n2)
            		return lca(node.left, n1, n2);
  
       		 // If both n1 and n2 are greater than root, then LCA lies in right
        	if (node.val < n1 && node.val < n2) 
          	 	return lca(node.right, n1, n2);
  
        	return node;
   	 }

/************************************************************************ 
Function to check if this is a binary tree or not
*************************************************************************/

   	 // To keep tract of previous node in Inorder Traversal
    Node prev;
 
    boolean isBST()  {
        prev = null;
        return isBST(root);
    }
 
    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBST(Node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;
 
            // allows only distinct values node
            if (prev != null && node.val <= prev.val )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }

/*************************************************************************/

	public static void main(String[] args) {
		BinarySearchTree bt=new BinarySearchTree(new Node(20));
		bt.root.left=new Node(5);
		bt.root.right=new Node(35);

		System.out.println("PreOrder Traversal : ");
		bt.printPreorder(bt.root);

		Node keyNode=bt.search(bt.root,35);
		if(keyNode==null)
			System.out.println("Not found");
		else
			System.out.println("Searching for 35 : " + keyNode.val);

		System.out.println("Inserting 4,10,6,12,8,7 : ");
		bt.insert(bt.root,4); bt.insert(bt.root,10); bt.insert(bt.root,6); bt.insert(bt.root,12); bt.insert(bt.root,8);bt.insert(bt.root,7);

		System.out.println("PreOrder Traversal : ");
		bt.printPreorder(bt.root);

		System.out.println("Deleting 5 now : ");
		bt.delete(bt.root,5);

		System.out.println("PreOrder Traversal after deletion of 5 : ");
		bt.printPreorder(bt.root);

	}
}
