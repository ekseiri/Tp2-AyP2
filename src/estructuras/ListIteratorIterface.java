package estructuras;

import java.util.NoSuchElementException;


public interface ListIteratorIterface<T> {
	/**
	 * Avanza
	 */
	public void next();
	
	/**
	 * Coloca actual en el primer elemento
	 */
	public void first();
	
	/**
	 * Devuelve el elemento actual
	 */
	public T getElement();
	
	/***
	 * devuelve true si está en una posición válida
	 * @return
	 */
	public boolean hasNext();
	
	/**
	 * Inserta element despues de la posición actual
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
	
}
