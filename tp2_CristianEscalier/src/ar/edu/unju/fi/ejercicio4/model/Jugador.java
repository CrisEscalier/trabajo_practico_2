package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {

	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private Posicion posicion;

	public Jugador(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, double estatura,
			double peso, int posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = obtenerPosicion(posicion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * Metodo que permite obtener una poscicion segun un numero
	 * 
	 * @param opcion para determinar una posicion
	 * @return la posicion deseada
	 */
	public Posicion obtenerPosicion(int opcion) {
		switch (opcion) {
		case 1:
			return Posicion.DELANTERO;
		case 2:
			return Posicion.MEDIO;
		case 3:
			return Posicion.DEFENSA;
		case 4:
			return Posicion.ARQUERO;
		default:
			return null;
		}
	}

	/**
	 * Metodo que calcula de la edad de un jugador Resta los años, luego los meses y
	 * por ultimo los dias de la fecha de nacimiento del jugador
	 * 
	 * @param fecha de nacimiento del jugador
	 * @return la edad del jugador
	 */
	public int calcularEdad(LocalDate fecha) {
		LocalDate fechaActual = LocalDate.now();

		return fechaActual.minusYears(fecha.getYear()).minusMonths(fecha.getMonthValue())
				.minusDays(fecha.getDayOfMonth()).getYear();
	}

}
