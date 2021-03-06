package main;

import java.util.Arrays;

public class Cliente implements Comparable<Cliente> {
	private String patente;
	private String[] ultimaVisita;
	private int cantidadVisitas;
	private boolean descuento;
	
	public Cliente(String patente, String fecha) throws IllegalArgumentException{
		if ((patente == null) || (fecha == null))
			throw new IllegalArgumentException("Patente y/o fecha no pueden ser nulos");
		else if (!patente.matches("[A-Z]{3}[0-9]{3}"))
			throw new IllegalArgumentException("Patente Inv�lida");
		else if(!fecha.matches("[0-3]*[0-9]-(1[0-2]|0*[1-9])-2015"))
			throw new IllegalArgumentException("Fecha Inv�lida");
		else {
			this.setUltimaVisita(fecha);
			this.patente = patente;
						
			cantidadVisitas = 1;
			this.descuento = true;
		}
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @return the ultimaVisita
	 */
	public String[] getUltimaVisita() {
		return this.ultimaVisita;
	}
	
	public String getUltimaVisitaJoined() {
		return String.join("-", Arrays.asList(this.ultimaVisita));
	}

	/**
	 * @param ultimaVisita the ultimaVisita to set
	 */
	private void setUltimaVisita(String fecha) {
		if (!fecha.matches("[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}"))
			throw new IllegalArgumentException("Fecha Inv�lida");
		else
			this.ultimaVisita = fecha.split("-");
	}

	/**
	 * @return the cantidadVisitas
	 */
	public int getCantidadVisitas() {
		return this.cantidadVisitas;
	}

	public void addVisita(String fecha) {
		this.setUltimaVisita(fecha);
		this.cantidadVisitas++;
		this.setDescuento(fecha);
	}

	/**
	 * @return descuento
	 */
	public boolean isDescuento(String fecha) {
		if (!this.ultimaVisita[1].equals(fecha.split("-")[1]))
				descuento = false;
		
		return descuento;
	}

	/**
	 * 
	 */
	private void setDescuento(String fecha ) {
		this.descuento = !(descuento);		
	}
	
	public String toString() {
		return "Patente: " + this.getPatente() + " Ultima Visita: " + this.getUltimaVisitaJoined() + 
				" Cantidad de Visitas: " + this.getCantidadVisitas();
	}

	@Override
	public int compareTo(Cliente o) {
		return this.getPatente().compareTo(o.getPatente());
	}
	
	/*
	public boolean equals(Cliente o) {
		return this.getPatente().compareTo(o.getPatente()) == 0;
	}
	*/
}
