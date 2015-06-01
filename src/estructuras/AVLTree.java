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
		return this.root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
	
	public boolean contains(T buscado){
		return contains(buscado, this.root);
	}
	
	private boolean contains(T buscado, BinaryNode<T> localRoot) {
		if (localRoot == null)
			return false;
		
		if (localRoot.getElement().equals(buscado))
			return true;
		
		boolean mayores = contains(buscado, localRoot.getRightChild());
		boolean menores = false;
		
		if (!mayores)
			menores = contains(buscado, localRoot.getLeftChild());
		
		return  mayores ? mayores : menores; 
	}
	
	public BinaryNode<T> getMinor() {
		BinaryNode<T> current = this.root;
		
		while (current.getLeftChild() != null)
			current = current.getLeftChild();
		
		return current;
	}
	
	public void printInOrder() {
		this.printInOrderSubTree(this.root);
	}
	
	private void printInOrderSubTree(BinaryNode<T> localRoot) {
		if (localRoot != null) {
			printInOrderSubTree(localRoot.getLeftChild());
			System.out.println(localRoot.toString());
			printInOrderSubTree(localRoot.getRightChild());
		}
	}
			
}
