package tree;

public class TreeNode<T> {
	public T object;
	public TreeNode<T> parent;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T data) {
		this.object = data;
	}
	
}
