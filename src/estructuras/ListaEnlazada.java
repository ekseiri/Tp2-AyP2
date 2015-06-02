package estructuras;

import java.util.NoSuchElementException;

public class ListaEnlazada implements ListInterface<Object> {

	private ListNode<?> top;
	private ListNode<?> back;
	private long length;

	public ListaEnlazada() {
		top = null;
		back = null;
		length = 0;
	}

	public ListNode getTop(){
		return top;
	}
	
	public ListNode getBack(){
		return back;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}

	public void insert(Object element) throws NullPointerException {
		if (element == null) {
			throw new NullPointerException("Elemento a insertar nulo");
		}
		ListNode actual = new ListNode(element);
		if (isEmpty()) {
			top = actual;
			back = actual;
		} else {
			back.next = actual;
			back = actual;
		}
		length++;
	}

	public void delete(Object element) throws NoSuchElementException {
		ListNode aux = top;
		boolean encontrado = false;
		boolean hayElementos;
		
		hayElementos = (!isEmpty());
		encontrado = (compare(aux.element, element));
		
		while (!encontrado && hayElementos) {
			encontrado = (compare(aux.next.element, element));
			hayElementos = (aux.next != null);
			if(!encontrado){aux = aux.next;}
		}
		if (encontrado) {
			aux.next = aux.next.next;
		}else{
			throw new NoSuchElementException("No se encontro el elemento a borrar");
		}
		length--;
	}

	public ListaIterator iterator(long posicion) {
		return new ListaIterator(top, posicion);
	}
	public ListaIterator iterator(){
		return new ListaIterator(top);
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
