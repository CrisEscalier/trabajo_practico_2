package ar.edu.unju.fi.ejercicio1.model;

public class Producto {

	public static enum origenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}

	public static enum categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}

	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private origenFabricacion origen;
	private categoria cat;
	private boolean estado;

	public Producto() {
	}

	public Producto(int codigo, String descripcion, double precioUnitario, int origenOpcion,
			int categoriaOpcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = obtenerOrigenDeFabricacion(origenOpcion);
		this.cat = obtenerCategoria(origenOpcion);
		this.estado = false;
	}
	
	public Producto(int codigo, String descripcion, double precioUnitario, origenFabricacion origen, categoria cat,
			boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.cat = cat;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public origenFabricacion getOrigen() {
		return origen;
	}

	public void setOrigen(origenFabricacion origen) {
		this.origen = origen;
	}

	public categoria getCategoria() {
		return cat;
	}

	public void setCategoria(categoria categoria) {
		this.cat = categoria;
	}
	
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public categoria obtenerCategoria(int opcion) {
		switch (opcion) {
		case 1:
			return categoria.TELEFONIA;
		case 2:
			return categoria.INFORMATICA;
		case 3:
			return categoria.ELECTROHOGAR;
		case 4:
			return categoria.HERRAMIENTAS;
		default:
			return null;
		}
	}

	public origenFabricacion obtenerOrigenDeFabricacion(int opcion) {
		switch (opcion) {
		case 1:
			return origenFabricacion.ARGENTINA;
		case 2:
			return origenFabricacion.CHINA;
		case 3:
			return origenFabricacion.BRASIL;
		case 4:
			return origenFabricacion.URUGUAY;
		default:
			return null;
		}
	}

	public String mostrarDatosProducto() {
		return "Producto: \nCodigo = " + codigo + "\nDescripcion = " + descripcion + "\nPrecio Unitario = "
				+ precioUnitario + "\nOrigen = " + origen.toString() + "\nCategoria = " + cat.toString() + "\n";
	}

}
