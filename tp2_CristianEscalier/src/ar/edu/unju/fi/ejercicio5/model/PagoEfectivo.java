package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import java.time.LocalDate;

public class PagoEfectivo implements Pago{
	
	private double montoPagado;
	private LocalDate fechaDePago;
	
	public PagoEfectivo(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	
	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto * 0.90;
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de Pago: " + fechaDePago);
		System.out.println("Monto pagado: $ " + montoPagado);
	}

}
