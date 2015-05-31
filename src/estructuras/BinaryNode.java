package estructuras;
import main.Cliente;

public class BinaryNode<T> extends Node<T> {
	
	public Cliente element;
	public BinaryNode<T> childOf;
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	
	public BinaryNode (Cliente element) {
		this(element, null);
	}
	
	public BinaryNode (Cliente element, BinaryNode<T> parent) {
		this.element = element;
		this.childOf = parent;
	}
	
	public void addChild(BinaryNode<T> nodo) {
		int comparacion = nodo.element.getPatente().compareTo(this.element.getPatente());
		
		if (comparacion < 0) {
			//menor que
		} else if (comparacion > 0) {
			//mayor que
		} else {
			throw new IllegalArgumentException("Las patentes son iguales, this shouldn't be happening, ever.");
		}
	}
}
 