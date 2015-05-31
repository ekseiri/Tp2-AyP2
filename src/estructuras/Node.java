package estructuras;

/**
 * Nodo generico base
 *
 * @param <Cliente>
 */
public abstract class Node<T> {
	public Object element;
	
	public Node() {
		element = null;
	}
	public Node (T element) {
		this.element = element;
	}

	
}
