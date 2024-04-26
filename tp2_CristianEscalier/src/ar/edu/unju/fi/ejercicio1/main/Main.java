package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Producto> listaDeProductos = new ArrayList<>();
		int opcion;

		do {
			menu();
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				opcion = 0;
				System.out.println("Debe ingresar un numero entero");
			}
			switch (opcion) {
			case 0:
				sc.next();
				break;
			case 1:
				crearProducto(listaDeProductos, sc);
				break;
			case 2:
				mostrarProductos(listaDeProductos);
				break;
			case 3:
				modificarProducto(listaDeProductos, sc);
				break;
			case 4:
				salir();
				break;
			default:
				System.out.println("Opcion incorrecta");
			}

		} while (opcion != 4);

		sc.close();

	}

	public static void menu() {
		System.out.println("***** MENU DE OPCIONES *****");
		System.out.println("1- Crear Producto");
		System.out.println("2- Mostrar Productos");
		System.out.println("3- Modificar Producto");
		System.out.println("4- Salir");
		System.out.println("Eliga una opcion: ");
	}

	// OPCION 1
	public static void crearProducto(ArrayList<Producto> lista, Scanner sc) {

		try {

			int codigo = generarCodigoAleatorio();
			System.out.println("Codigo autogenerado: " + codigo);
			System.out.println("Ingrese la descripcion del producto: ");
			sc.nextLine();
			String descripcion = sc.nextLine();

			System.out.println("Ingrese el precio unitario: ");
			double precio = sc.nextDouble();
			mostrarOrigenesDeFabricacion();
			int opcionOrigen = sc.nextInt();

			mostrarCategorias();
			int opcionCategoria = sc.nextInt();

			Producto producto = new Producto(codigo, descripcion, precio, opcionOrigen, opcionCategoria);

			if (producto.getOrigen() == null) {
				System.out.println("Origen incorrecto!");
			}
			if (producto.getCategoria() == null) {
				System.out.println("Categoria incorrecta!");
			} else {
				System.out.println("Producto agregado correctamente\n");
				lista.add(producto);
			}

		} catch (Exception e) {
			sc.next();
			System.out.println("Ingreso invalido de datos!\n");
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

	public static void mostrarOrigenesDeFabricacion() {
		System.out.println("---- Origen de fabricacion ----\n");
		System.out.println("     1- Argentina");
		System.out.println("     2- China");
		System.out.println("     3- Brasil");
		System.out.println("     4- Uruguay");
		System.out.println("Eliga una opcion: ");
	}

	public static void mostrarCategorias() {
		System.out.println("---- Categoria ----\n");
		System.out.println("     1- Telefonia");
		System.out.println("     2- Informatica");
		System.out.println("     3- Electro hogar");
		System.out.println("     4- Herramientas");
		System.out.println("Eliga una opcion: ");
	}

	// OPCION 2
	public static void mostrarProductos(ArrayList<Producto> lista) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia");
		}
		for (Producto producto : lista) {
			System.out.println(producto.mostrarDatosProducto());
		}
	}

	// OPCION 3
	public static void modificarProducto(ArrayList<Producto> lista, Scanner sc) {
		if (lista.isEmpty()) {
			System.out.println("Lista vacia");
		} else {
			try {
				System.out.print("Ingrese el codigo del producto: ");
				int codigo = sc.nextInt();
				int indice = buscarProducto(lista, codigo);
				if (indice == -1) {
					System.out.println("Codigo de producto inexistente!");
				} else {
					Producto producto = lista.get(indice);
					int opcion;
					menuDeModificaciones();
					try {
						opcion = sc.nextInt();
					} catch (Exception e) {
						opcion = 0;
						System.out.println("Debe ingresar un numero entero");
					}

					switch (opcion) {
					case 0:
						sc.next();
						break;
					case 1:

						System.out.println("Ingrese la nueva descripcion del producto: ");
						sc.nextLine();
						String nuevaDescripcion = sc.nextLine();
						producto.setDescripcion(nuevaDescripcion);
						System.out.println("Modificacion exitosa!\n");
						break;
					case 2:
						System.out.println("Ingrese el nuevo precio unitario del producto: ");
						double nuevoPrecio = sc.nextDouble();
						producto.setPrecioUnitario(nuevoPrecio);
						System.out.println("Modificacion exitosa!\n");

						break;
					case 3:
						mostrarOrigenesDeFabricacion();
						int nuevoOrigen = sc.nextInt();
						if (producto.obtenerOrigenDeFabricacion(nuevoOrigen) == null)
							System.out.println("Origen inexsitente!\n");
						else {
							producto.setOrigen(producto.obtenerOrigenDeFabricacion(nuevoOrigen));
							System.out.println("Modificacion exitosa!\n");
						}
						break;
					case 4:
						mostrarCategorias();
						int nuevaCategoria = sc.nextInt();
						if (producto.obtenerCategoria(nuevaCategoria) == null)
							System.out.println("Categoria inexistene!\n");
						else {
							producto.setCategoria(producto.obtenerCategoria(nuevaCategoria));
							System.out.println("Modificacion exitosa!\n");
						}
						break;
					default:
						System.out.println("Opcion incorrecta!");
					}

				}

			} catch (Exception e) {
				System.out.println("Ingreso invalido de datos\n");
			}

		}

	}

	public static void menuDeModificaciones() {
		System.out.println("\n***** MENU DE MODIFICACIONES *****");
		System.out.println("1- Modificar descripcion");
		System.out.println("2- Modificar precio unitario");
		System.out.println("3- Modificar origen de fabricacion");
		System.out.println("4- Modificar categoria");
		System.out.println("Ingrese una opcion:");
	}

	/**
	 * Metodo que busca un producto en la lista segun el codigo del producto
	 * 
	 * @param lista  de productos
	 * @param codigo del producto
	 * @return indice del producto en la lista
	 */
	public static int buscarProducto(ArrayList<Producto> lista, int codigo) {
		for (int i = 0; i < lista.size(); i++) {
			Producto producto = lista.get(i);
			if (producto.getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
	}

	// OPCION 4
	public static void salir() {
		System.out.println("Saliendo del programa...");
	}

}
