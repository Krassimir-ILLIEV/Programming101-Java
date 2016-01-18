import java.util.ArrayDeque;
import java.util.Queue;

public class BST <Item extends Comparable> {

	
	private Node parentNode;
	private Node leftmostNode;
	private Node rightmostNode;
	private Node root;
	
	private class Node{
		Item item;
		Node left;
		Node right;
		int depth;
		int height;
		
		public String toString(){
			return String.format("(item: %s, depth: %d,height: %d)", item,depth,height);
		}
	}
	
	public BST(){
		root=null;
				
	}
	
	public void add(Item item){
		root=addHelper(item,root);
	}
	
	private Node addHelper(Item item, Node node){
		
		if(node==null){
			node=new Node();
			node.item=item;
			return node;
		}
		if(item.compareTo(node.item)>=0){
			
			node.right=addHelper(item,node.right);
		} else node.left=addHelper(item,node.left);
		return node;
	}
	
	public boolean search(Item item){
		boolean isFound=searchHelper(item,root);
		return isFound;
	}
	
	private boolean searchHelper(Item item, Node node){
		if(node==null) return false;
		if(item.compareTo(node.item)>0) {
			return searchHelper(item,node.right);
		} if (item.compareTo(node.item)<0){
			return searchHelper(item,node.left);
		} else return true;
		
	}
	
	public String searchPath(Item item){
		return searchPathHelper(item,root);
	}
	
	private String searchPathHelper(Item item, Node node){
	
		if(node==null) return "false";
		if(item.compareTo(node.item)>0) {
			return node.item+";"+searchPathHelper(item,node.right);
		} if (item.compareTo(node.item)<0){
			return node.item+";"+searchPathHelper(item,node.left);
		} else return "true";
	}
	
	public void remove(Item item){
		Node removeFrom=removeHelper(item,root);
		if (removeFrom!=null){
			if(removeFrom.right!=null){
			removeFrom.right=findLeftmost(removeFrom.right);
		    removeFrom.item=leftmostNode.item;
		    leftmostNode=null;
			} else if (removeFrom.left!=null){
				removeFrom.left=findRightmost(removeFrom.left);
				removeFrom.item=rightmostNode.item;
				rightmostNode=null;
				}
			}
		}
	
	
	private Node removeHelper(Item item, Node node){
		if(node==null) return null;
		if(item.compareTo(node.item)>0) return removeHelper(item,node.right);
		if(item.compareTo(node.item)<0) return removeHelper(item,node.left);
		else return node;
		
	}
	
	//????????????????????????
	private Node findLeftmost(Node node){
		if (node.left==null){
			leftmostNode=node;
			return node.right;
		}
		node.left=findLeftmost(node.left);
		return node;
	}
	
	private Node findRightmost(Node node){
		if (node.right==null){
			rightmostNode=node;
			return node.left;
		}
		node.right=findRightmost(node.left);
		return node;
	}
	
	private void traverse_preorder(){
		
		traverseHelper(root,0);
	}
	
	private int traverseHelper(Node node, int depth){
		
		if(node==null) return 0;
		node.depth=depth;
		int lHeight=traverseHelper(node.left, depth+1);
		int rHeight=traverseHelper(node.right, depth+1);
		node.height=Math.max(lHeight, rHeight);
		return node.height+1; 
		
		
	}
	
private void traverse_postorder(){
		
		traverseHelper_post(root,0);
	}

private void traverseHelper_post(Node node, int depth){
	if(node==null) return;
	node.depth=depth;
	traverseHelper_post(node.right,depth+1);
	traverseHelper_post(node.left,depth+1);
}
	
	public String toString(){
		StringBuilder build=new StringBuilder();
		Queue<Node> q=new ArrayDeque<Node>();
		q.add(root);
		Item lastNodeItem=root.item;
		while(!q.isEmpty()){
			Node node=q.remove();
			//System.out.println();
			
			if(node.item.compareTo(lastNodeItem)<0){
				build.append("\n");
			}
			build.append(node+";");
			lastNodeItem=node.item;
			
			//System.out.print(node.item);
			if(node.left!=null)	q.add(node.left);
			if(node.right!=null) q.add(node.right);
			}
		build.append("\n");
		return build.toString();
		
	}
	
	public static void main(String[] args){
		BST<Integer> bst=new BST<Integer>();
		bst.add(10);
		bst.add(15);
		bst.add(13);
		//bst.add(14);
		bst.add(5);
		bst.add(2);
		bst.add(1);
		System.out.print(bst);
		System.out.println(bst.searchPath(12));
		
		//bst.Node d=bst.removeHelper(11,bst.root);
		
		
		
		bst.remove(5);
		bst.traverse_preorder();
		System.out.print(bst);
		
	}
}
