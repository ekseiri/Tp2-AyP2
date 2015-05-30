package estructuras;

import java.util.NoSuchElementException;


public interface ListInterface<T> {
	
	public boolean isEmpty();
	
	/**
	 * Inserta al final
	 * @param element
	 * @throws NoSuchElementException
	 */
	public void insert(T element) throws NoSuchElementException;
	
	
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
	public ListIteratorIterface iterator();
	
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