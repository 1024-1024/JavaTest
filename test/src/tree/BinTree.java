package tree;

import java.util.Stack;

public class BinTree implements BinaryTree<String>{

	private TreeNode<String> root;
	
	public void setRootElement(TreeNode<String> root) {
		this.root = root;
	}
	
	@Override
	public TreeNode<String> getRootElement() {
		return root;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int getDepth() {
		return 0;
	}
	
	@Override
	public void preOrder(TreeNode<String> node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				System.out.print(node.object + "-");
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				TreeNode<String> node1 = stack.pop();
				node = node1.right;
			}
			
		}
	}

	@Override
	public void midOrder(TreeNode<String> node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				TreeNode<String> node1 = stack.pop();
				System.out.print(node1.object + "-");
				node = node1.right;
			}
			
		}
	}

	@Override
	public void postOrder(TreeNode<String> node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
	    TreeNode<String> cur;                      //当前结点 
	    TreeNode<String> pre = null;                 //前一次访问的结点 
	    stack.push(root);
	    while(!stack.empty())
	    {
	        cur = stack.peek();
	        if((cur.left == null && cur.right == null)||(pre != null&&(pre == cur.left||pre == cur.right))) {
	            System.out.print(cur.object + "-");;  //如果当前结点没有孩子结点或者孩子节点都已被访问过 
	            stack.pop();
	            pre=cur; 
	        } else {
	            if(cur.right != null) {
	            	stack.push(cur.right);
	            }
	            if(cur.left != null) {
	            	stack.push(cur.left);
	            }
	        }
	    }    
	}

	@Override
	public void recPreOrder(TreeNode<String> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.object + "-");
		recPreOrder(node.left);
		recPreOrder(node.right);
		
	}

	@Override
	public void recMidOrder(TreeNode<String> node) {
		if (node == null) {
			return;
		}
		recMidOrder(node.left);
		System.out.print(node.object + "-");
		recMidOrder(node.right);
	}

	@Override
	public void recPostOrder(TreeNode<String> node) {
		if (node == null) {
			return;
		}
		recPostOrder(node.left);
		recPostOrder(node.right);
		System.out.print(node.object + "-");
	}

	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<String>("root");
		TreeNode<String> a = new TreeNode<String>("A");
		TreeNode<String> b = new TreeNode<String>("B");
		TreeNode<String> c = new TreeNode<String>("C");
		TreeNode<String> d = new TreeNode<String>("D");
		TreeNode<String> e = new TreeNode<String>("E");
		TreeNode<String> f = new TreeNode<String>("F");
		TreeNode<String> g = new TreeNode<String>("G");
		TreeNode<String> h = new TreeNode<String>("H");
		TreeNode<String> i = new TreeNode<String>("I");
		TreeNode<String> j = new TreeNode<String>("J");
		TreeNode<String> k = new TreeNode<String>("K");
		TreeNode<String> l = new TreeNode<String>("L");
		
		
		/**
		 * 				root
		 * 			a		    	b
		 * 		c		d      g       h
		 * 	e	   f   k  l   i j     
		 * 
		 * 前序遍历：root-a-c-e-f-d-k-l-b-g-i-j-h
		 * 中序遍历：e-c-f-a-k-d-l-root-i-g-j-b-h
		 * 后序遍历：e-f-c-k-l-d-a-i-j-g-h-b-root
		 * 
		 * 
		 * 
		 */
		
		root.left = a;
		root.right = b;
		root.parent = null;
		a.parent = b.parent = root;
		a.left = c;
		a.right = d;
		c.parent = d.parent = a;
		c.left = e;
		c.right = f;
		e.parent = f.parent = c;
		b.left = g;
		b.right = h;
		g.parent = h.parent = b;
		g.left = i;
		g.right = j;
		i.parent = j.parent = g;
		d.left = k;
		d.right = l;
		k.parent = l.parent = d;
		
		BinTree tree = new BinTree();
		tree.setRootElement(root);
		
		System.out.println("非递归前序遍历：");
		tree.preOrder(root);
		System.out.println();
		System.out.println("递归前序遍历：");
		tree.recPreOrder(root);
		System.out.println();
		
		System.out.println("非递归中序遍历：");
		tree.midOrder(root);
		System.out.println();
		System.out.println("递归中序遍历：");
		tree.recMidOrder(root);
		System.out.println();
		
		System.out.println("非递归后序遍历：");
		tree.postOrder(root);
		System.out.println();
		System.out.println("递归后序遍历：");
		tree.recPostOrder(root);
		System.out.println();
	}
	
}
