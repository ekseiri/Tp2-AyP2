package estructuras;

public class AVLTree<T extends Comparable<? super T>> {
	private BinaryNode<T> root;
	private int size;
		
	public AVLTree() {
		setRoot(null);
	}
	
	public AVLTree(BinaryNode<T> root) {
		this.setRoot(root);
		size = 0;
	}
	
	public int getSize(){
		return this.size;
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
		
		if (localRoot.getElement().compareTo(buscado) == 0)
			return true;
		
		boolean mayores = contains(buscado, localRoot.getRightChild());
		boolean menores = contains(buscado, localRoot.getLeftChild());
		
		return  (mayores) ? mayores : menores; 
	}
	
	public BinaryNode<T> buscar(T buscado){
		return buscar(buscado, this.root);
	}
	
	private BinaryNode<T> buscar(T buscado, BinaryNode<T> localRoot) {
		if (localRoot == null)
			return null;
		
		if (localRoot.getElement().compareTo(buscado) == 0)
			return localRoot;
		
		BinaryNode<T> mayores = buscar(buscado, localRoot.getRightChild());
		BinaryNode<T> menores = buscar(buscado, localRoot.getLeftChild());
		
		return  (mayores != null) ? mayores : menores; 
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
	
	public void insert(T element) {
 		if (this.getRoot() == null)
			this.setRoot(new BinaryNode<T>(element));
		else
			this.insert(new BinaryNode<T>(element), this.getRoot());
	}
	
	private void insert(BinaryNode<T> nodo, BinaryNode<T> localRoot) {
		
		if (localRoot.compareTo(nodo) < 0) { 
			if (localRoot.getRightChild() != null) {
				insert (nodo, localRoot.getRightChild());
			} else {
				localRoot.setRightChild(nodo);
				size++;
			}
		}
		
		if (localRoot.compareTo(nodo) > 0) { 
			if (localRoot.getLeftChild() != null) {
				insert (nodo, localRoot.getLeftChild());
			} else {
				localRoot.setLeftChild(nodo);
				size++;
			}
		}
	}
			
}
