package estructuras;

import java.util.NoSuchElementException;
/**
 * Clase para iterar Lista Enlazada 
 *
 */
public class ListaIterator<T> implements ListIteratorInterface<T> {
	private ListNode<T> anterior = null;
	private ListNode<T> top = null;

	public ListaIterator(ListNode<T> actual) throws NoSuchElementException {
		this(actual, 0);
	}
	
	public ListaIterator(ListNode<T> first, long posicion) throws NullPointerException, NoSuchElementException {

		if (first == null) {
			throw new NullPointerException("Lista Vacia, nada para iterar");
		}

		this.top = first;
		if (posicion != 0) {
			for (int i = 0; i < posicion; i++) {
				if (actual().next == null) {
					throw new NoSuchElementException(
							"Posicion mayor al numero de elementos");
				}
				if (actual() != null) {
					if (anterior == null) {
						anterior = top;
					} else {
						anterior = anterior.next;
					}
				}
			}
		}

	}

	private ListNode<T> actual() {

		return anterior == null ? top : anterior.next;
	}

	public void next() throws NoSuchElementException {
		if (!hasNext())
			throw new NoSuchElementException("No existe siguiente");
		anterior = actual();

	}

	public void first() {
		this.anterior = null;
	}

	public T getElement() {

		return actual().element;
	}

	public boolean hasNext() {
		return actual().next != null;
	}

	public void insert(T element) {
		ListNode<T> nuevo = new ListNode<T>(element, actual().next);
		actual().next = nuevo;
	}

	public void delete() {
		anterior.next = actual().next;

	}

}
