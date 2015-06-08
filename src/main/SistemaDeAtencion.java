package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import estructuras.AVLTree;
import estructuras.BinaryNode;
import estructuras.ListNode;
import estructuras.ListaEnlazada;
import estructuras.ListaIterator;

public class SistemaDeAtencion {
	private AVLTree<Cliente> clientes = null;
	private int maxVisitas = 0;
	private ListaEnlazada<Cliente>[] ordenFrecuencia = null;
	private ListaEnlazada<ListaEnlazada<String>> diasConDescuento = new ListaEnlazada<ListaEnlazada<String>>();
	private String diaUltimaOperacion = "";
	
	/**
	 * 
	 */
	public SistemaDeAtencion(String archivoDePatentes){
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
		if (ordenFrecuencia == null)
			ordenFrecuencia = new ListaEnlazada[maxVisitas];
		
		if (localRoot != null){
			generarOrdenPorFrecuencia(localRoot.getLeftChild());
			
			if (ordenFrecuencia[localRoot.getElement().getCantidadVisitas() - 1] == null)
				ordenFrecuencia[localRoot.getElement().getCantidadVisitas() - 1] = new ListaEnlazada<Cliente>();
			
			ordenFrecuencia[localRoot.getElement().getCantidadVisitas() - 1].insert(localRoot.getElement());
			
			generarOrdenPorFrecuencia(localRoot.getRightChild());
		}
	}
	
	
	/**
	 * Se imprime en orden de menor cantidad a mayor cantidad de visita.
	 */
	public void printOrdenPorFrecuencia() {
		this.generarOrdenPorFrecuencia();
		
		for (int i = 0; i < ordenFrecuencia.length; i++) {
			//En caso de que no existan clientes con X cantidad de visitas
			if (ordenFrecuencia[i] != null) {
				ListaIterator<Cliente> iter = null;
				
				
				iter = ordenFrecuencia[i].iterator();
				
				
				while (iter.hasNext()) {
					System.out.println(iter.getElement().toString());
					iter.next();
				}
			}
		}
	}
	
	public void printDescuentosPorDia() {
		ListaIterator<ListaEnlazada<String>> outerIter = this.diasConDescuento.iterator();
		ListaIterator<String> innerIter = outerIter.getElement().iterator();
		
		System.out.println(innerIter.getElement());
		while (innerIter.hasNext()) {
			innerIter.next();
			if (innerIter.hasNext())
				System.out.print(innerIter.getElement() + ", ");
			else
				System.out.println(innerIter.getElement());
		}
		
		while (outerIter.hasNext()) {
			outerIter.next();
			innerIter = outerIter.getElement().iterator();
			
			
			System.out.println(innerIter.getElement());
			while (innerIter.hasNext()) {
				innerIter.next();
				if (innerIter.hasNext())
					System.out.print(innerIter.getElement() + ", ");
				else
					System.out.println(innerIter.getElement());
			}
		}
	}
	
	
	
	public void addVisita(String patente, String fecha) {
		
		Cliente visitante = new Cliente(patente, fecha);
				
		if (!clientes.contains(visitante)) {
			clientes.insert(visitante);
		} else {
			visitante = clientes.buscar(visitante).getElement();
			if (visitante.isDescuento(fecha)) {
				if (!diaUltimaOperacion.equals(fecha.split("-")[0])) {
					this.diasConDescuento.insert(new ListaEnlazada<String>());
					this.diasConDescuento.getBack().element.insert(fecha);
					this.diasConDescuento.getBack().element.insert(patente);
				} else {
					this.diasConDescuento.getBack().element.insert(patente);
				}
				this.diaUltimaOperacion = fecha.split("-")[0];
			}
			visitante.addVisita(fecha);
		}
		
		if (visitante.getCantidadVisitas() > this.maxVisitas)
			this.maxVisitas = visitante.getCantidadVisitas();
	}
	
}
