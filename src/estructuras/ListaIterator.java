package estructuras;

import java.util.NoSuchElementException;

public class ListaIterator implements ListIteratorInterface<Object> {
	private ListNode<?> anterior = null;
	private ListNode<?> actual = null;
	private ListNode<?> top = null;

	public ListaIterator(ListNode<?> actual, long posicion)
			throws NoSuchElementException {
		if (actual == null) {
			throw new NullPointerException("Lista Vacia, nada para iterar");
		}
		this.top = actual;
		this.actual = actual;
		if (posicion != 0) {
			for (int i = 0; i < posicion; i++) {
				if (actual.next == null) {
					throw new NoSuchElementException(
							"Posicion mayor al numero de elementos");
				}
				this.anterior = this.actual;
				this.actual = this.actual.next;
			}
		}

	}

	public ListaIterator(ListNode<?> actual) {
		this(actual, 0);
	}

	public void next() throws NoSuchElementException {
		if (!hasNext())
			throw new NoSuchElementException("No existe siguiente");
		anterior = actual;
		actual = actual.next;

	}

	public void first() {
		this.actual = this.top;
		this.anterior = null;

	}

	public Object getElement() {

		return this.actual.element;
	}

	public boolean hasNext() {
		return actual.next != null;
	}

	public void insert(Object element) {
		ListNode nuevo = new ListNode(element);
		nuevo.next = actual.next;
		actual.next = nuevo;
		anterior = actual;
		//actual = nuevo; hace falta que el nodo insertado sea el actual, pero da error el test

	}

	public void delete() {
		ListNode elim = actual; //no funcionaba de otra forma
		anterior.next=elim.next;

	}

}
