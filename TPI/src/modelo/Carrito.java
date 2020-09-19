package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito>lstItemCarrito;
	private Entrega entrega;
	
	public Carrito(int id, LocalDate fecha, boolean cerrado, double descuento,
			Cliente cliente, List<ItemCarrito> lstItemCarrito, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = lstItemCarrito;
		this.entrega = entrega;
	}
	public Carrito(){
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}
	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	@Override
	public String toString() {
		return "Carrito ID : " + id + ", Fecha : " + fecha + ", Estado Cerrado : "
				+ cerrado + ", Descuento : " + descuento + ", Cliente : " + cliente
				+ ", ItemCarrito : " + lstItemCarrito + ", Entrega : " + entrega
				+ ", ";
	}

}
