package estructuras;

import java.util.NoSuchElementException;

public class ListaEnlazada implements ListInterface {

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
		// TODO Auto-generated method stub
		return false;
	}

	public void removeAll() {
		top = null;
		back = null;
		length=0;
	}


}
