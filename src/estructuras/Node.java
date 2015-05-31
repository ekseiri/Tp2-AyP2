package estructuras;

/**
 * Nodo generico base
 *
 * @param <Cliente>
 */
public abstract class Node<Cliente> {
	public Cliente element;
	
	public Node() {
		element = null;
	}
	
	public Node (Cliente element) {
		this.element = element;
	}

}
