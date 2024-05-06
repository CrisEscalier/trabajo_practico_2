package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.origenFabricacion;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Producto> listaDeProductos = generarListaDeProductos();
		int opcion;

		do {
			menu();
			try {
				opcion = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				opcion = 0;
				System.out.println("Debe ingresar un numero entero");
			}

			switch (opcion) {
			case 0:
				break;
			case 1:
				System.out.println("Productos disponibles: ");
				mostrarProductosDisponibles(listaDeProductos);
				break;
			case 2:
				mostrarProductosNoDisponibles(listaDeProductos);
				break;
			case 3:
				ArrayList<Producto> productosIncrementados = incrementarPrecios(listaDeProductos);
				if (!productosIncrementados.isEmpty()) {
					System.out.println("Aumento de precios aplicado correctamente\n");
				}
				mostrarLista(productosIncrementados);
				break;
			case 4:
				mostrarPorCategoria(listaDeProductos, categoria.ELECTROHOGAR);
				break;
			case 5:
				ordenarListaDescendente(listaDeProductos);
				break;
			case 6:
				productosEnMayusculas(listaDeProductos);
				break;
			case 7:
				salir();
				break;
			default:
				System.out.println("Opcion incorrecta!\n");
			}
		} while (opcion != 7);
		sc.close();
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
				"Escritorio de Pie 90 centimetros de ancho y 1.25 metros de largo", 135_000.45,
				origenFabricacion.BRASIL, categoria.INFORMATICA, true);
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

	/**
	 * Metodo que genera un numero aleatorio entre 1 y 99999
	 * 
	 * @return el numero aleatorio generado
	 */
	public static int generarCodigoAleatorio() {
		Random rand = new Random();
		return rand.nextInt(99999) + 1;
	}

	public static void menu() {
		System.out.println("**** MENU DE OPCIONES ****");
		System.out.println("1) Mostrar productos disponibles");
		System.out.println("2) Mostrar productos sin stock");
		System.out.println("3) Incrementar los precios de los productos en un 20%");
		System.out.println("4) Mostrar los productos pertenecientes a ELECTROHOGAR y con stock");
		System.out.println("5) Ordenar los productos por precio de forma descendente");
		System.out.println("6) Mostrar los productos con los nombres en Mayusculas");
		System.out.println("7) Salir del programa");
		System.out.println("Ingrese una opcion: ");
	}

	public static void mostrarLista(ArrayList<Producto> lista) {
		for (Producto producto : lista) {
			System.out.println(producto.mostrarDatosProducto());
		}
	}

	// OPCION 1

	public static void mostrarProductosDisponibles(ArrayList<Producto> lista) {

		for (Producto producto : lista) {
			if (producto.isEstado() == true) {
				Consumer<String> consumer = (String s) -> System.out.println(s + "\n");
				consumer.accept(producto.getDescripcion());
			}
		}
	}

	// OPCION 2

	public static void mostrarProductosNoDisponibles(ArrayList<Producto> lista) {
		Predicate<Producto> sinStock = producto -> producto.isEstado() == false;

		List<Producto> productosNoDisponibles = lista.stream().filter(sinStock).collect(Collectors.toList());

		System.out.println("Productos no disponibles: ");
		mostrarLista((ArrayList<Producto>) productosNoDisponibles);
	}

	// OPCION 3

	public static ArrayList<Producto> incrementarPrecios(ArrayList<Producto> lista) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia!!\n");
			return null;
		} else {
			ArrayList<Producto> nuevaLista = new ArrayList<>();
			nuevaLista = (ArrayList<Producto>) lista.stream().map(producto -> {
				double aumento = producto.getPrecioUnitario() * 1.20;
				producto.setPrecioUnitario(aumento);
				return producto;
			}).collect(Collectors.toList());
			return nuevaLista;
		}
	}

	// OPCION 4

	public static void mostrarPorCategoria(ArrayList<Producto> lista, categoria cat) {

		Predicate<Producto> porCategoria = producto -> producto.getCategoria() == cat;
		Predicate<Producto> conStock = producto -> producto.isEstado() == true;

		Predicate<Producto> filtro = porCategoria.and(conStock);

		List<Producto> nuevaLista = lista.stream().filter(filtro).collect(Collectors.toList());

		System.out.println("Productos pertenecientes a la categoria " + cat + ": ");
		mostrarLista((ArrayList<Producto>) nuevaLista);
	}

	// OPCION 5

	public static void ordenarListaDescendente(ArrayList<Producto> lista) {
		ArrayList<Producto> productosOrdenados = lista;
		productosOrdenados.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
		mostrarLista(productosOrdenados);
	}

	// OPCION 6

	public static void productosEnMayusculas(ArrayList<Producto> lista) {
		List<Producto> nuevaLista = lista.stream().map(producto -> {
			return producto;
		}).collect(Collectors.toList());

		for (Producto producto : nuevaLista) {
			System.out.println("Producto : " + producto.getDescripcion().toUpperCase());
		}
	}

	// OPCION 7

	public static void salir() {
		System.out.println("Saliendo del programa...");
	}

}
