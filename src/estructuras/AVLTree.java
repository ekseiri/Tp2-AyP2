package estructuras;

public class AVLTree<T extends Comparable<? super T>> {
	private BinaryNode<T> root;
	
	public AVLTree() {
		setRoot(null);
	}
	
	public AVLTree(BinaryNode<T> root) {
		this.setRoot(root);
	}

	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
	
	
}
