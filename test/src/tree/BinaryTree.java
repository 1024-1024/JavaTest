package tree;

public interface BinaryTree<T> {

	public TreeNode<String> getRootElement();
	
	public int getHeight();
	
	public int getDepth();
	
	public void preOrder(TreeNode<T> node);
	
	public void midOrder(TreeNode<T> node);
	
	public void postOrder(TreeNode<T> node);
	
	public void recPreOrder(TreeNode<T> node);
	
	public void recMidOrder(TreeNode<T> node);
	
	public void recPostOrder(TreeNode<T> node);
	
}
