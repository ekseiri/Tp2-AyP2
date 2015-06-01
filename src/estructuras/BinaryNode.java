package estructuras;

public class BinaryNode<T extends Comparable<? super T>> implements Comparable<T> {
	
	private T element;
	private BinaryNode<T> childOf;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private int height;
	
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
		
		if ((left == null) && (right == null))
			this.setHeight(1);
		else if (left == null)
			this.setHeight(right.getHeight() + 1);
		else if (right == null)
			this.setHeight(left.getHeight() +1);
		else
			this.setHeight(Math.max(left.getHeight(), right.getHeight()) + 1);
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
		this.left = left;
	}
	
	public void setRightChild(BinaryNode <T> right) {
		this.right = right;
	}

	@Override
	public int compareTo(T o) {
		return this.element.compareTo(o);
	}
	
	public boolean equals(T o) {
		return this.element.equals(o);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString(){
		return this.getElement().toString();
	}
}
 