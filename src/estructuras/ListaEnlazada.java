package estructuras;

import java.util.NoSuchElementException;

public class ListaEnlazada implements ListInterface<Object> {

	ListNode<?> top = null;
	ListNode<?> back = null;
	private long length = 0;

	public ListaEnlazada() {

	}

	public boolean isEmpty() {
		return top == null;
	}

	public void insert(Object element) throws NoSuchElementException {
		if (element == null) {
			throw new NoSuchElementException("Elemento a insertar nulo");
		}
		ListNode actual = new ListNode(element);
		if (top == null) {
			top = actual;
			back = actual;
		} else {
			actual.next = top;
			top = actual;
		}
		length++;
	}

	public void delete(Object element) throws NoSuchElementException {
		top = top.next;
		length--;
	}

	public ListIteratorInterface iterator(int posicion) {
		return new ListaIterator(top, posicion);
	}

	@Override
	public boolean buscar(Object element) {
		ListNode aux = top;
		boolean encontrado = false;
		boolean hayElementos;
		hayElementos = (top != null);

		while (!encontrado && hayElementos) {
			encontrado = (compare(aux.element, element));
			hayElementos = (aux.next != null);
			aux = aux.next;
		}

		return encontrado;
	}

	public void removeAll() {
		top = null;
		back = null;
		length = 0;
	}

	public long getSize() {
		return this.length;
	}

	private boolean compare(Object element, Object element2) {
		if (element == null || element2 == null) {
			return false;
		}
		if (((String) element).compareTo((String) element2) == 0) {
			return true;
		} else {
			return false;
		}
	}

}
