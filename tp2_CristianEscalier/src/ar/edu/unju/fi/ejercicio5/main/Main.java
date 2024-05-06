package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.origenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		/*
		 * PagoTarjeta pago1 = new PagoTarjeta("123-12312-321", LocalDate.now());
		 * PagoEfectivo pago2 = new PagoEfectivo(LocalDate.now());
		 * 
		 * pago1.realizarPago(1000.0); pago1.imprimirRecibo();
		 * 
		 * pago2.realizarPago(1000.0); pago2.imprimirRecibo();
		 */
		Scanner sc = new Scanner(System.in);

		ArrayList<Producto> listaDeProductos = generarListaDeProductos();
		ArrayList<Producto> listaDeCompras = new ArrayList<>();

		int opcion;

		do {
			menu();
			try {
				opcion = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				opcion = 0;
				mensajeDeError();
			}

			switch (opcion) {
			case 0:
				sc.nextLine();
				break;
			case 1:
				mostrarProductosCompletos(listaDeProductos);
				break;
			case 2:
				listaDeCompras = realizarCompras(listaDeProductos, sc);
				if (listaDeCompras.isEmpty()) {
					System.out.println("Debe ingresar productos a la lista de Compras!\n");
				} else {
					pasarPorCaja(listaDeCompras, sc);
				}
				break;
			case 3:
				salir();
				break;
			default:
				System.out.println("Opcion invalida!");
			}
		} while (opcion != 3);

		sc.close();
	}

	public static void menu() {
		System.out.println("**** MENU DE OPCIONES ****");
		System.out.println("1) Mostrar Productos");
		System.out.println("2) Realizar Compra");
		System.out.println("3) Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static ArrayList<Producto> generarListaDeProductos() {
		ArrayList<Producto> productos = new ArrayList<>();
		// (codigo,descripcion,precio unitario, origen,categoria, stock);
		Producto producto1 = new Producto(generarCodigoAleatorio(), "Parlante Bluetooth 5.1", 15_000.45,
				origenFabricacion.ARGENTINA, categoria.ELECTROHOGAR, true);
		Producto producto2 = new Producto(generarCodigoAleatorio(), "Lampara led 4 colores", 20_250.78,
				origenFabricacion.CHINA, categoria.ELECTROHOGAR, true);
		Producto producto3 = new Producto(generarCodigoAleatorio(), "Telefono Samsung A23", 155_471.95,
				origenFabricacion.CHINA, categoria.INFORMATICA, false);
		Producto producto4 = new Producto(generarCodigoAleatorio(), "Set de herramientas HILTI", 251_123.09,
				origenFabricacion.ARGENTINA, categoria.HERRAMIENTAS, true);
		Producto producto5 = new Producto(generarCodigoAleatorio(),
				"Escritorio de Pie 90 centimetros de ancho y 1.25 metros de largo", 15_000.45, origenFabricacion.BRASIL,
				categoria.INFORMATICA, true);
		Producto producto6 = new Producto(generarCodigoAleatorio(), "Servicio Claro Brasil mensual", 19_139.826,
				origenFabricacion.BRASIL, categoria.TELEFONIA, true);
		Producto producto7 = new Producto(generarCodigoAleatorio(), "Frigorífico Electrolux Frost Free 380L",
				1_420_508.03, origenFabricacion.BRASIL, categoria.ELECTROHOGAR, true);
		Producto producto8 = new Producto(generarCodigoAleatorio(), "Servicio de telefonia ANTEL", 39_265.82,
				origenFabricacion.URUGUAY, categoria.TELEFONIA, true);
		Producto producto9 = new Producto(generarCodigoAleatorio(), "Heladera Samsung Side by Side", 1_298_680.46,
				origenFabricacion.URUGUAY, categoria.ELECTROHOGAR, true);
		Producto producto10 = new Producto(generarCodigoAleatorio(), "Lavadora automática Samsung de carga frontal",
				603_780.06, origenFabricacion.URUGUAY, categoria.ELECTROHOGAR, true);
		Producto producto11 = new Producto(generarCodigoAleatorio(), "Mouse inalambrico recargable RedDragon",
				18_990.23, origenFabricacion.CHINA, categoria.INFORMATICA, false);
		Producto producto12 = new Producto(generarCodigoAleatorio(), "Set Inalambrico recargable", 47_045.96,
				origenFabricacion.CHINA, categoria.INFORMATICA, true);
		Producto producto13 = new Producto(generarCodigoAleatorio(), "Escalera expandible hasta 5 metros", 68_720.05,
				origenFabricacion.ARGENTINA, categoria.HERRAMIENTAS, true);
		Producto producto14 = new Producto(generarCodigoAleatorio(), "Pava electrica PHILIP", 85_511.95,
				origenFabricacion.ARGENTINA, categoria.ELECTROHOGAR, false);
		Producto producto15 = new Producto(generarCodigoAleatorio(), "Estufa Electrica PHILIP", 240_078.45,
				origenFabricacion.ARGENTINA, categoria.ELECTROHOGAR, false);
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		productos.add(producto6);
		productos.add(producto7);
		productos.add(producto8);
		productos.add(producto9);
		productos.add(producto10);
		productos.add(producto11);
		productos.add(producto12);
		productos.add(producto13);
		productos.add(producto14);
		productos.add(producto15);
		return productos;
	}

	// OPCION 1
	public static void mostrarProductosCompletos(ArrayList<Producto> lista) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia");
		}
		for (Producto producto : lista) {
			System.out.println(producto.mostrarDatosProducto());
		}
	}

	public static void mostrarProductos(ArrayList<Producto> lista) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia");
		}
		for (Producto producto : lista) {
			System.out
					.println("Codigo: " + producto.getCodigo() + " \nDescricpion: " + producto.getDescripcion() + "\n");
		}
	}

	/**
	 * Metodo que genera un numero aleatorio entre 1 y 99999
	 * 
	 * @return el numero aleatorio generado
	 */
	public static int generarCodigoAleatorio() {
		Random rand = new Random();
		return rand.nextInt(99999) + 1;
	}

	// OPCION 2
	public static ArrayList<Producto> realizarCompras(ArrayList<Producto> listaProductos, Scanner sc) {
		ArrayList<Producto> listaDeCompras = new ArrayList<>();
		String respuesta = "";
		mostrarProductos(listaProductos);
		do {
			try {
				System.out.print("Ingrese el codigo del producto que desea comprar: ");
				int codigoProducto = sc.nextInt();
				sc.nextLine();
				int indice = buscarProducto(listaProductos, codigoProducto);
				if (indice == -1) {
					System.out.println("Producto ingresado inexistente!\n");
				} else {
					Producto producto = listaProductos.get(indice);
					if (producto.isEstado() == true) {
						listaDeCompras.add(producto);
						System.out.println("Producto añadido a la lista de compras exitosamente!!!\n");
					} else {
						System.out.println("Producto sin stock!!!\n");
					}
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar un numero entero!\n");
			} finally {
				System.out.println("Desea ingresar mas productos? si/no");
				respuesta = sc.next();
			}
		} while (respuesta.equalsIgnoreCase("si"));
		return listaDeCompras;
	}

	public static void pasarPorCaja(ArrayList<Producto> listaCompras, Scanner sc) {
		int opcion;
		do {
			try {
				menuDePago();
				opcion = sc.nextInt();
				sc.nextLine();
				if (opcion == 1) {
					System.out.println("Ingrese los numeros de su tarjeta XXXX-XXXX-XXXX-XXXX: ");
					String tarjeta = sc.next();
					PagoTarjeta pagoConTarjeta = new PagoTarjeta(tarjeta, LocalDate.now());
					pagoConTarjeta.realizarPago(sumatoria(listaCompras));
					pagoConTarjeta.imprimirRecibo();
				} else if (opcion == 2) {
					PagoEfectivo pagoConEfectivo = new PagoEfectivo(LocalDate.now());
					pagoConEfectivo.realizarPago(sumatoria(listaCompras));
					pagoConEfectivo.imprimirRecibo();
				} else {
					System.out.println("Opcion incorrecta!!!\n");
				}
			} catch (Exception e) {
				opcion = 0;
				mensajeDeError();
				sc.nextLine();
			}
		} while (opcion != 1 && opcion != 2);

	}

	public static double sumatoria(ArrayList<Producto> lista) {
		double total = 0;
		for (Producto producto : lista) {
			total += producto.getPrecioUnitario();
		}
		return total;
	}

	public static void mensajeDeError() {
		System.out.println("Debe ingresar un numero entero!!!\n");
	}

	public static void menuDePago() {
		System.out.println("Metodos de pago disponibles: ");
		System.out.println("1- Pagar con Tarjeta");
		System.out.println("2- Pagar con Efectivo ");
		System.out.println("Eliga una opcion: ");
	}

	public static int buscarProducto(ArrayList<Producto> lista, int codigo) {
		for (Producto producto : lista) {
			if (producto.getCodigo() == codigo) {
				return lista.indexOf(producto);
			}
		}
		return -1;
	}

	// OPCION 3
	public static void salir() {
		System.out.println("Saliendo del programa...");
	}

}
