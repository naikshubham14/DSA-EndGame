package treeDS;
import java.util.*;

import treeDS.BST.DiaPair;

public class BinaryTree {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BST bt=new BST();
		boolean flag=true;int val=0;int inorder[];
		while(flag){
			System.out.println();
			System.out.println("1.--| Insertion in BST(itterative approach)");
			System.out.println("2.--| Insertion in BST(recurrsive approach)");
			System.out.println("3.--| Insertion in BT(level order insertion)");
			System.out.println("4.--| Print 2D");
			System.out.println("5.--| Height of tree");
			System.out.println("6.--| Sum of BT");
			System.out.println("7.--| Total no. of nodes in BT");
			System.out.println("8.--| Maximum value in BT");
			System.out.println("9.--| Print level order(BFS)");
			System.out.println("10.-| Sum at level K");
			System.out.println("11.-| Print Inorder Traversal");
			System.out.println("12.-| Print Preorder Traversal");
			System.out.println("13.-| Print Postorder Traversal");
			System.out.println("14.-| All paths from root to leaf nodes");
			System.out.println("15.-| Search in BST");
			System.out.println("16.-| Diameter of BT(nibbi approach)");
			System.out.println("17.-| Diameter of BT(legend approach)");
			System.out.println("18.-| isBalanced()");
			System.out.println("19.-| Delete node");
			System.out.println("20.-| Construct BT from Preorder and Inorder");
			System.out.println("21.-| Construct BT from Postorder and Inorder");
			System.out.println("22.-| Construct BST from Inorder");
			System.out.println("23.-| exit");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter value");
				val=sc.nextInt();
				bt.insertNodeITTE(val);
			break;
			case 2:
				System.out.println("Enter value");
				val=sc.nextInt();
				bt.root=bt.insertNodeRECURR(bt.root, val);
			break;
			case 3: System.out.println("Enter value");
					val=sc.nextInt();
					bt.insert(bt.root, val);
			break;
			case 4:
				bt.print2D(bt.root, 5);
			break;
			
			case 5: System.out.println(bt.Height(bt.root));
			break;
			case 6: System.out.println(bt.sumOfBT(bt.root));
			break;
			case 7:System.out.println(bt.countNodes(bt.root));
			break;
			case 8: System.out.println(bt.maxNoBT(bt.root));
			break;
			
			case 9: bt.printLevelOrderBFS(bt.root);
			break;
			case 10: System.out.println("Enter level");
			val=sc.nextInt();
			bt.s=0;
			System.out.println(bt.sumAtGivenLevel(bt.root, val));
			break;
			case 11:bt.printInorder(bt.root);
			break;
			case 12:bt.printPreorder(bt.root);
			break;
			case 13:bt.printPostorder(bt.root);
			break;
			case 14: bt.rootToleaf(bt.root);
			break;
			case 15:System.out.println("Enter value to search");
			val=sc.nextInt();
			System.out.println(bt.Search(val));
			break;
			
			case 16: System.out.println(bt.diameterOfBT(bt.root));
			break;
			case 17: DiaPair d=new DiaPair();
			d=bt.diameter(bt.root);
			System.out.println(d.dia);
			break;
			case 18: bt.Height(bt.root);
			System.out.println(bt.isBal);
			break;
			case 19:System.out.println("Enter value to delete");
			val=sc.nextInt(); 
			bt.root=bt.delete(bt.root,val);
			break;
			
			case 20:
				System.out.println("No. of Nodes in your BT ?");
				val=sc.nextInt();
				int preorder[]=new int[val];
				inorder=new int[val];
				
				System.out.println("Enter values in preorder sequence");
				for(int i=0;i<val;i++)
					preorder[i]=sc.nextInt();
				System.out.println("Enter values in inorder sequence");
				for(int i=0;i<val;i++)
					inorder[i]=sc.nextInt();
				bt.root=bt.buildTreeFromInorderPreorder(preorder,inorder);
			break;
			case 21:
				System.out.println("No. of Nodes in your BT ?");
				val=sc.nextInt();
				int postorder[]=new int[val];
				inorder=new int[val];
				
				System.out.println("Enter values in postorder sequence");
				for(int i=0;i<val;i++)
					postorder[i]=sc.nextInt();
				System.out.println("Enter values in inorder sequence");
				for(int i=0;i<val;i++)
					inorder[i]=sc.nextInt();
				bt.root=bt.buildTreeFromInorderPostorder(postorder,inorder);
			break;
			
			case 22:
				System.out.println("No. of Nodes in your BT ?");
				val=sc.nextInt();
				inorder=new int[val];
				System.out.println("Enter values in inorder sequence");
				for(int i=0;i<val;i++)
					inorder[i]=sc.nextInt();
				bt.root=bt.buildBSTfromInorder(inorder);
			break;	
			
			case 23: flag=false; break;
			default: System.out.println("Invalid choice"); 

			}
		}

	}

}

class BST{
	
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int val) {
			data=val;
			left=right=null;
		}
	}
	
	Node root;
	public BST() {
		root=null;
	}
	public boolean isTreeEmpty() {
		return root==null;
	}
	
	
	//1.--| Insertion in BST(itterative approach) STARTS
		public void insertNodeITTE(int val) {
			Node n=new Node(val);
			
			if(isTreeEmpty())
			{
				root=n;
				System.out.println("Value inserted as root node");
			}
			else {
				Node temp=root;
				while(temp!=null) {
					if(val==temp.data) {
						System.out.println("Value already exist");
						return;
					}
					//for left insertion i.e., when val<currNode
					else if(val<temp.data && temp.left==null) {
						temp.left=n;
						System.out.println("Value inserted to left");
						break;
					}
					else if(val<temp.data) {
						temp=temp.left;
					}
					//for right insertion i.e., when val>currNode
					else if(val>temp.data && temp.right==null) {
						temp.right=n;
						System.out.println("Value inserted to right");
						break;
					}
					else//(val>temp.data) 
					{
						temp=temp.right;
					}
					
				}
			}
		}
	//1.--| Insertion in BST(itterative approach) ENDS
	
	
	//2.--| Insertion in BST(recurrsive approach) STARTS
	public Node insertNodeRECURR(Node root, int key) {
		
		// if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if the given key is less than the root node,
        // recur for the left subtree
        if (key < root.data) {
            root.left = insertNodeRECURR(root.left, key);
        }
 
        // otherwise, recur for the right subtree
        else {
            // key >= root.data
            root.right = insertNodeRECURR(root.right, key);
        }
 
        return root;
	}
	//2.--| Insertion in BST(recurrsive approach) ENDS
	
	
	//3.--| Insertion in BT(level order insertion) STARTS
		public  void insert(Node rt,int val) {
			Node nn=new Node(val);
			if(rt==null) {
				rt=nn;
				System.out.println("inserted at root");
				root=rt;
				return;
			}
			Queue<Node> q=new LinkedList<Node>();
			q.add(rt);
			
			while(!q.isEmpty()) {
				Node n=q.element();
				q.remove();
				
				if(n.left==null) {
					n.left=nn;
					System.out.println("inserted left of BT");
					root=rt;
					return;
				}
				else if(n.right==null) {
					n.right=nn;
					System.out.println("inserted right of BT");
					root=rt;
					return;
				}
				else {
					q.add(n.left);
					q.add(n.right);
				}
			}
			
		}
	//3.--| Insertion in BT(level order insertion) ENDS
		

	//4.--| Print 2D STARTS
		public void print2D(Node r,int space) {
			
			if (r ==null) // Base case  1
			   return;
			print2D(r.right,space+5);
			System.out.println();
			
			for(int i=0;i<space;i++)
				System.out.print(" ");
			
			System.out.println(r.data);
			print2D(r.left,space+5);
		}
	//4.--| Print 2D ENDS
		
		
	//5.--| Height of tree / 18.-| isBalanced() STARTS
		static boolean isBal=true;//only to find balanced BT, ignore.
		public static int Height(Node r) {
			if(r==null) return -1;
			else {
				int lh=Height(r.left);
				int rh=Height(r.right);
				
				// ignore THIS, while thinking about height of BT
				if(Math.abs(lh-rh)>1)
					isBal=false;
				// }
				return Math.max(lh, rh)+1;
			}
		}
	//5.--| Height of tree / 18.-| isBalanced()  ENDS	
		
	
	//6.--| Sum of BT STARTS	
		public int sumOfBT(Node r) {
			if(r==null) {
				return 0;
			}
			int lsum=sumOfBT(r.left);
			int rsum=sumOfBT(r.right);
			return lsum+rsum+r.data;
			
		}
	//6.--| Sum of BT ENDS
		
		
	//7.--| No. of nodes in BT STARTS	
		public int countNodes(Node r) {
			if(r==null) {
				return 0;
			}
			int lc=countNodes(r.left);
			int rc=countNodes(r.right);
			return lc+rc+1;
		}
	//7.--| No. of nodes in BT ENDS
		
		
	//8.--| Maximum value in BT STARTS	
		public int maxNoBT(Node r) {
			if(r==null) return Integer.MIN_VALUE;
			int lmax=maxNoBT(r.left);
			int rmax=maxNoBT(r.right);
			return Math.max(r.data, Math.max(lmax, rmax));
		}
	//8.--| Maximum value in BT ENDS
		
		
	//9.--| Print level order(BFS) STARTS
		void printLevelOrderBFS(Node r) {
		    int h = Height(r);
		    for (int i = 0; i <= h; i++)
		      printGivenLevel(r, i);
		  }

		private void printGivenLevel(Node r, int level) {
			if (r == null)
			      return;
			else if (level == 0)
			      System.out.print(r.data+" ");
			    else // level > 0  
			    {
			      printGivenLevel(r.left, level - 1);
			      printGivenLevel(r.right, level - 1);
			    }
		}
	//9.--| Print level order(BFS) ENDS
		
		
	//10.-| Sum at level K STARTS	
		int s=0;
		public int sumAtGivenLevel(Node r,int level) {
			
			if (r == null)
			      return s;
			else if (level == 0)
			   s=s+r.data;
			else // level > 0  
			{
				sumAtGivenLevel(r.left, level - 1);
				sumAtGivenLevel(r.right, level - 1);
			}
			return s;
		}
	//10.-| Sum at level K ENDS	
		
	
	//11.-| Print Inorder Traversal STARTS	
		public void printInorder(Node r) {// L N R
			if(r==null) return;
			printInorder(r.left);
			System.out.print(r.data+" ");
			printInorder(r.right);
		}
	//11.-| Print Inorder Traversal ENDS
	
		
	//12.-| Print Preorder Traversal STARTS	
	public void printPreorder(Node r) { // N L R
		if(r==null) return;
		System.out.print(r.data+" ");
		printPreorder(r.left);
		printPreorder(r.right);
	}
	//12.-| Print Preorder Traversal ENDS
	
	
	//13.-| Print Postorder Traversal STARTS
	public void printPostorder(Node r) { // L R N
		if(r==null) return;
		printPostorder(r.left);
		printPostorder(r.right);
		System.out.print(r.data+" ");
	}
	//13.-| Print Postorder Traversal ENDS
	
	
	//14.-| All paths from root to leaf nodes STARTS
		//print path from root to leafnodes just modifying Inorder and using stacks.
		static Stack<Integer> st=new Stack();
		public static void rootToleaf(Node r) {
			if(r==null)return;
			
			st.push(r.data);
			rootToleaf(r.left);
			if(r.left==null && r.right==null)
				System.out.println(st);
			rootToleaf(r.right);
			st.pop();
		}
	//14.-| All paths from root to leaf nodes ENDS	
	
	
	//15.-| Search in BST STARTS	
		public boolean Search(int val) {
			boolean flag=false;
			if(root==null)
			{
				System.out.println("Binary Tree is empty");
			}
			else {
				Node temp=root;
				while(temp!=null) {
					if(val==temp.data) { flag= true; break;}
					else if(val<temp.data) temp=temp.left;
					else if(val>temp.data) temp=temp.right;
				}
			}
			return flag;	
		}
	//15.-| Search in BST ENDS
	
		
	//16.-| Diameter of BT(nibbi approach) STARTS
		public static int diameterOfBT(Node r) {
			if(r==null) return 0;
			//maximum distance between two nodes of LHS (factor 1)
			int ld=diameterOfBT(r.left);
			//maximum distance between two nodes of RHS (factor 2)
			int rd=diameterOfBT(r.right);
			//maximum distance between left's deepest & right's deepest nodes (factor 3)
			int des=Height(r.left)+Height(r.right)+2;
			
			int dia =Math.max(des, Math.max(ld, rd));
			return dia;
		}
	//16.-| Diameter of BT(nibbi approach) ENDS
	
	
	//17.-| Diameter of BT(legend approach) STARTS
		 static class DiaPair{
			int ht;
			int dia;
		}
		public static DiaPair diameter(Node node) {
			if(node==null) {
				DiaPair bp=new DiaPair();
				bp.ht=-1;
				bp.dia=0;
				return bp;
			}
			DiaPair lp=diameter(node.left);
			DiaPair rp=diameter(node.right);
			
			DiaPair mp=new DiaPair();
			mp.ht=Math.max(lp.ht, rp.ht)+1;
			
			int des=lp.ht + rp.ht + 2;
			mp.dia=Math.max(des, Math.max(lp.dia, rp.dia));
			
			return mp;
		}
	//17.-| Diameter of BT(legend approach) ENDS
	
	
	//19.-| Delete node STARTS
		public static Node delete(Node node,int val) {
			if(node==null) return null;
			if(val<node.data) {
				node.left=delete(node.left,val);
			}
			else if(val>node.data) {
				node.right=delete(node.right,val);
			}
			else {
				if(node.left!=null && node.right!=null) {
					int lmax=maxLeft(node.left);
					node.data=lmax;
					node.left=delete(node.left,lmax);
				}
				else if(node.left!=null) {
					return  node.left;
				}
				else if(node.right!=null) {
					return  node.right;
				}
				else {
					return null;
				}
			}
			return node;
		}
		
		public static int maxLeft(Node node) {
			if(node.right!=null) {
				return maxLeft(node.right);
			}
			else {
				return node.data;
			}
		}
//19.-| Delete node ENDS	
		
		
//20.-| Construct BT from Preorder and Inorder STARTS
		public  Node buildTreeFromInorderPreorder(int preorder[],int inorder[]){
			int n=inorder.length;
			System.out.println("Your BT is ready PRESS 4 AND ENTER to view");
			return preInTree(preorder,0,n-1,inorder,0,n-1);
		}
		
		//psi=preorder starting index, pei=preorder ending index.
		//isi=inorder starting index, iei=inorder ending inex.
		public  Node preInTree(int pre[],int psi,int pei,int in[],int isi,int iei) {
			if(isi>iei) return null;
			
			Node n=new Node(pre[psi]);
			int idx=isi;
			while(in[idx]!=pre[psi])
				idx++;
			int tnel=idx-isi;// total no. of element on left side/right side of root.
			
			n.left=preInTree(pre, psi+1, psi+tnel, in, isi,idx-1);
			n.right=preInTree(pre, psi+tnel+1, pei, in, idx+1, iei);
			
			return n;
		}
//20.-| Construct BT from Preorder and Inorder ENDS
		
		
//21.-| Construct BT from Postorder and Inorder STARTS
		public  Node buildTreeFromInorderPostorder(int postorder[],int inorder[]){
			int n=postorder.length;
			System.out.println("Your BT is ready PRESS 4 AND ENTER to view");
			return postInTree(postorder,0,n-1,inorder,0,n-1);
		}
				
		//psi=postorder starting index, pei=postorder ending index.
		//isi=inorder starting index, iei=inorder ending inex.
		public  Node postInTree(int post[],int psi,int pei,int in[],int isi,int iei) {
			if(isi>iei) return null;
				Node n=new Node(post[pei]);
				int idx=isi;
				while(in[idx]!=post[pei])
					idx++;
				int tnel=idx-isi;// total no. of element on left side/right side of root.
					
			n.left=postInTree(post, psi, psi+tnel-1, in, isi,idx-1);
			n.right=postInTree(post, psi+tnel, pei-1, in, idx+1, iei);
					
			return n;
	    }
//21.-| Construct BT from Postorder and Inorder ENDS
		
		

//22.-| Construct BST from Inorder Sequence STARTS.
		public Node buildBSTfromInorder(int inorder[]) {
			int n=inorder.length;
			System.out.println("Your BST is ready PRESS 4 AND ENTER to view");
			return buildBSTfromInorder(inorder,0,n-1);
		}
		
		private Node buildBSTfromInorder(int[] in, int si, int ei) {
			if(si>ei)
				return null;
			int midRoot=(si+ei)/2;
			Node n=new Node(in[midRoot]);
			
			n.left=buildBSTfromInorder(in,si,midRoot-1);
			n.right=buildBSTfromInorder(in,midRoot+1,ei);
			
			return n;
		}
//22.-| Construct BST from Inorder Sequence ENDS.

	
}