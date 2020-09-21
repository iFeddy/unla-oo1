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
	
// ITEM CARRITO
    // AGREGAR ITEM
 	public boolean agregarItem(Articulo articulo, int cantidad)throws Exception{
 		ItemCarrito itemcarrito = null;
		boolean itemAgregado = false;
		int i = 0;
		while (itemcarrito == null && i < lstItemCarrito.size()) {
			ItemCarrito item = lstItemCarrito.get(i);
			if (articulo.getId() == lstItemCarrito.get(i).getArticulo().getId()) {
				itemcarrito = item;
				itemAgregado = true;
				int nuevaCantidad = lstItemCarrito.get(i).getCantidad()+cantidad;
				lstItemCarrito.get(i).setCantidad(nuevaCantidad);
			}
			i++;			
		}
		if (!itemAgregado) {
			ItemCarrito p = new ItemCarrito(articulo,cantidad);				
			lstItemCarrito.add(p);			
			}		
		return itemAgregado;		
	}
 	
 	// MMOSTRAR ITEM
 	public List<ItemCarrito> mostrarItem(Carrito carrito){
 		List<ItemCarrito> mostrar = new ArrayList<ItemCarrito>();
 		for(ItemCarrito p : carrito.getLstItemCarrito()){
 			mostrar.add(p);
 		}
 		return mostrar;
 	}
 	
 	// ELIMINAR ITEM
 	public boolean eliminarItem(Articulo articulo, int cantidad)throws Exception{
 		ItemCarrito itemcarrito = null;
		boolean itemEliminado = false;
		int i = 0;
		while (itemcarrito == null && i < lstItemCarrito.size()) {
			ItemCarrito item = lstItemCarrito.get(i);
			if (articulo.getId() == lstItemCarrito.get(i).getArticulo().getId()) {
				itemcarrito = item;
				itemEliminado = true;
				if(lstItemCarrito.get(i).getCantidad()== cantidad){
					int nuevaCantidad = lstItemCarrito.get(i).getCantidad()-cantidad;
					lstItemCarrito.get(i).setCantidad(nuevaCantidad);
					lstItemCarrito.remove(i);
					System.out.println("Se elimino el item del carrito , ya que la cantidad a eliminar es la misma");
				}	
			}
		}
			i++;
			if (!itemEliminado) {
				throw new Exception("Item no encontrado ni eliminado");
				}
			return itemEliminado;
		}

}

