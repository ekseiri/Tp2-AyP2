package estructuras;

import java.util.NoSuchElementException;

/**
 * Interface de Lista 
 *
 */
public interface ListInterface<T> {
	
	public boolean isEmpty();
	
	/**
	 * Inserta al final
	 * @param element
	 * @throws NullPointerException
	 */
	public void insert(T element) throws NullPointerException;
	
	
	/**
	 * Elimina x
	 * @param element
	 * @throws NoSuchElementException
	 */
	public void delete(T element) throws NoSuchElementException;
	
	/**
	 * devuelve un iterador, para la lista
	 * @return
	 */
	public ListIteratorInterface<T> iterator(long posicion);
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	boolean buscar(T element);
	
	/**
	 * vacia la lista
	 */
	public void removeAll();
	

}
