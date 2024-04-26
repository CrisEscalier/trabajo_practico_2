package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.model.Provincia;

public class Main {

	public static void main(String[] args) {

		Provincia[] provincias = Provincia.values();

		for (Provincia provincia : provincias) {
			System.out.println("Provincia: " + formatearNombre(provincia.name()));
			System.out.println("Cantidad de población: " + provincia.getCantidadPoblacion());
			System.out.println("Superficie: " + provincia.getSuperficie() + " km2");
			System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional() + "\n");
		}

	}

	/**
	 * Metodo que formatea el nombre de una provincia y las separa por cada guion
	 * bajo que encuentra
	 * 
	 * @param nombre del enumerado de la provincia
	 * @return nombre formateado sin espacios en blanco alrededor del nombre
	 */
	public static String formatearNombre(String nombre) {
		String[] palabras = nombre.split("_");
		String nombreFormateado = "";

		for (String palabra : palabras) {
			nombreFormateado += Character.toUpperCase(palabra.charAt(0)) + palabra.substring(1).toLowerCase() + " ";
		}

		return nombreFormateado.trim();
	}

}
