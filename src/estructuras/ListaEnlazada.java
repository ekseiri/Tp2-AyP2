package estructuras;

import java.util.NoSuchElementException;

/**
 * Clase Lista Enlazada 
 *
 */
public class ListaEnlazada<T> implements ListInterface<T> {

	private ListNode<T> top;
	private ListNode<T> back;
	private long length;

	public ListaEnlazada() {
		top = null;
		back = null;
		length = 0;
	}

	public ListNode<T> getTop() {
		return top;
	}

	public ListNode<T> getBack() {
		return back;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void insert(T element) throws NullPointerException {
		if (element == null) {
			throw new NullPointerException("Elemento a insertar nulo");
		}
		ListNode<T> actual = new ListNode<T>(element);
		if (isEmpty()) {
			top = actual;
		} else {
			back.next = actual;
		}
		back = actual;
		length++;
	}

	public void delete(Object element) throws NoSuchElementException {
		ListNode<T> aux = top;
		boolean encontrado = false;
		boolean hayElementos;

		hayElementos = (!isEmpty());
		encontrado = aux.element.equals( element);

		while (!encontrado && hayElementos) {
			encontrado = aux.next.element.equals(element);
			hayElementos = (aux.next != null);
			if (!encontrado) {
				aux = aux.next;
			}
		}
		if (encontrado) {
			aux.next = aux.next.next;
		} else {
			throw new NoSuchElementException(
					"No se encontro el elemento a borrar");
		}
		length--;
	}

	public ListaIterator<T> iterator(long posicion) {
		return new ListaIterator<T>(top, posicion);
	}

	public ListaIterator<T> iterator() {
		return new ListaIterator<T>(top);
	}

	@Override
	public boolean buscar(Object element) {
		ListNode<T> aux = top;
		boolean encontrado = false;
		boolean hayElementos;
		hayElementos = (top != null);

		while (!encontrado && hayElementos) {
			encontrado = aux.element.equals(element);
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

}
