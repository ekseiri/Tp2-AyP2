package estructuras;

import java.util.NoSuchElementException;

//
public class ListaIterator implements ListIteratorInterface {
	ListNode<?> actual = null;
	ListNode top = null;

	public ListaIterator(ListNode actual, int position)
			throws NoSuchElementException {
		this.top = actual;
		this.actual = actual;
		if (position != 0) {
			for (int i = 1; i < position; i++) {
				if (actual.next == null) {
					throw new NoSuchElementException(
							"Posicion mayor al numero de elementos");
				}
				this.actual = this.actual.next;
			}
		}

	}

	public void next() {
		actual = actual.next;

	}

	public void first() {
		this.actual = this.top;

	}

	public Object getElement() {

		return this.actual;
	}

	public boolean hasNext() {
		return actual.next != null;
	}

	public void insert(Object element) throws NoSuchElementException {
		ListNode nuevo = new ListNode(element);
		nuevo.next = actual.next;
		actual.next = nuevo;

	}

	public void delete(Object element) throws NoSuchElementException {
		if (element == null) {
			throw new NoSuchElementException("No hay elemento");

		}

	}

}
