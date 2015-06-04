package main;

import estructuras.AVLTree;
import estructuras.BinaryNode;
import estructuras.ListaEnlazada;
import estructuras.ListaIterator;

public class Clientes {
	private AVLTree<Cliente> clientes = new AVLTree<Cliente>();
	private int maxVisitas = 0;
	private ListaEnlazada<Cliente>[] ordenFrecuencia;
	private ListaEnlazada<ListaEnlazada<String>> diasConDescuento = new ListaEnlazada<ListaEnlazada<String>>();
	private String diaUltimaOperacion;
	
	public Clientes(){
		
	}
	
	private void generarOrdenPorFrecuencia(BinaryNode<Cliente> localRoot) {
		ordenFrecuencia = new ListaEnlazada[maxVisitas];
		
		if (localRoot != null){
			localRoot.getLeftChild();
			ordenFrecuencia[localRoot.getElement().getCantidadVisitas()].insert(localRoot.getElement());
			localRoot.getRightChild();
		}
	}
	
	public void printOrdenPorFrecuencia() {
		for (int i = 0; i < ordenFrecuencia.length; i++) {
			ListaIterator<Cliente> iter = ordenFrecuencia[i].iterator();
			
			while (iter.hasNext()) {
				System.out.println(iter.getElement().toString());
				iter.next();
			}
		}
	}
	
	public void addVisita(String patente, String fecha) {
		Cliente visitante = clientes.contains(new Cliente(patente, fecha)).getElement();
		
		if (visitante == null) {
			clientes.insert(new Cliente(patente, fecha));
		} 
		
		if (visitante.isDescuento(fecha)) {
			if (diaUltimaOperacion != fecha.split("-")[0]) {
				this.diasConDescuento.insert(new ListaEnlazada<String>());
				this.diasConDescuento.getBack().element.insert(fecha);
				this.diasConDescuento.getBack().element.insert(patente);
			} else {
				this.diasConDescuento.getBack().element.insert(patente);
			}
		}
		
		visitante.addVisita(fecha);
	}
	
}
