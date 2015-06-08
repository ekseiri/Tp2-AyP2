package estructuras;

public class BinaryNode<T extends Comparable<? super T>> implements Comparable<T> {
	
	private T element;
	private BinaryNode<T> childOf;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode (T element) {
		this(element, null);
	}
	
	public BinaryNode (T element, BinaryNode<T> parent) {
		this(element, parent, null, null);
	}
	
	public BinaryNode (T element, BinaryNode<T> parent, BinaryNode<T> left, BinaryNode<T> right) {
		this.element = element;
		this.childOf = parent;
		this.left = left;
		this.right = right;
	}
	
	public T getElement() {
		return this.element;
	}
	
	public BinaryNode<T> getParent() {
		return this.childOf;
	}
	
	public void setParent(BinaryNode<T> parent) {
		this.childOf = parent;
	}
	
	public BinaryNode<T> getLeftChild() {
		return this.left;
	}
	
	public BinaryNode<T> getRightChild() {
		return this.right;
	}
	
	public void setLeftChild(BinaryNode <T> left) {
		left.setParent(this);
		this.left = left;
	}
	
	public void setRightChild(BinaryNode <T> right) {
		right.setParent(this);
		this.right = right;
	}

	@Override
	public int compareTo(T o) {
		return this.element.compareTo(o);
	}
	
	public int compareTo(BinaryNode<T> o) {
		return this.compareTo(o.getElement());
	}
	
	public boolean equals(T o) {
		return this.element.equals(o);
	}
	
	public boolean equals(BinaryNode<T> o) {
		return this.equals(o.getElement());
	}

	public String toString(){
		return this.getElement().toString();
	}
}
 