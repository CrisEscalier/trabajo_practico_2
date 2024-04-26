package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Jugador> listaDeJugadores = new ArrayList<>();

		int opcion;

		do {
			menu();
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				sc.next();
				opcion = 0;
				System.out.println("Debe ingresar un numero entero!\n");
			}
			switch (opcion) {
			case 0:
				break;
			case 1:
				darAltaJugador(listaDeJugadores, sc);
				break;
			case 2:
				mostrarJugadores(listaDeJugadores);
				break;
			case 3:
				modificarPosicion(listaDeJugadores, sc);
				break;
			case 4:
				eliminarJugador(listaDeJugadores,sc);
				break;
			case 5:
				salir();
				break;
			default:
				System.out.println("Opcion invalida!\n");
			}
		} while (opcion != 5);

	}

	static void menu() {
		System.out.println("***** MENU DE OPCIONES *****");
		System.out.println("1- Dar de alta un jugador");
		System.out.println("2- Mostrar todos los jugadores");
		System.out.println("3- Modificar la posicion de un jugador");
		System.out.println("4- Eliminar un jugador");
		System.out.println("5- Salir del programa");
		System.out.println("Eliga una opcion: ");
	}

	// OPCION 1

	public static void darAltaJugador(ArrayList<Jugador> lista, Scanner sc) {
		try {
			System.out.println("Ingrese los datos del jugador:");
			System.out.print("Nombre: ");
			String nombre = sc.next();
			System.out.print("Apellido: ");
			String apellido = sc.next();
			System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
			sc.nextLine();
			LocalDate fechaNacimiento = LocalDate.parse(sc.next());
			System.out.print("Nacionalidad: ");
			String nacionalidad = sc.next();
			try {
				System.out.print("Estatura: ");
				double estatura = sc.nextDouble();
				System.out.print("Peso: ");
				double peso = sc.nextDouble();
				System.out.print("Eliga la posicion del 1 al 4 (delantero, medio, defensa, arquero): ");
				int posicion = sc.nextInt();
				Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso,
						posicion);
				if (jugador.getPosicion() != null) {
					System.out.println("Jugador agregado con éxito!\n");
					lista.add(jugador);
				} else {
					System.out.println("Posicion inexistente!\n");
				}
			} catch (Exception e) {
				sc.next();
				System.out.println("Ingreso de datos invalido!\n");
			}

		} catch (Exception e) {
			System.out.println("Ingreso de datos invalido!\n");
		}
	}

	// OPCION 2

	public static void mostrarJugadores(ArrayList<Jugador> lista) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia!\n");
		}
		for (Jugador jugador : lista) {
			System.out.println(jugador.mostrarDatos());
		}
	}

	// OPCION 3

	public static void modificarPosicion(ArrayList<Jugador> lista, Scanner sc) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia!\n");
		} else {
			try {

				System.out.println("Ingrese los siguientes datos del jugador a modificar: ");
				System.out.print("Nombre: ");
				String nombre = sc.next();
				System.out.print("Apellido: ");
				String apellido = sc.next();

				int indice = buscarJugador(lista, nombre, apellido);
				if (indice == -1) {
					System.out.println("Jugador inexistente!\n");
				} else {
					Jugador jugador = lista.get(indice);
					System.out.println("Ingrese la nueva posicion del 1 al 4 (delantero, medio, defensa, arquero):");
					int nuevaPosicion = sc.nextInt();
					Posicion posicion = jugador.obtenerPosicion(nuevaPosicion);
					if (posicion != null) {
						jugador.setPosicion(posicion);
						System.out.println("Modificacion exitosa!\n");
					} else {
						System.out.println("Posicion inexistente!\n");
					}
				}

			} catch (Exception e) {
				sc.next();
				System.out.println("Ingreso invalido de datos");
			}
		}

	}

	public static int buscarJugador(ArrayList<Jugador> lista, String nombre, String apellido) {
		for (Jugador jugador : lista) {
			if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				return lista.indexOf(jugador);
			}
		}
		return -1;
	}

	// OPCION 4

	public static void eliminarJugador(ArrayList<Jugador> lista, Scanner sc) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia!\n");
		} else {
			System.out.println("Ingrese los siguientes datos del jugador a eliminar: ");
			System.out.print("Nombre: ");
			String nombre = sc.next();
			System.out.print("Apellido: ");
			String apellido = sc.next();

			Iterator<Jugador> iterador = lista.iterator();
			while (iterador.hasNext()) {
				Jugador jugador = iterador.next();
				if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
					iterador.remove();
					System.out.println("El jugador " + nombre + " " + apellido + " ha sido eliminado.\n");
					break;
				}
			}
		}
	}

	// OPCION 5
	
	public static void salir() {
		System.out.println("Saliendo del programa...");
	}

}
