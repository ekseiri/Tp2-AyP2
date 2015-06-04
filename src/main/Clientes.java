package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import estructuras.AVLTree;
import estructuras.BinaryNode;
import estructuras.ListNode;
import estructuras.ListaEnlazada;
import estructuras.ListaIterator;

public class Clientes {
	private AVLTree<Cliente> clientes = null;
	private int maxVisitas = 0;
	private ListaEnlazada<Cliente>[] ordenFrecuencia;
	private ListaEnlazada<ListaEnlazada<String>> diasConDescuento = new ListaEnlazada<ListaEnlazada<String>>();
	private String diaUltimaOperacion;
	
	/**
	 * 
	 */
	public Clientes(String archivoDePatentes){
		regenClients(archivoDePatentes);
	}
	
	public void regenClients(String archivoDePatentes) {
		BufferedReader file = null; 
		String linea[] = null;
		clientes = new AVLTree<Cliente>();
		
		try {
			file = new BufferedReader(new FileReader(archivoDePatentes));
			linea = file.readLine().split(",");
		} catch (IOException|NullPointerException e) {
			if (e instanceof NullPointerException){
				System.out.println("Archivo vacio");
				e.printStackTrace();
			} else {
				e.printStackTrace();
			}
		}
		
		while (linea != null) {
			this.addVisita(linea[0], linea[1]);
			
			try {
				String line = file.readLine();
				if (line != null) {
					linea = line.split(",");
				} else
					linea = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void printOrdenAlfabetico() {
		this.clientes.printInOrder();
	}
	
	private void generarOrdenPorFrecuencia() {
		this.generarOrdenPorFrecuencia(this.clientes.getRoot());
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
		this.generarOrdenPorFrecuencia();
		
		for (int i = 0; i < ordenFrecuencia.length; i++) {
			ListaIterator<Cliente> iter = ordenFrecuencia[i].iterator();
			
			while (iter.hasNext()) {
				System.out.println(iter.getElement().toString());
				iter.next();
			}
		}
	}
	
	public void printDescuentosPorDia() {
		ListaIterator<ListaEnlazada<String>> outerIter = this.diasConDescuento.iterator();
		ListaIterator<String> innerIter = null;
		
		while (outerIter.hasNext()) {
			innerIter = outerIter.getElement().iterator();
			
			while (innerIter.hasNext()) {
				System.out.println(innerIter.getElement());
				innerIter.next();
			}
		
			outerIter.next();
		}
	}
	
	
	
	public void addVisita(String patente, String fecha) {
		
		Cliente visitante = new Cliente(patente, fecha);
				
		if (!clientes.contains(visitante)) {
			clientes.insert(visitante);
		} else {
			visitante = clientes.buscar(visitante).getElement();
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
	
}
