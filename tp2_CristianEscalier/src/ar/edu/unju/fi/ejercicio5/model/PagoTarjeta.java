package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import java.time.LocalDate;

public class PagoTarjeta implements Pago {
	
	private String numeroDeTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;
	
	public PagoTarjeta(String numeroDeTarjeta, LocalDate fechaDePago) {
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.fechaDePago = fechaDePago;
	}
	
	public String getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto*1.15;
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("Numero de tarjeta: " + numeroDeTarjeta);
		System.out.println("Fecha de pago: " + fechaDePago);
		System.out.println("Monto Pagado: $ " + montoPagado);
	}
	

}
