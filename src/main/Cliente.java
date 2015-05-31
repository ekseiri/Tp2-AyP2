package main;

public class Cliente {
	private String patente;
	private String[] ultimaVisita;
	private int cantidadVisitas;
	private boolean descuento;
	
	public Cliente(String patente, String fecha) throws IllegalArgumentException{
		if ((patente == null) || (fecha == null))
			throw new IllegalArgumentException("Patente y/o fecha no pueden ser nulos");
		else if (!patente.matches("[A-Z]{3}[0-9]{3}"))
			throw new IllegalArgumentException("Patente Inválida");
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
		return ultimaVisita;
	}

	/**
	 * @param ultimaVisita the ultimaVisita to set
	 */
	private void setUltimaVisita(String fecha) {
		if (!fecha.matches("[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}"))
			throw new IllegalArgumentException("Fecha Inválida");
		else
			this.ultimaVisita = fecha.split("-");
	}

	/**
	 * @return the cantidadVisitas
	 */
	public int getCantidadVisitas() {
		return cantidadVisitas;
	}

	public void addVisita(String fecha) {
		this.setUltimaVisita(fecha);
		this.cantidadVisitas++;
		this.setDescuento();
	}

	/**
	 * @return descuento
	 */
	public boolean isDescuento() {
		return descuento;
	}

	/**
	 * 
	 */
	private void setDescuento() {
		this.descuento = (this.cantidadVisitas % 2 == 0) ? false : true;
			
	}
	
}
