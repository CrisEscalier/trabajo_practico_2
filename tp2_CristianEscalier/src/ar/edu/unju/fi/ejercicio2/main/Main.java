package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Efemeride> listaDeEfemerides = new ArrayList<>();
		int opcion;

		do {
			menu();
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				opcion = 0;
				System.out.println("Ingrese un numero entero\n");
			}

			switch (opcion) {
			case 0:
				sc.next();
				break;
			case 1:
				crearEfemeride(listaDeEfemerides, sc);
				break;
			case 2:
				mostrarEfemerides(listaDeEfemerides);
				break;
			case 3:
				eliminarEfemeride(listaDeEfemerides, sc);
				break;
			case 4:
				modificarEfemeride(listaDeEfemerides, sc);
				break;
			case 5:
				salir();
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion != 5);

		sc.close();

	}

	public static void menu() {
		System.out.println("**** MENU DE OPCIONES ****");
		System.out.println("1) Crear Efemeride");
		System.out.println("2) Mostrar Efemeride");
		System.out.println("3) Eliminar Efemeride");
		System.out.println("4) Modificar Efemeride");
		System.out.println("5) Salir");
		System.out.println("Eliga una opcion: ");
	}

	// OPCCION 1
	public static void crearEfemeride(ArrayList<Efemeride> lista, Scanner sc) {
		try {
			int numeroDeMes, dia;
			int codigo = generarCodigoAleatorio();
			System.out.println("Codigo autogenerado: " + codigo);
			do {
				System.out.println("Ingrese del 1 al 12 para elegir un mes: ");
				numeroDeMes = sc.nextInt();
				System.out.println("Ingrese el dia del mes: ");
				dia = sc.nextInt();
				if (validarIngreso(numeroDeMes, dia) == false) {
					System.out.println("Fecha invalida, el dia no se corresponde con el mes");
				}
			} while (!validarIngreso(numeroDeMes, dia));
			Mes mes = obtenerMes(numeroDeMes);
			System.out.println("Ingrese el detalle de la efemeride: ");
			sc.nextLine();
			String detalle = sc.nextLine();
			Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
			lista.add(efemeride);
			System.out.println("Efemeride creada con exito!");
		} catch (Exception e) {
			sc.next();
			System.out.println("Error al ingresar los datos de la efemeride!");
		}
	}

	/**
	 * Metodo que genera un codigo entero aleatorio
	 * 
	 * @return el numero generado aleatoriamente
	 */
	public static int generarCodigoAleatorio() {
		Random rand = new Random();
		return rand.nextInt(99999) + 1;
	}

	/**
	 * Metodo que determina si un dia corresponde con un mes dado
	 * 
	 * @param mes
	 * @param dia
	 * @return true si el mes y el dia se corresponden o falso si se ingresa un mes
	 *         invalido o si el dia supera la cantidad de dias de un mes
	 */
	public static boolean validarIngreso(int mes, int dia) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			return dia >= 1 && dia <= 31;
		} else if (mes == 2) {
			return dia >= 1 && dia <= 28;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return dia >= 1 && dia <= 30;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que devuelve el mes segun el numero de mes ignresado
	 * 
	 * @param n numero del mes
	 * @return el mes del año
	 */
	public static Mes obtenerMes(int n) {
		switch (n) {
		case 1:
			return Mes.ENERO;
		case 2:
			return Mes.FEBRERO;
		case 3:
			return Mes.MARZO;
		case 4:
			return Mes.ABRIL;
		case 5:
			return Mes.MAYO;
		case 6:
			return Mes.JUNIO;
		case 7:
			return Mes.JULIO;
		case 8:
			return Mes.AGOSTO;
		case 9:
			return Mes.SEPTIEMBRE;
		case 10:
			return Mes.OCTUBRE;
		case 11:
			return Mes.NOVIEMBRE;
		case 12:
			return Mes.DICIEMBRE;
		default:
			return null;
		}
	}

	// OPCION 2
	public static void mostrarEfemerides(ArrayList<Efemeride> lista) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia");
		} else {
			for (Efemeride efemeride : lista) {
				System.out.println(efemeride.mostrarDatos());
			}
		}
	}

	// OPCION 3
	public static void eliminarEfemeride(ArrayList<Efemeride> lista, Scanner sc) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia\n");
		} else {
			try {
				System.out.println("Ingrese el codigo de la efemeride a eliminar: ");
				int codigo = sc.nextInt();
				int indice = buscarEfemeridePorCodigo(lista, codigo);
				if (indice == -1) {
					System.out.println("Elemento no encontrado\n");
				} else {
					System.out.println("Elemento eliminado exitosamente!\n");
					lista.remove(indice);
				}
			} catch (Exception e) {
				sc.next();
				System.out.println("Debe ingresar un numero entero!\n");
			}
		}
	}

	/**
	 * Metodo que busca una efemeride por el codigo
	 * 
	 * @param lista  de las efemerides
	 * @param codigo para comparar con los elementos de la lista
	 * @return el indice en donde se encuentra el elemento, devuelve -1 si el
	 *         elemento no existe
	 */
	public static int buscarEfemeridePorCodigo(ArrayList<Efemeride> lista, int codigo) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
	}

	// OPCION 4
	public static void modificarEfemeride(ArrayList<Efemeride> lista, Scanner sc) {
		try {
			System.out.println("Ingrese el codigo de la Efemeride a modificar: ");
			int codigo = sc.nextInt();
			int indice = buscarEfemeridePorCodigo(lista, codigo);
			if (indice == -1) {
				System.out.println("Codigo de efemeride inexistente!\n");
			} else {
				Efemeride efemeride = lista.get(indice);
				int nuevoMes, nuevoDia;
				do {
					System.out.println("Ingrese del 1 al 12 para elegir un nuevo mes: ");
					nuevoMes = sc.nextInt();
					System.out.println("Ingrese el nuevo dia: ");
					nuevoDia = sc.nextInt();
					if (validarIngreso(nuevoMes, nuevoDia) == false) {
						System.out.println("Fecha invalida, el dia no se corresponde con el mes\n");
					}
				} while (!validarIngreso(nuevoMes, nuevoDia));
				Mes mes = obtenerMes(nuevoMes);
				System.out.println("Ingrese el nuevo detalle de la efemeride: ");
				sc.nextLine();
				String nuevoDetalle = sc.nextLine();
				efemeride.setMes(mes);
				efemeride.setDia(nuevoDia);
				efemeride.setDetalle(nuevoDetalle);
				System.out.println("Modificacion exitosa!\n");
			}
		} catch (Exception e) {
			sc.next();
			System.out.println("Ingreso invalido de datos!");
		}
	}

	// OPCION 5
	public static void salir() {
		System.out.println("Saliendo del programa...");
	}

}
